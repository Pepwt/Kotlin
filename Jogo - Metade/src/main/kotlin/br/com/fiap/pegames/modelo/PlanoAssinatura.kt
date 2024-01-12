package br.com.fiap.pegames.modelo


class PlanoAssinatura(tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoRecomendacao: Double):Plano(tipo){

    override fun obterValor(aluguel: Aluguel): Double {
       val totalJogosNoMes = aluguel.jogador.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1

        return if (totalJogosNoMes <= jogosIncluidos){
            0.0
        }else{
           var valorOriginal =  super.obterValor(aluguel)
            if (aluguel.jogador.media > 8){
                valorOriginal -= valorOriginal * percentualDescontoRecomendacao
            }
            valorOriginal

        }
    }

}
