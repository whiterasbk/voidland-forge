package whiter.mod.voidland

import net.minecraft.block.material.Material
import org.reflections.Reflections
import whiter.mod.voidland.annotation.RegisterBlock
import whiter.mod.voidland.util.AnnotationScanner

fun main(args: Array<String>) {

    val set = AnnotationScanner.getAnnotationClasses("whiter.mod.voidland.block.base", RegisterBlock::class.java)
    print(set)
//    入参 要扫描的包名

    val f = Reflections("whiter.mod.voidland.block.base")

//入参 目标注解类
    val fset=f.getTypesAnnotatedWith(RegisterBlock::class.java)
    print(fset)
}