package br.com.fiap.pegames.utilitario

import br.com.fiap.pegames.modelo.InfoJogoJson
import br.com.fiap.pegames.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}