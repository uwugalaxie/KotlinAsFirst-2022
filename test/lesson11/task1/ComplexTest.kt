package lesson11.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag

internal class ComplexTest {

    private fun assertApproxEquals(expected: Complex, actual: Complex, eps: Double) {
        assertEquals(expected.re, actual.re, eps)
        assertEquals(expected.im, actual.im, eps)
    }

    @Test
    @Tag("2")
    fun complexPlus() {
        assertApproxEquals(Complex("4-2i"), Complex("1+2i") + Complex("3-4i"), 1e-10)
    }

    @Test
    @Tag("2")
    fun complexUnaryMinus() {
        assertApproxEquals(Complex(1.0, -2.0), -Complex(-1.0, 2.0), 1e-10)
    }

    @Test
    @Tag("2")
    fun complexMinus() {
        assertApproxEquals(Complex("2-6i"), Complex("3-4i") - Complex("1+2i"), 1e-10)
    }

    @Test
    @Tag("4")
    fun complexTimes() {
        assertApproxEquals(Complex("11+2i"), Complex("1+2i") * Complex("3-4i"), 1e-10)
    }

    @Test
    @Tag("4")
    fun complexDiv() {
        assertApproxEquals(Complex("1+2i"), Complex("11+2i") / Complex("3-4i"), 1e-10)
    }

    @Test
    @Tag("2")
    fun complexEquals() {
        assertApproxEquals(Complex(1.0, 2.0), Complex("1+2i"), 1e-12)
        assertApproxEquals(Complex(1.0, 0.0), Complex(1.0), 1e-12)
    }

    @Test
    fun complexToString() {
        assertEquals("2.0+3.0i", Complex(2.0, 3.0).toString())
        assertEquals("5.0-2.0i", Complex(5.0, -2.0).toString())
        assertEquals("7.0", Complex(7.0, 0.0).toString())
        assertEquals("6.0i", Complex(0.0, 6.0).toString())
    }

}