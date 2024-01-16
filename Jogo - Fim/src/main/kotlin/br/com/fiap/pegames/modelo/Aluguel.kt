package br.com.fiap.pegames.modelo

data class Aluguel(
    val jogador: Jogador,
    val jogo: Jogo,
    val periodo: Periodo) {
    val valorDoAluguel = jogador.plano.obterValor(this)
    var id = 0

    override fun toString(): String {
        return "Aluguel do jogo ${jogo.titulo} por ${jogador.nome} pelo valor R$$valorDoAluguel"
    }
}
