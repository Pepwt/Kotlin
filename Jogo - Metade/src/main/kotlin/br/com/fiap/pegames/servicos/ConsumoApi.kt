package br.com.fiap.pegames.servicos

import br.com.fiap.pegames.modelo.*
import br.com.fiap.pegames.utilitario.criaJogador
import br.com.fiap.pegames.utilitario.criaJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

   private fun consomeDados(endereco: String): String{
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

       return response.body()
   }

    fun buscaJogo(id:String): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consomeDados(endereco)

        val gson = Gson()
        val mInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return mInfoJogo
    }

    fun buscaJogadores(): List<Jogador> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consomeDados(endereco)

        val gson = Gson()
        val mGamerTipo = object : TypeToken<List<InfoJogadorJson>>(){}.type
        val listaJogador: List<InfoJogadorJson> = gson.fromJson(json, mGamerTipo)

        val listaJogadorConvertida = listaJogador.map { infoJogadorJson -> infoJogadorJson.criaJogador() }

        return listaJogadorConvertida
    }

    fun buscaJogosJson(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consomeDados(endereco)

        val gson = Gson()
        val meuJogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogo: List<InfoJogoJson> = gson.fromJson(json, meuJogoTipo)

        val listaJogoConvertida = listaJogo.map { infoJogoJson -> infoJogoJson.criaJogo() }

        return listaJogoConvertida
    }

}