package MixMod.cards.LC;

import MixMod.cardmodifiers.GrowModifier;
import MixMod.character.LController;
import basemod.abstracts.CustomCard;
import basemod.helpers.CardModifierManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class AbstractSprite extends CustomCard {
    protected final static CardColor COLOR = LController.Enums.CARD_COLOR;

    //成长词条
    public int baseGrow;
    public boolean isGrowModified;
    public int grow;
    public boolean upgradedGrow;

    public AbstractSprite(String id, String name, String img, int cost, String rawDescription, CardType type, CardColor color, CardRarity rarity, CardTarget target) {
        super(id, name, img, cost, rawDescription, type, color, rarity, target);
    }

    //所有的精灵牌都要继承这张牌

    //提供融合方法，很多个sprite可以融合成一张
    public static MixSprite mixSprite(List<AbstractSprite> sprites, int count) {
        //TODO 融合词条
        MixSprite mixSprite = new MixSprite();


        //解析融合卡牌列表
        int n = sprites.size();
        List<AbstractSprite> sprites_tmp = new ArrayList<>();
        for(int i = n - 1; i >= 0 && count > 0; i --, count -- ) {
            sprites_tmp.add(sprites.get(i));
        }
        //更新伤害
        for(AbstractSprite sprite: sprites_tmp) {
            mixSprite.baseDamage += sprite.baseDamage;
            mixSprite.cost += sprite.cost;
            mixSprite.baseGrow += sprite.baseGrow;
        }
        mixSprite.damage = mixSprite.baseDamage;
        mixSprite.grow = mixSprite.baseGrow;
        mixSprite.costForTurn = mixSprite.cost;
        //更新描述
        //这里是无效的，抽卡后的描述使用的是new mixSprite()，这时候没有成长词条
        mixSprite.rawDescription += " NL mixmod:成长 增加 !G! 伤害。";

        //更新name
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for(AbstractSprite sprite: sprites_tmp) {
            set.add(sprite.name.charAt(0));
        }
        for(Character s: set) sb.append(s);
        mixSprite.name = sb + "灵兽";


        //添加成长更新器
        CardModifierManager.addModifier(mixSprite, new GrowModifier());

        return mixSprite;
    }

    protected void upgradeGrow(int amount) {
        this.grow += amount;
        this.upgradedGrow = true;
        this.isGrowModified = true; //更新值后需要手动修改
    }

    public void applyGrow() {

    }
}
