@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

/**
 * Фабричный метод для создания комплексного числа из строки вида x+yi
 */
fun Complex(s: String): Complex {
    val split = s.split("+", "-")
    val minusCheck = if (s.contains("-")) -1 else 1
    val re = split[0].toDouble()
    val im = split[1].dropLast(1).toDouble() * minusCheck
    return Complex(re, im)
}

/**
 * Класс "комплексное число".
 *
 * Общая сложность задания -- лёгкая, общая ценность в баллах -- 8.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
class Complex(val re: Double, val im: Double) {

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(x, 0.0)

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = Complex(re + other.re, im + other.im)

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(-re, -im)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = Complex(re - other.re, im - other.im)

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex {
        val re = this.re * other.re - this.im * other.im
        val im = this.re * other.im + this.im * other.re
        return Complex(re, im)
    }

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex {
        val s = other.re * other.re + other.im * other.im //знаменатель
        val re = (this.re * other.re + this.im * other.im) / s
        val im = (this.im * other.re - this.re * other.im) / s
        return Complex(re, im)
    }


    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Complex) return false
        if (re != other.re || im != other.im) return false
        return true
    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String {
        if (im == 0.0) return re.toString()
        if (re == 0.0) return "${im}i"
        if (im >= 0) return "$re+${im}i"
        return "$re${im}i"
    }
}
