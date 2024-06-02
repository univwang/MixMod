package MixMod.modcore;


import MixMod.utils.MyUtil;
import basemod.BaseMod;
import basemod.interfaces.EditKeywordsSubscriber;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.Keyword;

import java.nio.charset.StandardCharsets;

import static com.megacrit.cardcrawl.core.Settings.language;

@SpireInitializer
public class KeyWordController implements EditKeywordsSubscriber {
    public KeyWordController() {
        BaseMod.subscribe(this);
    }
    public static void initialize() {
        new KeyWordController();
    }


    @Override
    public void receiveEditKeywords() {
        Gson gson = new Gson();
        String lang = "ENG";
        if (language == Settings.GameLanguage.ZHS) {
            lang = "ZHS";
        }
        String keyPath = MyUtil.LocalizationPath + lang + "/keywords.json";
        String json = Gdx.files.internal(keyPath)
                .readString(String.valueOf(StandardCharsets.UTF_8));
        Keyword[] keywords = gson.fromJson(json, Keyword[].class);
        if (keywords != null) {
            for (Keyword keyword : keywords) {
                // 这个id要全小写
                BaseMod.addKeyword("mixmod", keyword.NAMES[0], keyword.NAMES, keyword.DESCRIPTION);
            }
        }
    }
}
