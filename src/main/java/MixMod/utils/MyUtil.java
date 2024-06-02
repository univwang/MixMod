package MixMod.utils;

public class MyUtil {
    public static final String  LocalizationPath = "ModExampleResources/localization/";

    public static final String modName = "ExampleMod:";

    public static String makeCardId(String id) {
        return modName + id;
    }

    public static String makeCharId(String id) {
        return modName + id;
    }
}
