package br.com.fiap.pegames.modelo

interface Recomendavel {
    val media : Double

    fun recomendar(nota: Int)
}