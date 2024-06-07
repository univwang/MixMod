package MixMod.variables;

import MixMod.cards.LC.AbstractSprite;
import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrowVariable extends DynamicVariable {
    @Override
    public String key() {
        return "G";
        // What you put in your localization file between ! to show your value. Eg, !myKey!.
    }


    //修改后高亮，获取当前的value值
    @Override
    public boolean isModified(AbstractCard card) {
//        log.info("isMod " + ((AbstractSprite) card).isGrowModified);

        return ((AbstractSprite) card).isGrowModified;
        // Set to true if the value is modified from the base value.
    }

    //图书馆打对勾
    @Override
    public void setIsModified(AbstractCard card, boolean v) {
        // Do something such that isModified will return the value v.
        // This method is only necessary if you want smith upgrade previews to function correctly.
//        log.info("setIsMod " + v);

        ((AbstractSprite) card).isGrowModified = v;
    }

    //当前value
    @Override
    public int value(AbstractCard card) {
//        log.info("Value " + String.valueOf(((AbstractSprite) card).grow));
        return ((AbstractSprite) card).grow;
        // What the dynamic variable will be set to on your card. Usually uses some kind of int you store on your card.
    }

    //基础value
    @Override
    public int baseValue(AbstractCard card) {
//        log.info("baseValue " + String.valueOf(((AbstractSprite) card).baseGrow));
        return ((AbstractSprite) card).baseGrow;
        // Should generally just be the above.
    }

    @Override
    public boolean upgraded(AbstractCard card) {
//        log.info("upgraded " + String.valueOf(((AbstractSprite) card).baseGrow));
        return  ((AbstractSprite) card).upgradedGrow;
        // Should return true if the card was upgraded and the value was changed
    }
}