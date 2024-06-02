package MixMod.utils;

public class ImgHelper {
    private static final String rootResource = "ModExampleResources/img/";
    public static String getCardImgPath(String imgName) {
        String pre = rootResource + "cards/";
        return pre + imgName;
    }
    public static String getCharPath(String imgName) {
        return rootResource + "char/" + imgName;
    }

    public static String getUIPath(String imgName) {
        return rootResource + "UI/" + imgName;
    }

    public static String getRelicPath(String imgName) {
        return rootResource + "relics/" + imgName;
    }

    public static String getPowPath(String imgName) {
        return rootResource + "powers/" + imgName;
    }
}
