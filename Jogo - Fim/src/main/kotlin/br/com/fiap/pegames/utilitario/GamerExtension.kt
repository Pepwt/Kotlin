package br.com.fiap.pegames.utilitario

import br.com.fiap.pegames.dados.JogadorEntity
import br.com.fiap.pegames.modelo.Jogador
import br.com.fiap.pegames.modelo.InfoJogadorJson

fun InfoJogadorJson.criaGamer(): Jogador {
    return Jogador(this.nome, this.email, this.dataNascimento, this.usuario)
}

fun Jogador.toEntity(): JogadorEntity {
    return JogadorEntity(this.id, this.nome, this.email, this.dataNascimento, this.usuario, this.plano.toEntity())
}

fun JogadorEntity.toModel(): Jogador {
    return Jogador(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}