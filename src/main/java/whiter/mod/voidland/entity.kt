package whiter.mod.voidland

import net.minecraft.entity.Entity
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World

open class EntityBase(world: World): Entity(world) {
    override fun writeEntityToNBT(compound: NBTTagCompound) {
        super.writeToNBT(compound)
    }

    override fun readEntityFromNBT(compound: NBTTagCompound) {
        super.readFromNBT(compound)
    }

    override fun entityInit() {

    }

}