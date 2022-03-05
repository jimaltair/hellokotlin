package chapter5

import javacode.Lambdas

/**
 * SAM-интерфейс является синонимом функционального интерфейса.
 * Single Abstract Method.
 */
fun testInvokeJavaMethod() {
    /**
     * В Kotlin можно вызвать Java-метод, передав в аргументе лямбда-выражение. Компилятор автоматически преобразует
     * его в экземпляр Runnable:
     */
    // В программе будет создан только один экземпляр интерфейса Runnable
    Lambdas.postponeComputation(1000) { println(42) }

    /**
     * Другой вариант того что было выше
     */
    // Компилируется в глобальную переменную; в программе существует только один экземпляр
    val runnable = Runnable { println(42) }
    fun handleComputation() {
        // В каждый вызов метода handleComputation будет передаваться один и тот же экземпляр
        Lambdas.postponeComputation(1000, runnable)
    }

    /**
     * Когда лямбда-выражение захватывает переменные из окружающего контекста, становится невозможно повторно
     * использовать один и тот же экземпляр в каждом вызове. В этом случае компилятор создает новый объект для каждого
     * вызова, сохраняя в нем значения захваченных переменных.
     */
    fun handleComputation(id: String) {         // Лямбда-выражение захватывает переменную «id»
        Lambdas.postponeComputation(1000) { println(id) }       // Для каждого вызова handleComputation создается
    }                                                                 // новый экземпляр Runnable
}

/**
 * Применение SAM-конструктора к возвращаемому значению.
 * Имя SAM-конструктора совпадает с именем соответствующего функционального интерфейса. SAM-конструктор принимает один
 * аргумент - лямбда-выражение, которое будет использовано как тело единственного абстрактного метода в функциональном
 * интерфейсе - и возвращает экземпляр класса, реализующего данный интерфейс.
 */
fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done!") }
}

/**
 * Использование SAM-конструктора для повторного использования обработчика событий
 */
/*
val listener = OnClickListener { view ->
    val text = when (view.id) {         // Поле view.id используется, чтобы понять, какая кнопка была нажата
        R.id.button1 -> "First button"
        R.id.button2 -> "Second button"
        else -> "Unknown button"
    }
    toast(text)             // Выводит значение поля «text»
}
button1.setOnClickListener(listener)
button2.setOnClickListener(listener)*/
