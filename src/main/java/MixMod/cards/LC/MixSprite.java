package MixMod.cards.LC;

import MixMod.power.MixPower;
import MixMod.utils.ImgHelper;
import MixMod.utils.MyUtil;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static MixMod.character.MyCharacter.Enums.EXAMPLE_CARD;

public class MixSprite extends AbstractSprite {

    private static final CardColor COLOR = EXAMPLE_CARD;
    public static final String ID = MyUtil.makeCardId(MixSprite.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = CARD_STRINGS.NAME;
    private static final String IMG_PATH = ImgHelper.getCardImgPath("LC/MixSprite.png");
    private static final int COST = 0;
    private static final String DESCRIPTION = CARD_STRINGS.DESCRIPTION;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public MixSprite() {

        //!D!,!B!,!M!分别被伤害数值、格挡数值、特殊值替代。
        //#b,#r,#g,#y,#p分别染成蓝色、红色、绿色、黄色、紫色。
        //[E]表示能量图标。
        //[E]表示能量图标。[R] [G] [P] [B]也是，但单只一个角色的。
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.damage = this.baseDamage = 0;
        //为卡牌添加标签
        //        HEALING, 治疗
        //        STRIKE, 打击
        //        EMPTY, 空
        //        STARTER_DEFEND, 基础打击
        //        STARTER_STRIKE; 基础防御
//        this.tags.add(CardTags.STARTER_STRIKE);
//        this.tags.add(CardTags.STRIKE);
    }
    @Override
    public void upgrade() {
//        if(!upgraded) {
//            this.upgradeName(); //卡牌名字变为"+"
//            this.upgradeDamage(3); //伤害提升3
////            this.isInnate = true; //固有属性
//            this.rawDescription = CARD_STRINGS.UPGRADE_DESCRIPTION;
//            this.initializeDescription();
//        }
    }

    /**
     *
     * @param p 玩家
     * @param m 怪物类（无指向包括攻击所有敌人为null）
     */
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL)));
    }
}
