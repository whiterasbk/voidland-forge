package whiter.mod.voidland.gsys

enum class WuxingProperty {
    Metal,
    Wood,
    Water,
    Fire,
    Dirt
}



interface IHasWuxingProperty {
    var property: WuxingProperty
    var quantity: Int

    /*
    * 转换五行属性
    * 但是同一个物品能不能转换属性还有待争议
     */
    fun switchProperty(property: WuxingProperty) {
        this.property = property

    }

    /**
     * 获取相克的属性
     * @return 相克的属性
     */
    fun restraintProperty() : WuxingProperty {
        return when(property) {
            WuxingProperty.Fire -> WuxingProperty.Metal
            WuxingProperty.Water -> WuxingProperty.Fire
            WuxingProperty.Dirt -> WuxingProperty.Water
            WuxingProperty.Wood -> WuxingProperty.Dirt
            WuxingProperty.Metal -> WuxingProperty.Wood
        }
    }

    /**
     * 获取相生的属性
     * @return 相生的属性
     */
    fun coexistProperty() : WuxingProperty {
        return when(property) {
            WuxingProperty.Fire -> WuxingProperty.Dirt
            WuxingProperty.Water -> WuxingProperty.Wood
            WuxingProperty.Dirt -> WuxingProperty.Metal
            WuxingProperty.Wood -> WuxingProperty.Fire
            WuxingProperty.Metal -> WuxingProperty.Water
        }
    }

    /**
     * 获取攻击附加值
     * @param enemyProperty 敌方的五行属性
     * @param quantity 属性的值
     * todo 应该根据五行属性的相生相克来确定攻击的附加值
     */
    fun additionalAttack(enemyProperty: WuxingProperty, quantity: Int) : Int {
        return when(enemyProperty) {
//            WuxingProperty.Fire -> {0}
//            WuxingProperty.Water -> {0}
//            WuxingProperty.Dirt -> {0}
//            WuxingProperty.Wood -> {0}
//            WuxingProperty.Metal -> {0}
            else -> 0
        }
    }

    /**
     * 获取攻击时的特效
     * todo 完善攻击的粒子效果
     */
    fun attackEffect(): Unit {
        
    }
}