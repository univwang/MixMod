package MixMod.modcore;

import MixMod.relics.MyRelic;
import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.EditRelicsSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

@SpireInitializer
public class RelicsController implements EditRelicsSubscriber {
    @Override
    public void receiveEditRelics() {
        BaseMod.addRelic(new MyRelic(), RelicType.SHARED); // RelicType表示是所有角色都能拿到的遗物，还是一个角色的独有遗物
    }

    public RelicsController() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new RelicsController();
    }

}
