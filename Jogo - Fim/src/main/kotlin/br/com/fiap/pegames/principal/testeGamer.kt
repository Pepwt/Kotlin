package br.com.fiap.pegames.principal
import br.com.fiap.pegames.modelo.Jogador

fun main() {
    val jogador1 = Jogador("Jacque", "jacque@email.com")
    println(jogador1)

    val jogador2 = Jogador(
        "Jeni",
        "jeni@email.com",
        "19/19/1992",
        "jeniblo")

    println(jogador2)

    jogador1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "jacqueskywalker"

    }.also {
        println(jogador1.idInterno)
    }

    println(jogador1)
    jogador1.usuario = "jacque"
    println(jogador1)
}