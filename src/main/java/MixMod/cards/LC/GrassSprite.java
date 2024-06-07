package MixMod.cards.LC;

import MixMod.power.MixPower;
import MixMod.utils.ImgHelper;
import MixMod.utils.MyUtil;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrassSprite extends AbstractSprite {

//    private static final CardColor COLOR = EXAMPLE_CARD;
    public static final String ID = MyUtil.makeCardId(GrassSprite.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = CARD_STRINGS.NAME;
    private static final String IMG_PATH = ImgHelper.getCardImgPath("LC/GrassSprite.png");
    private static final int COST = 1;
    private static final String DESCRIPTION = CARD_STRINGS.DESCRIPTION;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public GrassSprite() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.damage = this.baseDamage = 2;
        this.grow = this.baseGrow = 2;
    }
    @Override
    public void upgrade() {
        if(!upgraded) {
            this.upgradeName();
            this.upgradeGrow(2);
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
        MixPower.Sprites.add(this);
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.LIGHTNING));
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new MixPower(p, 1)));
    }

    @Override
    public void triggerOnEndOfPlayerTurn() {
        //提升卡牌
        this.upgradeDamage(this.grow);
    }


}
