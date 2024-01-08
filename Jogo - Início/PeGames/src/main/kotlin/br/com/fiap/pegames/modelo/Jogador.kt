package br.com.fiap.pegames.modelo

import java.io.RandomAccessFile
import java.lang.IllegalArgumentException
import java.util.Scanner
import kotlin.random.Random

data class Jogador(var nome:String, var email:String){
    var dt_Nascimento:String? = null
    var usuario:String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()){
                criarIdInterno()
            }
        }
    var idInterno:String? = null
        private set

    val jogosBuscados = mutableListOf<Jogo?>()

    constructor(nome: String, email: String, dt_Nasciomento: String, usuario: String):
            this(nome, email){
                this.dt_Nascimento = dt_Nasciomento
                this.usuario = usuario
                criarIdInterno()
            }

//    init {
//        if (nome.isNullOrBlank()){
//            throw IllegalArgumentException("Nome está em branco!!")
//        }
//        this.email = validarEmail()
//    }

    override fun toString(): String {
        return "Jogador(nome='$nome', email='$email', dt_Nascimento=$dt_Nascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criarIdInterno() {
        val numero = Random.nextInt(200)
        val tag = String.format("%03d", numero)

       idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)){
            return email
        } else{
            throw IllegalArgumentException("Email Invalido")
        }

    }

    companion object{
        fun criarGamer(leitura: Scanner): Jogador {
            println("Boas vindas ao PeGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Jogador(nome, email, nascimento, usuario)
            }else{
                return Jogador(nome, email)
            }
        }
    }


}
