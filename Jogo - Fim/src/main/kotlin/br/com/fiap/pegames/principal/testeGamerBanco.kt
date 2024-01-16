package br.com.fiap.pegames.principal

import br.com.fiap.pegames.dados.JogadoresDAO
import br.com.fiap.pegames.dados.PlanosDAO
import br.com.fiap.pegames.dados.Banco
import br.com.fiap.pegames.modelo.Jogador

fun main(){
    val jogador = Jogador("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Banco.getEntityManager()
    val jogadorDAO = JogadoresDAO(manager)
    val planosDAO = PlanosDAO(manager)

    jogador.plano = planosDAO.recuperarPeloId(3)

    jogadorDAO.adicionar(jogador)

    val listaGamersBanco = jogadorDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}