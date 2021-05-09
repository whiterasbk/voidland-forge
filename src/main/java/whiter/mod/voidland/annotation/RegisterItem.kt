package whiter.mod.voidland.annotation

import whiter.mod.voidland.VlCreativeTabs

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
internal annotation class RegisterItem(val name: String = "", val unlocalizedName: String = "", val tab: VlCreativeTabs = VlCreativeTabs.voidland_defaut, val hasModel: Boolean = true) {

}
