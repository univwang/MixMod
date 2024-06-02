package MixMod.modcore;

import MixMod.utils.MyUtil;
import basemod.BaseMod;
import basemod.interfaces.EditStringsSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;

@SpireInitializer
public class StringController implements EditStringsSubscriber {
    public StringController() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new StringController();
    }

    @Override
    public void receiveEditStrings() {
        String lang;
        if (Settings.language == Settings.GameLanguage.ZHS) {
            lang = "ZHS"; // 如果语言设置为简体中文，则加载ZHS文件夹的资源
        } else {
            lang = "ENG"; // 如果没有相应语言的版本，默认加载英语
        }
        BaseMod.loadCustomStringsFile(CardStrings.class, MyUtil.LocalizationPath + lang + "/cards.json"); // 加载相应语言的卡牌本地化内容。
        BaseMod.loadCustomStringsFile(CharacterStrings.class, MyUtil.LocalizationPath + lang + "/characters.json");
        BaseMod.loadCustomStringsFile(RelicStrings.class, MyUtil.LocalizationPath + lang + "/relics.json");
        BaseMod.loadCustomStringsFile(PowerStrings.class, MyUtil.LocalizationPath + lang + "/powers.json");

    }
}
