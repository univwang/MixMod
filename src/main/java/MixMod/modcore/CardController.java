package MixMod.modcore;

import MixMod.cards.LC.Power;
import MixMod.character.LController;
import MixMod.character.MyColor;
import MixMod.variables.GrowVariable;
import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.helpers.dynamicvariables.DamageVariable;
import basemod.interfaces.EditCardsSubscriber;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

@SpireInitializer
public class CardController implements EditCardsSubscriber {
    public static final Color MY_COLOR = new Color(248.0F / 255.0F, 250.0F / 255.0F, 57.0F / 255.0F, 1.0F);

    public CardController() {
        BaseMod.subscribe(this);
        BaseMod.addDynamicVariable(new GrowVariable());
        BaseMod.addDynamicVariable(new DamageVariable());
        BaseMod.addColor(LController.Enums.CARD_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR,
                MyColor.BG_ATTACK_512,MyColor.BG_SKILL_512,MyColor.BG_POWER_512,
                MyColor.ENEYGY_ORB,MyColor.BG_ATTACK_1024,MyColor.BG_SKILL_1024,
                MyColor.BG_POWER_1024,MyColor.BIG_ORB,MyColor.SMALL_ORB);
    }
    // 注解需要调用的方法，必须写
    public static void initialize() {
        new CardController();
    }


    @Override
    public void receiveEditCards() {
        new AutoAdd("MixMod")
                .packageFilter(Power.class)
                .setDefaultSeen(true)
                .cards();
    }
}
