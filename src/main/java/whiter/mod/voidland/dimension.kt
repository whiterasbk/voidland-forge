package whiter.mod.voidland

import net.minecraft.world.DimensionType
import net.minecraft.world.WorldProvider

class VlWorldProvider : WorldProvider() {
    override fun getDimensionType(): DimensionType {
        return vl.dimType
    }
}