package whiter.mod.voidland

import net.minecraft.block.material.Material

fun main(args: Array<String>) {

    val sample_item = ItemBase("sample_item")
    val sampel_block = BlockSample()
    val block_sieve = BlockBaseWithItem(Material.WOOD, "block_sieve")
    
    print(blocks.list)
}