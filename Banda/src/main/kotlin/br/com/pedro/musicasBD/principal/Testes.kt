package br.com.pedro.musicasBD.principal

import br.com.pedro.musicasBD.dados.AlbumDAO
import br.com.pedro.musicasBD.dados.Banco
import br.com.pedro.musicasBD.dados.BandaDAO
import br.com.pedro.musicasBD.modelos.Album
import br.com.pedro.musicasBD.modelos.Banda

fun main(){

    val manager = Banco.getEntityManager()

    val albumDAO = AlbumDAO(manager)
    val bandaDAO = BandaDAO(manager)
    val acdc = bandaDAO.recuperarPeloId(1)

    val highVoltage = Album("High Voltage", acdc)
    val tnt = Album("T.N.T", acdc)

    albumDAO.adicionar(tnt)
    albumDAO.adicionar(highVoltage)

    val listaAlbuns = albumDAO.getLista()
    println(listaAlbuns)

    manager.close()


}