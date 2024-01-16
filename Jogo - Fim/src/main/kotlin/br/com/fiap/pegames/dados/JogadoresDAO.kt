package br.com.fiap.pegames.dados

import br.com.fiap.pegames.modelo.Jogador
import br.com.fiap.pegames.utilitario.toEntity
import br.com.fiap.pegames.utilitario.toModel
import javax.persistence.EntityManager

class JogadoresDAO(manager: EntityManager): DAO<Jogador, JogadorEntity>(manager, JogadorEntity::class.java) {

    override fun toEntity(objeto: Jogador): JogadorEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: JogadorEntity): Jogador {
        return entity.toModel().apply { plano = entity.plano.toModel() }
    }
}