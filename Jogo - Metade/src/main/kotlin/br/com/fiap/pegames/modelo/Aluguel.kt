package br.com.fiap.pegames.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val jogador: Jogador,
    val jogo: Jogo,
    val periodo: Periodo) {
    val valorAluguel = jogador.plano.obterValor(this)

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${jogador.nome} pelo valor R$$valorAluguel"
    }
}
