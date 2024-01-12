package br.com.fiap.pegames.utilitario

import br.com.fiap.pegames.modelo.InfoJogadorJson
import br.com.fiap.pegames.modelo.Jogador

fun InfoJogadorJson.criaJogador(): Jogador {
   return Jogador(this.nome, this.email, this.dataNascimento, this.usuario)
}