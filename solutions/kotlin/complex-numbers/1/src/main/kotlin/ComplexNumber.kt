import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.sqrt

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {

    operator fun plus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(real = real + other.real, imag = imag + other.imag)
    }

    operator fun minus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(real = real - other.real, imag = imag - other.imag)
    }

    operator fun times(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(
            real = real * other.real - imag * other.imag,
            imag = real * other.imag + imag * other.real
        )
    }

    operator fun div(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(
            real = (real * other.real + imag * other.imag) / (other.real * other.real + other.imag * other.imag),
            imag = (imag * other.real - real * other.imag) / (other.real * other.real + other.imag * other.imag)
        )
    }

    val abs : Double by lazy { sqrt(real * real + imag * imag) }

    fun conjugate(): ComplexNumber { return ComplexNumber(real = real, imag = -imag) }


}
fun exponential(c: ComplexNumber) : ComplexNumber {
    return ComplexNumber(
        real = exp(c.real) * cos(c.imag),
        imag = exp(c.real)* sin(c.imag))
}
