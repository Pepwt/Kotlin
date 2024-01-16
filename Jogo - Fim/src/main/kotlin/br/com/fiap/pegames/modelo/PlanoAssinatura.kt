package br.com.fiap.pegames.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: Double,
    id: Int = 0): Plano(tipo, id) {

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.jogador.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1

        return if (totalJogosNoMes <= jogosIncluidos) {
            0.0
        } else {
            var valorOriginal = super.obterValor(aluguel)
            if (aluguel.jogador.media > 8) {
                valorOriginal -= valorOriginal * percentualDescontoReputacao
            }
            valorOriginal
        }
    }

    override fun toString(): String {
        return "Plano Assinatura\n" +
                "Tipo: $tipo\n" +
                "Id: $id\n" +
                "Mensalidade: $mensalidade\n" +
                "Jogos Incluidos: $jogosIncluidos\n" +
                "Percentual Desconto Reputacao: $percentualDescontoReputacao\n"
    }
}
