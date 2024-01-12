package br.com.fiap.pegames.modelo

import com.google.gson.annotations.Expose

data class Jogo(@Expose val titulo:String,
                @Expose val capa:String): Recomendavel {
    var descricao: String? = null
    var preco = 0.0

    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa){
      this.preco = preco
      this.descricao = descricao
    }
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Preço: $preco \n"  +
                "Descricao: $descricao \n" +
                "Reputação: $media \n"

    }


}