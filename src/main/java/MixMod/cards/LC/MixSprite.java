package MixMod.cards.LC;

import MixMod.utils.ImgHelper;
import MixMod.utils.MyUtil;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DescriptionLine;
import com.megacrit.cardcrawl.cards.tempCards.Miracle;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.cardManip.CardFlashVfx;
import lombok.extern.slf4j.Slf4j;

import static MixMod.character.MyCharacter.Enums.EXAMPLE_CARD;

@Slf4j
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
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        this.initializeDescription();
    }

    @Override
    public AbstractCard makeStatEquivalentCopy() {
        AbstractCard abstractCard = super.makeStatEquivalentCopy();
        abstractCard.rawDescription = rawDescription;
        log.info("复制 " + rawDescription);
        abstractCard.initializeDescription(); //是新卡牌初始化，不是旧卡牌初始化。
        for (DescriptionLine descriptionLine : this.description) {
            log.info(descriptionLine.getText());
        }
        return abstractCard;
    }

    @Override
    public void triggerWhenCopied() {
        super.triggerWhenCopied();
//        log.info("ShowCardAndAddToHandEffect " + rawDescription);
//        for (DescriptionLine descriptionLine : this.description) {
//            log.info(descriptionLine.getText());
//        }
//        this.initializeDescription();
    }
}
