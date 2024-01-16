package br.com.pedro.musicasBD.dados

import br.com.pedro.musicasBD.extensions.toEntity
import br.com.pedro.musicasBD.extensions.toModel
import br.com.pedro.musicasBD.modelos.Banda
import javax.persistence.EntityManager

class BandaDAO(manager: EntityManager)
    : DAO<Banda, BandaEntity>(manager, BandaEntity::class.java)
{
    override fun toModel(entity: BandaEntity): Banda {
        return entity.toModel()
    }

    override fun toEntity(model: Banda): BandaEntity {
        return model.toEntity()
    }
}