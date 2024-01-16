package br.com.fiap.pegames.dados

import br.com.fiap.pegames.modelo.Periodo
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "aluguel")
class AluguelEntity(
    @ManyToOne
    val gamer: JogadorEntity = JogadorEntity(),
    @ManyToOne
    val jogo: JogoEntity = JogoEntity(),
    @Embedded
    val periodo: Periodo = Periodo()
) {
    var valorDoAluguel = 0.0
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0


}