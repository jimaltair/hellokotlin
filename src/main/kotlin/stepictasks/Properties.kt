package stepictasks

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Add a custom setter to PropertyExample.propertyWithCounter so that the counter property is incremented every
 * time propertyWithCounter is assigned to.
 */
class PropertyExample() {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(value) {
            field = value
            counter++
        }
}

/**
 * Add a custom getter to make the 'lazy' val really lazy. It should be initialized by the invocation of 'initializer()'
 * at the moment of the first access. You can add as many additional properties as you need.
 * Do not use delegated properties!
 */
class LazyProperty(val initializer: () -> Int) {
    private var _lazy: Int? = null
    val lazy: Int
        get() {
            if (_lazy == null) {
                _lazy = initializer()
            }
            return _lazy!!
        }
}

/**
 * Read about delegated properties and make the property lazy by using delegates.
 */
class LazyProperty1(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}

/**
 * You may declare your own delegates. Implement the methods of the class 'EffectiveDate' so it can be delegated to.
 * Store only the time in milliseconds in 'timeInMillis' property. Use the extension functions MyDate.toMillis()
 * and Long.toDate().
 */
class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        return MyDate().toMillis()
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {

    }
}

fun MyDate.toMillis() {

}
fun Long.toDate(){

}