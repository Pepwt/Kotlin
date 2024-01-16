package br.com.pedro.musicasBD.dados

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "bandas")
class BandaEntity(
    val nome: String = "Nome da banda",
    val descricao: String = "Descrição da banda",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
)