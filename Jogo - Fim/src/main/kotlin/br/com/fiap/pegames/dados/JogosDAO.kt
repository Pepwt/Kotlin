package br.com.fiap.pegames.dados

import br.com.fiap.pegames.modelo.Jogo
import br.com.fiap.pegames.utilitario.toEntity
import br.com.fiap.pegames.utilitario.toModel
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return entity.toModel()
    }
}