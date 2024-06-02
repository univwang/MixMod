package MixMod.variables;

/**
 *

public class MyVariable extends DynamicVariable {
    @Override
    public String key() {
        return "myKey";
        // What you put in your localization file between ! to show your value. Eg, !myKey!.
    }

    @Override
    public boolean isModified(AbstractCard card) {
        return myBoolean;
        // Set to true if the value is modified from the base value.
    }

    @Override
    public void setIsModified(AbstractCard card, boolean v) {
        // Do something such that isModified will return the value v.
        // This method is only necessary if you want smith upgrade previews to function correctly.
    }

    @Override
    public int value(AbstractCard card) {
        return myInt;
        // What the dynamic variable will be set to on your card. Usually uses some kind of int you store on your card.
    }

    @Override
    public int baseValue(AbstractCard card) {
        return myInt;
        // Should generally just be the above.
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        return myBoolean;
        // Should return true if the card was upgraded and the value was changed
    }
}
 */