package MixMod.cards.LC;

import MixMod.utils.ImgHelper;
import MixMod.utils.MyUtil;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MixSprite extends AbstractSprite {

//    private static final CardColor COLOR = EXAMPLE_CARD;
    public static final String ID = MyUtil.makeCardId(MixSprite.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = CARD_STRINGS.NAME;
    private static final String IMG_PATH = ImgHelper.getCardImgPath("LC/MixSprite.png");
    private static final int COST = 0;
    private static final String DESCRIPTION = CARD_STRINGS.DESCRIPTION;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public MixSprite(String Description) {
        super(ID, NAME, IMG_PATH, COST, Description, TYPE, COLOR, RARITY, TARGET);
        this.damage = this.baseDamage = 0;
    }
    public MixSprite() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.damage = this.baseDamage = 0;
    }

    @Override
    public void upgrade() {
        upgraded = true;
        initializeDescription();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
    }

    @Override
    public AbstractCard makeStatEquivalentCopy() {
        //不复制了，直接返回构建的mixSprite
        return this;
//        AbstractCard abstractCard = super.makeStatEquivalentCopy();
//        abstractCard.rawDescription = rawDescription;
//        abstractCard.initializeDescription(); //是新卡牌初始化，不是旧卡牌初始化。
//        return abstractCard;
    }

    @Override
    public void triggerWhenCopied() {
        super.triggerWhenCopied();
    }

    @Override
    public void applyGrow() {
        this.upgradeDamage(this.grow);
    }



}
