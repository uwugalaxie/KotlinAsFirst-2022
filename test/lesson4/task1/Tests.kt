package lesson4.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun sqRoots() {
        assertEquals(listOf<Double>(), lesson6.task1.task1.sqRoots(-1.0))
        assertArrayEquals(listOf(0.0).toDoubleArray(), lesson6.task1.task1.sqRoots(0.0).toDoubleArray(), 1e-5)
        assertArrayEquals(listOf(-5.0, 5.0).toDoubleArray(), lesson6.task1.task1.sqRoots(25.0).toDoubleArray(), 1e-5)
    }

    @Test
    @Tag("Example")
    fun biRoots() {
        assertEquals(listOf<Double>(), lesson6.task1.task1.biRoots(0.0, 0.0, 1.0))
        assertEquals(listOf<Double>(), lesson6.task1.task1.biRoots(0.0, 1.0, 2.0))
        assertArrayEquals(
            listOf(-2.0, 2.0).toDoubleArray(),
            lesson6.task1.task1.biRoots(0.0, 1.0, -4.0).toDoubleArray(),
            1e-5
        )
        assertEquals(listOf<Double>(), lesson6.task1.task1.biRoots(1.0, -2.0, 4.0))
        assertArrayEquals(
            listOf(-1.0, 1.0).toDoubleArray(),
            lesson6.task1.task1.biRoots(1.0, -2.0, 1.0).toDoubleArray(),
            1e-5
        )
        assertEquals(listOf<Double>(), lesson6.task1.task1.biRoots(1.0, 3.0, 2.0))
        assertArrayEquals(
            listOf(-2.0, -1.0, 1.0, 2.0).toDoubleArray(),
            lesson6.task1.task1.biRoots(1.0, -5.0, 4.0).sorted().toDoubleArray(),
            1e-5
        )
    }

    @Test
    @Tag("Example")
    fun negativeList() {
        assertEquals(listOf<Int>(), lesson6.task1.task1.negativeList(listOf(1, 2, 3)))
        assertEquals(listOf(-1, -5), lesson6.task1.task1.negativeList(listOf(-1, 2, 4, -5)))
    }

    @Test
    @Tag("Example")
    fun invertPositives() {
        val list1 = mutableListOf(1, 2, 3)
        lesson6.task1.task1.invertPositives(list1)
        assertEquals(listOf(-1, -2, -3), list1)
        val list2 = mutableListOf(-1, 2, 4, -5)
        lesson6.task1.task1.invertPositives(list2)
        assertEquals(listOf(-1, -2, -4, -5), list2)
    }

    @Test
    @Tag("Example")
    fun squares() {
        assertEquals(listOf(0), lesson6.task1.task1.squares(listOf(0)))
        assertEquals(listOf(1, 4, 9), lesson6.task1.task1.squares(listOf(1, 2, -3)))
    }

    @Test
    @Tag("Example")
    fun squaresVararg() {
        assertArrayEquals(arrayOf(0), lesson6.task1.task1.squares(0))
        assertArrayEquals(arrayOf(1, 4, 9), lesson6.task1.task1.squares(1, 2, -3))
    }

    @Test
    @Tag("Example")
    fun isPalindrome() {
        assertFalse(lesson6.task1.task1.isPalindrome("Барабан"))
        assertTrue(lesson6.task1.task1.isPalindrome("А роза упала на лапу Азора"))
        assertTrue(lesson6.task1.task1.isPalindrome("Шалаш"))
    }

    @Test
    @Tag("Example")
    fun buildSumExample() {
        assertEquals("42 = 42", lesson6.task1.task1.buildSumExample(listOf(42)))
        assertEquals("3 + 6 + 5 + 4 + 9 = 27", lesson6.task1.task1.buildSumExample(listOf(3, 6, 5, 4, 9)))
    }

    @Test
    @Tag("2")
    fun abs() {
        assertEquals(0.0, lesson6.task1.task1.abs(listOf()), 1e-5)
        assertEquals(3.0, lesson6.task1.task1.abs(listOf(3.0)), 1e-5)
        assertEquals(5.0, lesson6.task1.task1.abs(listOf(3.0, -4.0)), 1e-5)
        assertEquals(8.774964, lesson6.task1.task1.abs(listOf(4.0, -5.0, 6.0)), 1e-5)
    }

    @Test
    @Tag("2")
    fun mean() {
        assertEquals(0.0, lesson6.task1.task1.mean(listOf()), 1e-5)
        assertEquals(1.0, lesson6.task1.task1.mean(listOf(1.0)), 1e-5)
        assertEquals(2.0, lesson6.task1.task1.mean(listOf(3.0, 1.0, 2.0)), 1e-5)
        assertEquals(3.0, lesson6.task1.task1.mean(listOf(0.0, 2.0, 7.0, 8.0, -2.0)), 1e-5)
    }

    @Test
    @Tag("3")
    fun center() {
        assertEquals(listOf<Double>(), lesson6.task1.task1.center(mutableListOf()))
        assertArrayEquals(
            listOf(0.0).toDoubleArray(),
            lesson6.task1.task1.center(mutableListOf(3.14)).toDoubleArray(),
            1e-5
        )
        assertArrayEquals(
            listOf(1.0, -1.0, 0.0).toDoubleArray(),
            lesson6.task1.task1.center(mutableListOf(3.0, 1.0, 2.0)).toDoubleArray(),
            1e-5
        )
        assertArrayEquals(
            listOf(-3.0, -1.0, 4.0, 5.0, -5.0).toDoubleArray(),
            lesson6.task1.task1.center(mutableListOf(0.0, 2.0, 7.0, 8.0, -2.0)).toDoubleArray(),
            1e-5
        )
        val toMutate = mutableListOf(-3.0, -1.0, 4.0, 5.0, -5.0)
        assertTrue(toMutate === lesson6.task1.task1.center(toMutate)) { "You should mutate an input list, not create a copy" }
    }

    @Test
    @Tag("3")
    fun times() {
        assertEquals(0, lesson6.task1.task1.times(listOf(), listOf()))
        assertEquals(-5, lesson6.task1.task1.times(listOf(1, -4), listOf(3, 2)))
        assertEquals(-19, lesson6.task1.task1.times(listOf(-1, 2, -3), listOf(3, -2, 4)))
    }

    @Test
    @Tag("3")
    fun polynom() {
        assertEquals(0, lesson6.task1.task1.polynom(listOf(), 1000))
        assertEquals(42, lesson6.task1.task1.polynom(listOf(42), -1000))
        assertEquals(13, lesson6.task1.task1.polynom(listOf(3, 2), 5))
        assertEquals(0, lesson6.task1.task1.polynom(listOf(2, -3, 1), 1))
        assertEquals(45, lesson6.task1.task1.polynom(listOf(-7, 6, 4, -4, 1), -2))
    }

    @Test
    @Tag("3")
    fun accumulate() {
        assertEquals(listOf<Double>(), lesson6.task1.task1.accumulate(arrayListOf()))
        assertArrayEquals(
            listOf(3).toIntArray(),
            lesson6.task1.task1.accumulate(arrayListOf(3)).toIntArray()
        )
        assertArrayEquals(
            listOf(1, 3, 6, 10).toIntArray(),
            lesson6.task1.task1.accumulate(arrayListOf(1, 2, 3, 4)).toIntArray()
        )
        val toMutate = mutableListOf(-3, -1, 4, 5, -5)
        assertTrue(toMutate === lesson6.task1.task1.accumulate(toMutate)) { "You should mutate an input list, not create a copy" }
    }

    @Test
    @Tag("3")
    fun factorize() {
        assertEquals(listOf(2), lesson6.task1.task1.factorize(2))
        assertEquals(listOf(3, 5, 5), lesson6.task1.task1.factorize(75))
        assertEquals(listOf(2, 3, 3, 19), lesson6.task1.task1.factorize(342))
    }

    @Test
    @Tag("4")
    fun factorizeToString() {
        assertEquals("2", lesson6.task1.task1.factorizeToString(2))
        assertEquals("3*5*5", lesson6.task1.task1.factorizeToString(75))
        assertEquals("2*3*3*19", lesson6.task1.task1.factorizeToString(342))
        assertEquals("7*7*31*31*151*151", lesson6.task1.task1.factorizeToString(1073676289))
        assertEquals("1073676287", lesson6.task1.task1.factorizeToString(1073676287))
        assertEquals(Int.MAX_VALUE.toString(), lesson6.task1.task1.factorizeToString(Int.MAX_VALUE))
    }

    @Test
    @Tag("3")
    fun convert() {
        assertEquals(listOf(1), lesson6.task1.task1.convert(1, 2))
        assertEquals(listOf(1, 2, 1, 0), lesson6.task1.task1.convert(100, 4))
        assertEquals(listOf(1, 3, 12), lesson6.task1.task1.convert(250, 14))
        assertEquals(listOf(2, 14, 12), lesson6.task1.task1.convert(1000, 19))
    }

    @Test
    @Tag("4")
    fun convertToString() {
        assertEquals("1", lesson6.task1.task1.convertToString(1, 2))
        assertEquals("1210", lesson6.task1.task1.convertToString(100, 4))
        assertEquals("13c", lesson6.task1.task1.convertToString(250, 14))
        assertEquals("2ec", lesson6.task1.task1.convertToString(1000, 19))
        assertEquals("z", lesson6.task1.task1.convertToString(35, 36))
        assertEquals("a02220281", lesson6.task1.task1.convertToString(Int.MAX_VALUE, 11))
    }

    @Test
    @Tag("3")
    fun decimal() {
        assertEquals(1, lesson6.task1.task1.decimal(listOf(1), 2))
        assertEquals(100, lesson6.task1.task1.decimal(listOf(1, 2, 1, 0), 4))
        assertEquals(250, lesson6.task1.task1.decimal(listOf(1, 3, 12), 14))
        assertEquals(1000, lesson6.task1.task1.decimal(listOf(2, 14, 12), 19))
    }

    @Test
    @Tag("4")
    fun decimalFromString() {
        assertEquals(1, lesson6.task1.task1.decimalFromString("1", 2))
        assertEquals(100, lesson6.task1.task1.decimalFromString("1210", 4))
        assertEquals(250, lesson6.task1.task1.decimalFromString("13c", 14))
        assertEquals(1000, lesson6.task1.task1.decimalFromString("2ec", 19))
        assertEquals(35, lesson6.task1.task1.decimalFromString("z", 36))
        assertEquals(Int.MAX_VALUE, lesson6.task1.task1.decimalFromString("a02220281", 11))
    }

    @Test
    @Tag("5")
    fun roman() {
        assertEquals("I", lesson6.task1.task1.roman(1))
        assertEquals("MMM", lesson6.task1.task1.roman(3000))
        assertEquals("MCMLXXVIII", lesson6.task1.task1.roman(1978))
        assertEquals("DCXCIV", lesson6.task1.task1.roman(694))
        assertEquals("XLIX", lesson6.task1.task1.roman(49))
    }

    @Test
    @Tag("7")
    fun russian() {
        assertEquals("четыреста семьдесят тысяч семьсот шестьдесят один", lesson6.task1.task1.russian(470761))
        assertEquals("триста семьдесят пять", lesson6.task1.task1.russian(375))
        assertEquals("двадцать две тысячи девятьсот шестьдесят четыре", lesson6.task1.task1.russian(22964))
        assertEquals("сто девятнадцать тысяч пятьсот восемь", lesson6.task1.task1.russian(119508))
        assertEquals("две тысячи три", lesson6.task1.task1.russian(2003))
        assertEquals("двести тысяч два", lesson6.task1.task1.russian(200002))
        assertEquals("девятьсот тысяч", lesson6.task1.task1.russian(900000))
        assertEquals("двенадцать", lesson6.task1.task1.russian(12))
    }
}