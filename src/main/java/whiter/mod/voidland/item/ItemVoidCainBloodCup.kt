package whiter.mod.voidland.item

import net.minecraft.client.util.ITooltipFlag
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import whiter.mod.voidland.annotation.RegisterItem
import javax.annotation.Nullable

@RegisterItem
class ItemVoidCainBloodCup: Item() {
    @SideOnly(Side.CLIENT)
    override fun addInformation(stack: ItemStack?, @Nullable player: World?, tooltip: MutableList<String>, advanced: ITooltipFlag?) {
        tooltip.add("使用后血杯消失，使用该物品会获得中立效果亡灵生物变的友好，无法解除仇恨攻击敌人还是会造成仇恨，使用后会获得抗性＋3回复＋3的效果对非亡灵生物伤害提升300％效果持续到玩家死亡，使用回复自身全部饱食度")
    }

}