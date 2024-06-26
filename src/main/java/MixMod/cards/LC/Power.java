package MixMod.cards.LC;

import MixMod.utils.ImgHelper;
import MixMod.utils.MyUtil;
import basemod.abstracts.CustomCard;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.BorderFlashEffect;
import com.megacrit.cardcrawl.vfx.combat.MiracleEffect;

import static MixMod.cards.LC.AbstractSprite.COLOR;

public class Power extends CustomCard {

//    private static final CardColor COLOR = EXAMPLE_CARD;
    public static final String ID = MyUtil.makeCardId(Power.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = CARD_STRINGS.NAME;
    private static final String IMG_PATH = ImgHelper.getCardImgPath("LC/power.png");
    private static final int COST = 1;
    private static final String DESCRIPTION = CARD_STRINGS.DESCRIPTION;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.BASIC;
    private static final CardTarget TARGET = CardTarget.SELF;

    public Power() {

        //!D!,!B!,!M!分别被伤害数值、格挡数值、特殊值替代。
        //#b,#r,#g,#y,#p分别染成蓝色、红色、绿色、黄色、紫色。
        //[E]表示能量图标。
        //[E]表示能量图标。[R] [G] [P] [B]也是，但单只一个角色的。
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
//        this.damage = this.baseDamage = 6;
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
        if(!upgraded) {
            this.upgradeName(); //卡牌名字变为"+"
//            this.upgradeDamage(3); //伤害提升3
//            this.isInnate = true; //固有属性
            this.rawDescription = CARD_STRINGS.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    /**
     *
     * @param p 玩家
     * @param m 怪物类（无指向包括攻击所有敌人为null）
     */
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!Settings.DISABLE_EFFECTS) {
            this.addToBot(new VFXAction(new BorderFlashEffect(Color.GOLDENROD, true)));
        }
        this.addToBot(new VFXAction(new MiracleEffect()));
        if (this.upgraded) {
            this.addToBot(new GainEnergyAction(4));
        } else {
            this.addToBot(new GainEnergyAction(2));
        }
    }
}
