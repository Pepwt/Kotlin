package br.com.fiap.pegames.principal

import br.com.fiap.pegames.modelo.Jogador
import br.com.fiap.pegames.modelo.Jogo
import br.com.fiap.pegames.servicos.ConsumoApi
import java.util.Scanner
import tranformarEmIdade


fun main() {
    val leitura = Scanner(System.`in`)
    val jogador = Jogador.criarGamer(leitura)
    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(jogador)
    println("Idade do gamer: " + jogador.dataNascimento?.tranformarEmIdade())

    do {
        println("Digite um código de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca)


        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }

        resultado.onFailure {
            println("Jogo inexistente. Tente outro id.")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Insira a descrição personalizado para o jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo

            }

            jogador.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("s", true))

    println("Jogos buscados:")
    println(jogador.jogosBuscados)

    println("\n Jogos ordenados por título: ")
    jogador.jogosBuscados.sortBy {
        it?.titulo
    }

    jogador.jogosBuscados.forEach {
        println("Título: " + it?.titulo)
    }

    val jogosFiltrados = jogador.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }
    println("\n Jogos filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("s", true)) {
        println(jogador.jogosBuscados)
        println("\nInforme a posição do jogo que deseja excluir: ")
        val posicao =leitura.nextInt()
        jogador.jogosBuscados.removeAt(posicao)
    }

    println("\n Lista atualizada:")
    println(jogador.jogosBuscados)

    println("Busca finalizada com sucesso.")

}