package whiter.mod.voidland

import net.minecraft.block.material.Material
import org.reflections.Reflections
import scala.Function0
import whiter.mod.voidland.annotation.RegisterBlock
import whiter.mod.voidland.util.AnnotationScanner

fun main(args: Array<String>) {



    val m = "ABlockMainBlock"

    if (m.startsWith("Block")) {
        print(name2_Case(m.substring("Block".length)))
    } else {
        print(name2_Case(m))
    }
    
    

//    val set = AnnotationScanner.getAnnotationClasses("whiter.mod.voidland.block.base", RegisterBlock::class.java)
//    print(set)
////    入参 要扫描的包名
//
//    val f = Reflections("whiter.mod.voidland.block.base")
//
////入参 目标注解类
//    val fset=f.getTypesAnnotatedWith(RegisterBlock::class.java)
//    print(fset)
}

fun name2_Case(m: String): String {
    val a = StringBuffer()
    for(i in m) {
        if (i in 'A'..'Z') {
            a.append("_").append(i.toString().toLowerCase())
        } else {
            a.append(i)
        }
    }

    val r = a.toString()
    return if (r.startsWith("_")) {
        r.replaceFirst("_", "")
    } else {
        r
    }
}