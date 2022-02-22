package kotlincode.chapter2

class Variables {
    // String
    val question = "The Ultimate Question of Life, the Universe, and Everything"

    // Int
    val answer = 42

    // Double
    val yearsToCompute = 7.5e6

    fun someFunction() {
        // так можно
        val someVal: Int
        someVal = 42

        //  а так нельзя
//        val someNumber
//        someNumber = 42

        /*
        несмотря на невозможность изменить ссылку val, объект, на который она указывает, может быть изменяемым.
        Например, следующий код является вполне допустимым:
         */
        val languages = arrayListOf("Java")
        languages.add("Kotlin")

        // ошибка - несовпадение типов
//        var answer = 42
//        answer = "no answer"

    }

    /*
     Переменная, объявленная с ключевым словом val, должна быть инициализирована только один раз во время выполнения
     блока, в котором она определена. Но её можно инициализировать разными значениями в зависимости от некоторых условий,
     если компилятор сможет гарантировать, что выполнится только одно из инициализирующих выражений
     */
    fun compareAndPrintMessage(a: Int, b: Int): String {
        val message: String
        if (a > b) {
            message = "A greater than B"
        } else {
            message = "A less than B"
        }
        return message
    }

}