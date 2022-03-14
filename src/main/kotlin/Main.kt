import stepiktasks.testBubbleSort

/**
 * Можно поменять имя импортируемого класса или функции, добавив ключевое слово as:
 */

fun main(args: Array<String>) {
//    println("Hello Kotlin!")

    /**
     * Глава 2
     */
//    println(Functions().max1(10, 20))
//    println(Functions().max2(10, 20))

//    println(Variables().compareAndPrintMessage(10, 20))
//    println(Variables().compareAndPrintMessage(20, 10))

//    println(StringFormatting().formatString(arrayOf("Bob")))
//    println(StringFormatting().formatString(arrayOf()))

//    val person = Person("Bob", true)
//    println(person.name) // Конструктор вызывается без ключевого слова «new»
//    println(person.isMarried) // Прямое обращение к свойству, но при этом вызывается метод чтения

//    val rectangle = Rectangle(41, 43)
//    println(rectangle.isSquare)

//    val rectangle = createRandomRectangle()
//    println("height = ${rectangle.height} width = ${rectangle.width}")

//    println(Color.BLUE.rgb())
//    println(getMnemonic(Color.BLUE))
//    println(getWarmth(Color.GREEN))
//    println(mix(Color.BLUE, Color.YELLOW))
//    println(mixOptimized(Color.YELLOW, Color.BLUE))

    // (1 + 2) + 4
//    println(evalJavaStyle(Sum(Sum(Num(1), Num(2)), Num(4))))
//    println(evalKotlinStyleIf(Sum(Sum(Num(1), Num(2)), Num(4))))
//    println(evalKotlinStyleWhen(Sum(Sum(Num(1), Num(2)), Num(4))))
//    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
//    println(playFizzBuzz())
//    println(playImprovedFizzBuzz())
//    println(playFizzBuzzHalfOpenedRange())
//    mapIteration()
//    listIteration()

//    println(isLetter('q'))
//    println(isNotDigit('8'))

//    println(recognize('A'))
//    println(recognize('0'))
//    println(recognize('%'))
//    checkString("Kotlin")
//    checkStringInSet("Kotlin")

//    exceptionExample(120)
//    println(validateAndReturnPercentage(89))

//    println(readNumber1(BufferedReader(StringReader("156"))))
//    println(readNumber1(BufferedReader(StringReader("not a number"))))
//    readNumber2(BufferedReader(StringReader("156")))
//    readNumber2(BufferedReader(StringReader("not a number")))
//    readNumber3(BufferedReader(StringReader("not a number")))

    /**
     * Глава 3
     */
//    println(KotlinCollections().set.javaClass)
//    println(KotlinCollections().list.javaClass)
//    println(KotlinCollections().map.javaClass)
//    println(KotlinCollections().lastIndexInList())
//    println(KotlinCollections().maxElementInSet())
//    println(KotlinCollections().list)

//    println(joinToString(listOf(1, 10, 1000), separator = "; ", prefix = "(", postfix = ")"))
//    println(joinToString(listOf(1, 10, 1000)))
//    println(joinToString(listOf(1, 10, 1000), " | "))
//    println(joinToString(listOf(1, 10, 1000), prefix = "{", postfix = "}"))
//    performOperation(28)
//
//    println("some string".lastChar())
//    println("some string".last())

//    val list = listOf(1, 2, 3)
//    println(list.joinToString("; ", "(", ")"))
//    println(list.joinToString("   "))
//    println(listOf("one", "two", "ten").join())
//    println(listOf(1, 2, 10).join())    // не компилируется

//    val view: View = Button()   // вызываемый метод определяется фактическим значением переменной view
//    view.click()
//    view.showOff()      // вызываемая функция-расширение определяется статически

//    println("Kotlin".lastChar)
//    val sb = StringBuilder("Kotlin?")
//    sb.lastChar = '!'
//    println(sb)

//    arrayUnpacking(arrayOf("Java", "Kotlin", "Scala"))
//    println(map)
//    println(1.plus(5))
//    println(1 plus 5)
//    iterateAndPrint(listOf(1, 2, 3, 4, 5))

//    splitStringWithRegex("12.345-6.А")
//    splitStringWithDelimeters("12.345-6.А")
    /**
     * Строки в тройных кавычках могут содержать переносы строк, но в них нельзя использовать специальных символов,
     * таких как \n. С другой стороны, отпадает необходимость экранировать символ \
     */
//    val path = """C:\Maps.me\hellokotlin\src\main\kotlin\Main.kt"""
//    parsePath(path)
//    parsePathWithRegex(path)
//    printKotlinLogo()
//    printPrice()
    /**
     * получаем ошибку
     */
//    saveUserJavaStyle(User(1, "", ""))
//    saveUserBeforeRefactoring(User(1, "", ""))
//    saveUserAfterRefactoring(User(1, "", ""))
//    saveUser(User(1, "", ""))
    /**
     * Глава 4
     */
//    Button().showOff()
//    Button().setFocus(true)
//    Button().click()

//    val realAnimatedClass = RealAnimatedClass()
//    realAnimatedClass.animate()
//    realAnimatedClass.animateTwice()
//    realAnimatedClass.stopAnimating()

//    testUser4()

//    println(SubscribingUser("test@kotlinlang.org").nickname)
//    println(FacebookUser(123).nickname)

//    val user = User8("Alice")
//    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"

//    val lengthCounter = LengthCounter()
//    lengthCounter.addWord("Hi!")
//    println(lengthCounter.counter)

//    val client = Client("Alice", 342562)
//    println(client)
//    val client1 = Client1("Alice", 342562)
//    println(client1)
//
//    println(compareClientsByReferences(Client("Alice", 342562), Client("Alice", 342562)))
//    println(compareClientsByValue(Client("Alice", 342562), Client("Alice", 342562)))

    /**
     * true - если в Client переопределён hashCode(), в противном случае false
     */
//    val someVal = hashSetOf(Client("Alice", 342562))
//    println(someVal.contains(Client("Alice", 342562)))

    /**
     * true - т.к. класс Client2 является data-классом, в котором hashCode переопределён автоматически
     */
//    val alice = Client2("Alice", 342562)
//    println(alice)
//    val set = hashSetOf(alice)
//    println(set.contains(alice))
//    val aliceCopy = alice.copy(alice.name, alice.postalCode)
//    println(alice == aliceCopy)

//    val cset = CountingSet<Int>()
//    cset.addAll(listOf(1, 1, 2))
//    println("${cset.objectsAdded} were added, ${cset.size} objects remain")

//    Payroll.allEmployees.add(Person("Bob", true))
//    println(Payroll.allEmployees.size)
//    val file1 = File("/User")
//    val file2 = File("/user")
//    println(CaseInsensitiveFileComparator.compare(file1, file2))
//    val files = listOf(File("/Z"), File("/a"))
//    println(files.sortedWith(CaseInsensitiveFileComparator))
//    val bob = Person2("Bob")
//    val alice= Person2("Alice")
//    println(listOf(bob, alice).sortedWith(Person2.NameComparator))

//    A.testCompanionObject()
    /**
     * Вы можете вызвать объект-компаньон через имя класса:
     */
//    val subscribingUser = User10.newSubscribingUser("bob@gmail.com")
//    val facebookUser = User10.newFacebookUser(6366)
//    println(subscribingUser.nickname)
//    println(facebookUser.nickname)

//    testNamedCompanionObject()
//    testCompanionExtension()
    /**
     * Глава 5
     */
//    val people = listOf(Person("Bob", 31), Person("Alice", 29))
//    findTheOldest(people)

    /**
     * тоже самое, с помощью лямбды
     */
//    println(people.maxByOrNull { it.age })
//    println(people.maxByOrNull { p -> p.age })
//    println(people.maxByOrNull(kotlincode.chapter5.Person::age))

//    testLambda()
//    anotherLambda()

//    val errors = listOf("403 Forbidden", "404 Not found")
//    printMessagesWithPrefix(errors, "Error:")
//    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
//    printProblemCounts(responses)
//    someFun()
//    nextAction(Person("Bob", 31), "Hello!")
//    println(p)

//    val dmitry = Person("Dmitry", 34)
//    println(dmitry.isAdult())
//    val persons = listOf(dmitry, Person("Alice", 15), Person("Bob", 31))
//    persons.filter(adultPredicate).forEach(::println)

//    testConnectedReferences()

//    filterAndMap()
//    allAnyCountFind()
//    groubBy()
//    flatMapAndFlatten()
//    delayedOperations()
//    sequenceCreation()
//    testIsInsideHiddenDirectory()

//    createAllDoneRunnable().run()

//    println(alphabet())
//    println(alphabet1())
//    println(alphabet2())
//    println(alphabet3())
//    println(alphabet4())
    /**
     * Глава 6
     */
//    strLen(null)          // ошибка компиляции
//    strLenSafe(null)        // а так можно
//    val x: String? = null
//    strLen(x)               // ошибка компиляции
//    println(strLenSafe1(x))
//    println(strLenSafe1("abc"))

//    printAllCaps("abc")
//    printAllCaps(null)

//    val ceo = Employee("Da Boss", null)
//    val developer = Employee("Bob Smith", ceo)
//    println(managerName(ceo))
//    println(managerName(developer))

//    println(strLenSafe2("abc"))
//    println(strLenSafe2(null))

//    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
//    val jetbrains = Company("DetBrains", address)
//    val person = Person("Dmitry", jetbrains)
//    printShippingLabel(person)
//    printShippingLabel(Person("Alexey", null))

//    val p1 = Person1("Dmitry", "Demerov")
//    val p2 = Person1("Dmitry", "Demerov")
//    println(p1 == p2)           // оператор == вызывает метод equals
//    println(p1.equals(42))

//    ignoreNulls("abc")
//    ignoreNulls(null)       // получаем NPE

//    var email: String? = "yole@example.com"
//    email?.let { sendEmailTo(it) }
//    email = null
//    email?.let { sendEmailTo(it) }      // здесь ничего не произойдёт

//    testVerifyUserInput()

//    testHashCode()

//    testYellAt()
//    testYellAtSafe()

//    println(Person7("Sam", 35).isOlderThan(Person7("Amy", 42)))
//    println(Person7("Sam", 35).isOlderThan(Person7("Dane")))
//    testTypeConversion()
//    testPrintLong()

//    fail("Error occurred")
//    testNothing()

//    testAddValidNumbers()
//    testAddValidNumbers()

//    testCopyElements()
//    testCopyElements()

//    fakeMain(arrayOf("a", "abc", "npf"))
//    println(letters.joinToString(""))
//    testArrayCreation()
//    println(fiveZeros.joinToString())
//    println(fiveZerosToo.joinToString())
//    println(squares.joinToString())

//    fakeMain1(arrayOf("a", "b", "c"))

//    testCustomForLoop()

//    testOperatorOverloading()

//    testPointPlusOperator()
//    estPointTimesOperator()
//    testCharTimes()
//    testCompositeOperators()
//    testMutableCollectionCompositeOperator()
//    testUnaryMinusOperator()
//    testBigDecimalIncrement()
//    testPointEquals()

//    testPersonCompare()

//    testMapElementInvocation()
//    testPointGetMethod()
//    testPointSetMethod()

//    testRectangleContains()
//    testStandartRangeTo()
//    testDateIterator()

//    testDestructuringDeclaration()
//    testSplitFilename()
//    testPrintEntries()

//    testPropertiesDelegation()
//    testLazyInitializationForPerson1()
//    testLazyInitializationForPerson2()

//    testPerson3Atributes()
    /**
     * Task 3.12
     */
//    var strings = listOf("a", "ab", "ccc", "abc", "zzz", "cd", "efk", "a")
//    val result = doSomethingStrangeWithCollection(strings)
//    println(result)

    testBubbleSort()

}
