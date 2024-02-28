fun main(args: Array<String>) {
    val frutas = listOf("banana", "maçã", "banana", "abacate", "limão", "banana", "pera", "maça","banana", "limão" )
    val contagemFrutas = mutableMapOf<String, Int>()

    for (fruta in frutas){
        contagemFrutas[fruta] = contagemFrutas.getOrDefault(fruta, 0)+1
    }

    println("Contagem de ocorrências de cada fruta: ")
    for((fruta, quantidade) in contagemFrutas){
        println("$fruta: $quantidade")
    }
}