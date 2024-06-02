package MixMod.power;

import MixMod.utils.ImgHelper;
import MixMod.utils.MyUtil;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class ExamplePower extends AbstractPower {
    // 能力的ID
    public static final String POWER_ID = MyUtil.makeCardId("ExamplePower");
    // 能力的本地化字段
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    // 能力的名称
    private static final String NAME = powerStrings.NAME;
    // 能力的描述
    private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;


    // 添加一大一小两张能力图
    private static final String path128 = ImgHelper.getPowPath("Example84.png");
    private static final String path48 =  ImgHelper.getPowPath("Example32.png");
    public ExamplePower(AbstractCreature owner, int Amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.BUFF;

        // 如果需要不能叠加的能力，只需将上面的Amount参数删掉，并把下面的Amount改成-1就行
        this.amount = Amount;


        this.region128 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path128), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path48), 0, 0, 32, 32);

        // 首次添加能力更新描述
        this.updateDescription();
    }

    // 能力在更新时如何修改描述
    public void updateDescription() {
        this.description = String.format(DESCRIPTIONS[0], this.amount); // 这样，%d就被替换成能力的层数
    }

    //被攻击时
    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        //非荆棘伤害、非生命流失、伤害来源不为空，伤害来源不是自己，伤害大于0
        if (info.type != DamageInfo.DamageType.THORNS && info.type != DamageInfo.DamageType.HP_LOSS && info.owner != null && info.owner != this.owner && damageAmount > 0) {
            //能力闪烁一下
            this.flash();
            this.addToTop(new HealAction(owner, owner, this.amount));
        }
        //返回原理的伤害
        return damageAmount;
    }
}
