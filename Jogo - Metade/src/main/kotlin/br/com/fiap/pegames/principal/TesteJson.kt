package br.com.fiap.pegames.principal

import br.com.fiap.pegames.modelo.Jogador
import br.com.fiap.pegames.modelo.Periodo
import br.com.fiap.pegames.modelo.PlanoAssinatura
import br.com.fiap.pegames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main(){
    val consumo = ConsumoApi()
    val listaJogador = consumo.buscaJogadores()
    val listaJogoJson = consumo.buscaJogosJson()

//    println(listaJogador)
//    println(listaJogoJson)

    val jogadorCaroline = listaJogador.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)
    val spiderMan = listaJogoJson.get(13)
    val jogoTheLastOfUs = listaJogoJson.get(2)
    val jogoDandara = listaJogoJson.get(5)
    val jogoAssassins = listaJogoJson.get(4)
    val jogoCyber = listaJogoJson.get(6)
    val jogoGod = listaJogoJson.get(7)
    val Skyrim = listaJogoJson.get(18)
    val codWarzone = listaJogoJson.get(8)


    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))

    jogadorCaroline.alugarJogo(jogoResidentVillage, periodo1)
    jogadorCaroline.alugarJogo(spiderMan, periodo2)
    jogadorCaroline.alugarJogo(codWarzone, periodo3)
   // println(jogadorCaroline.jogosAlugados)

    val jogadorBruno = listaJogador.get(4)
    jogadorBruno.plano = PlanoAssinatura("PRATA", 9.90,3, 0.15)

    jogadorBruno.alugarJogo(jogoResidentVillage, periodo1)
    jogadorBruno.alugarJogo(spiderMan, periodo2)
    jogadorBruno.alugarJogo(codWarzone, periodo3)
    jogadorBruno.alugarJogo(codWarzone, periodo3)
//    println(jogadorBruno.jogosAlugados)

    jogadorBruno.recomendar(7)
    jogadorBruno.recomendar(10)
    jogadorBruno.recomendar(8)
//    println(jogadorBruno)

    jogadorBruno.alugarJogo(jogoResidentVillage, periodo1)
    //   println(jogadorBruno.jogosAlugados)

    jogadorBruno.recomendarJogo(jogoResidentVillage, 7)
    jogadorBruno.recomendarJogo(codWarzone, 10)

    jogadorCaroline.recomendarJogo(jogoResidentVillage, 8)
    jogadorCaroline.recomendarJogo(codWarzone, 9)

    println("Recomendações do Bruno")
    //println(jogadorBruno.jogosRecomendados)
    println("Recomendações da Caroline")
    //println(jogadorCaroline.jogosRecomendados)

    jogadorBruno.recomendarJogo(jogoResidentVillage, 7)
    jogadorBruno.recomendarJogo(jogoTheLastOfUs, 10)
    jogadorBruno.recomendarJogo(jogoAssassins, 8)
    jogadorBruno.recomendarJogo(jogoCyber, 7)
    jogadorBruno.recomendarJogo(jogoGod, 10)
    jogadorBruno.recomendarJogo(jogoDandara, 8)
    jogadorBruno.recomendarJogo(Skyrim, 8)
    jogadorBruno.recomendarJogo(spiderMan, 6)
    jogadorBruno.recomendarJogo(codWarzone, 9)

    println(jogadorBruno.jogosRecomendados)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(jogadorBruno.jogosRecomendados)
    println(serializacao)

    val arquivo = File("jogosRecomendados-${jogadorBruno.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)
}