package whiter.mod.voidland.annotation


@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
internal annotation class RegisterBlock(val name: String) {

}