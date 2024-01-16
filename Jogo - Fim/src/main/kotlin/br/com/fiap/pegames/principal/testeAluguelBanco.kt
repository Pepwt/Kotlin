package br.com.fiap.pegames.principal

import br.com.fiap.pegames.dados.AluguelDAO
import br.com.fiap.pegames.dados.Banco
import br.com.fiap.pegames.dados.JogadoresDAO
import br.com.fiap.pegames.dados.JogosDAO
import br.com.fiap.pegames.modelo.Periodo

fun main() {
    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    val gamerDAO = JogadoresDAO(manager)
    val aluguelDAO = _root_ide_package_.br.com.fiap.pegames.dados.AluguelDAO(manager)

    val gamer = gamerDAO.recuperarPeloId(1)
    val jogo = jogoDAO.recuperarPeloId(3)
    val aluguel = gamer.alugaJogo(jogo, Periodo())

    aluguelDAO.adicionar(aluguel)

    val listaAluguel = aluguelDAO.getLista()
    println(listaAluguel)

    manager.close()
}