package whiter.mod.voidland.util

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import whiter.mod.voidland.*
import whiter.mod.voidland.annotation.RegisterBlock
import whiter.mod.voidland.annotation.RegisterItem

object AutoRegisters {
    fun registerBlock() {
        val cls = AnnotationScanner.getAnnotationClasses(vl.modpkgName + ".block", RegisterBlock::class.java)

        for (each in cls) {

            val cons = each.getConstructor()
            val blk = cons.newInstance()

            if (blk is Block) {

                // is block
                val anno = each.getAnnotation(RegisterBlock::class.java)

                val registerName =
                        if (anno.name != "") {
                            anno.name
                        } else {
                            if (each.simpleName.startsWith("Block")) {
                                util.name2_Case(each.simpleName.substring("Block".length))
                            } else {
                                util.name2_Case(each.simpleName)
                            }
                        }
                blk.registryName = ResourceLocation(vl.modid, registerName)

                blk.unlocalizedName = vl.modid + "." + (if (anno.unlocalizedName != "") { anno.unlocalizedName } else { registerName })

                // default
                blk.setCreativeTab(anno.tab.get())
                blocks.map[blk.registryName.toString()] = blk

                if (anno.hasModel) {
                    blocks.tobeInitModel[blk.registryName.toString()] = blk
                }

                if (anno.isItemBlock) {
                    items.map[blk.registryName.toString()] = ItemBlockBase(blk)
                }

                if (anno.burnTime != 0) {
                    smelt.addBurnMap(blk.registryName.toString(), anno.burnTime)
                }

//                println("vlregister: $blk name: ${blk.registryName}")

            } else {
                throw IllegalAccessException("not a block")
            }
        }
    }

    fun registerItem() {
        val cls = AnnotationScanner.getAnnotationClasses(vl.modpkgName + ".item", RegisterItem::class.java)

        for (each in cls) {

            val cons = each.getConstructor()
            val item = cons.newInstance()

            if (item is Item) {

                // is block
                val anno = each.getAnnotation(RegisterItem::class.java)

                val registerName =
                        if (anno.name != "") {
                            anno.name
                        } else {
                            if (each.simpleName.startsWith("Item")) {
                                util.name2_Case(each.simpleName.substring("Item".length))
                            } else {
                                util.name2_Case(each.simpleName)
                            }
                        }
                item.registryName = ResourceLocation(vl.modid, registerName)

                item.unlocalizedName = vl.modid + "." + (if (anno.unlocalizedName != "") { anno.unlocalizedName } else { registerName })

                // default
                item.creativeTab = anno.tab.get()
                items.map[item.registryName.toString()] = item

                if (anno.hasModel) {
                    items.tobeInitModel[item.registryName.toString()] = item
                }

                if (anno.burnTime != 0) {
                    smelt.addBurnMap(item.registryName.toString(), anno.burnTime)
                }

//                println("vlregister: $item name: ${item.registryName}")

            } else {
                throw IllegalAccessException("not a item")
            }
        }
    }
}