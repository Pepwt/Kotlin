package br.com.fiap.pegames.modelo

abstract class Plano(val tipo: String) {
   open fun obterValor(aluguel: Aluguel):Double{
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}