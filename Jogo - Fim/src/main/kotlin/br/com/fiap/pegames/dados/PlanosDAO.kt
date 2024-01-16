package br.com.fiap.pegames.dados

import br.com.fiap.pegames.modelo.Plano
import br.com.fiap.pegames.modelo.PlanoAssinatura
import br.com.fiap.pegames.modelo.PlanoAvulso
import br.com.fiap.pegames.utilitario.toEntity
import br.com.fiap.pegames.utilitario.toModel
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {
    override fun toEntity(plano: Plano): PlanoEntity {
        return plano.toEntity()
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return entity.toModel()
    }
}