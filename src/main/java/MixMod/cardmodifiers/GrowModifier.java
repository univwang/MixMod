package MixMod.cardmodifiers;

import MixMod.cards.LC.AbstractSprite;
import basemod.abstracts.AbstractCardModifier;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import lombok.extern.slf4j.Slf4j;

/**
 * 成长卡更新器
 * 在卡牌triggerOnEndOfPlayerTurn时触发
 */

@Slf4j
public class GrowModifier extends AbstractCardModifier {
    @Override
    public AbstractCardModifier makeCopy() {
        return new GrowModifier();
    }

    @Override
    public void atEndOfTurn(AbstractCard card, CardGroup group) {
        //更新成长词条
        if (AbstractDungeon.player.hand.group.contains(card)) {
            ((AbstractSprite) card).applyGrow();
//            log.info("在手牌中，更新成长");
        }
    }
}
