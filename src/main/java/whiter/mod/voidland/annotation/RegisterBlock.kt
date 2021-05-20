package whiter.mod.voidland.annotation

import whiter.mod.voidland.VlCreativeTabs


@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
internal annotation class RegisterBlock(val name: String = "", val unlocalizedName: String = "", val tab: VlCreativeTabs = VlCreativeTabs.voidland_defaut, val isItemBlock: Boolean = true, val hasModel: Boolean = true, val burnTime:Int = 0) {

}