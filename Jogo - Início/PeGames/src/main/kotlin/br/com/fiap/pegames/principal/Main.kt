package br.com.fiap.pegames.principal

import br.com.fiap.pegames.modelo.Jogador
import br.com.fiap.pegames.modelo.Jogo
import br.com.fiap.pegames.servicos.ConsumoApi
import transformaEmIdade
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Jogador.criarGamer(leitura)
    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(gamer)
    println("Idade do jodador: " + gamer.dt_Nascimento?.transformaEmIdade())
    do {

        println("Digite um código de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca)


        var mJogo: Jogo? = null

        val resultado = runCatching {
            mJogo = Jogo(
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
                mJogo?.descricao = descricaoPersonalizada
            } else {
                mJogo?.descricao = mJogo?.titulo

            }
            gamer.jogosBuscados.add(mJogo)
        }

        println("Você deseja buscar outro jogo? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("s", true))

    println("Jogos Buscados")
    println(gamer.jogosBuscados)
    println("\nJogos ordenados por título")

    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach{
        println("Título: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }
    println("\n Jogos filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("s", true)) {
        println(gamer.jogosBuscados)
        println("\nInforme a posição do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\nLista atualizada:")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso.")

}