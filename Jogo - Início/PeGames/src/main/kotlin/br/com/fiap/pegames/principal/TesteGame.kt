import br.com.fiap.pegames.modelo.Jogador

fun main(){
   val player1 = Jogador(
       "Pedro",
       "ped@email.com")
    println(player1)

    val player2 = Jogador(
        "Pepe",
        "pepe@email.com",
        "04/06/2020",
        "pepewt")
    println(player2)

    player1.let {
        it.dt_Nascimento = "10/10/2010"
        it.usuario = "skyloop"
    }.also {
        println(player1.idInterno)
    }

    println(player1)
    player1.usuario = "Chris"
    println(player1)

}