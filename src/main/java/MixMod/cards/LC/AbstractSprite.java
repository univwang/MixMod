package MixMod.cards.LC;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public abstract class AbstractSprite extends CustomCard {

    public AbstractSprite(String id, String name, String img, int cost, String rawDescription, CardType type, CardColor color, CardRarity rarity, CardTarget target) {
        super(id, name, img, cost, rawDescription, type, color, rarity, target);
    }
    @Override
    public void upgrade() {

    }
    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }
    //所有的精灵牌都要继承这张牌

    //提供融合方法，很多个sprite可以融合成一张
    public static MixSprite mixSprite(List<AbstractSprite> sprites, int count) {
        //TODO 融合词条
        MixSprite mixSprite = new MixSprite();
        int n = sprites.size();
        List<AbstractSprite> sprites_tmp = new ArrayList<>();
        for(int i = n - 1; i >= 0 && count > 0; i --, count -- ) {
            sprites_tmp.add(sprites.get(i));
        }

        for(AbstractSprite sprite: sprites_tmp) {
            mixSprite.baseDamage += sprite.baseDamage;
            mixSprite.cost += sprite.cost;
        }
        mixSprite.damage = mixSprite.baseDamage;
        mixSprite.costForTurn = mixSprite.cost;


        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for(AbstractSprite sprite: sprites_tmp) {
            set.add(sprite.name.charAt(0));
        }
        for(Character s: set) sb.append(s);
        mixSprite.name = sb + "灵兽";
        return mixSprite;
    }
}
