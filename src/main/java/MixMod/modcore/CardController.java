package MixMod.modcore;

import MixMod.cards.LC.Power;
import MixMod.cards.Strike;
import MixMod.character.MyColor;
import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static MixMod.character.MyCharacter.Enums.EXAMPLE_CARD;

@SpireInitializer
public class CardController implements EditCardsSubscriber {
    public static final Color MY_COLOR = new Color(248.0F / 255.0F, 250.0F / 255.0F, 57.0F / 255.0F, 1.0F);

    public CardController() {
        BaseMod.subscribe(this);

        BaseMod.addColor(EXAMPLE_CARD, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR,
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
//        BaseMod.addCard(new Strike());
//        BaseMod.addCard(new Power());
        new AutoAdd("MixMod")
                .packageFilter(Power.class)
                .setDefaultSeen(true)
                .cards();
    }
}
