package MixMod.modcore;

import MixMod.character.LController;
import MixMod.character.LControllerColor;
import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.CardCrawlGame;


@SpireInitializer
public class CharacterController implements EditCharactersSubscriber {
    public CharacterController() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new CharacterController();
    }

    @Override
    public void receiveEditCharacters() {
        // 向basemod注册人物
//        BaseMod.addCharacter(new MyCharacter(CardCrawlGame.playerName), MY_CHARACTER_BUTTON, MY_CHARACTER_PORTRAIT, MY_CHARACTER);
        BaseMod.addCharacter(new LController(CardCrawlGame.playerName), LControllerColor.CHARACTER_BUTTON, LControllerColor.CHARACTER_PORTRAIT, LController.Enums.CHARACTER);
    }

}
