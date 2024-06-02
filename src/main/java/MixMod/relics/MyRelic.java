package MixMod.relics;

import MixMod.utils.ImgHelper;
import MixMod.utils.MyUtil;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MyRelic extends CustomRelic {
    // 遗物ID（此处的ModHelper在“04 - 本地化”中提到）
    public static final String ID = MyUtil.makeCardId("MyRelic");
    // 图片路径
    private static final String IMG_PATH = ImgHelper.getRelicPath("MyRelic.png");
    // 遗物类型
    private static final RelicTier RELIC_TIER = RelicTier.STARTER;
    // 点击音效
    private static final LandingSound LANDING_SOUND = LandingSound.FLAT;

    public MyRelic() {
        super(ID, ImageMaster.loadImage(IMG_PATH), RELIC_TIER, LANDING_SOUND);
    }

    // 获取遗物描述，但原版游戏只在初始化和获取遗物时调用，故该方法等于初始描述
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    public AbstractRelic makeCopy() {
        return new MyRelic();
    }

    @Override
    public void atBattleStart() {
        super.atBattleStart();
        this.addToBot(new DrawCardAction(1));
    }
}
