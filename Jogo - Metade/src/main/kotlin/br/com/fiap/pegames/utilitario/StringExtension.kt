import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformaEmIdade(): Int {
    val fomatter = DateTimeFormatter.ofPattern("dd/MM/yyy")
    var idade = 0
    val dtNascimento = LocalDate.parse(this, fomatter)
    val hoje = LocalDate.now()
    idade = Period.between(dtNascimento, hoje).years

    return idade

}