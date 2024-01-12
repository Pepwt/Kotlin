package br.com.fiap.pegames.modelo

class PlanoAvulso(
     tipo: String): Plano(tipo){

     override fun obterValor(aluguel: Aluguel): Double {
          var valorOriginal = super.obterValor(aluguel)
          if (aluguel.jogador.media > 8) {
               valorOriginal -= valorOriginal * 0.1
          }
          return valorOriginal
     }

}
