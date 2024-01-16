package br.com.pedro.musicasBD.dados

import br.com.pedro.musicasBD.extensions.toEntity
import br.com.pedro.musicasBD.extensions.toModel
import br.com.pedro.musicasBD.modelos.Album
import javax.persistence.EntityManager

class AlbumDAO(manager: EntityManager)
    : DAO<Album, AlbumEntity>(manager, AlbumEntity::class.java) {
    override fun toEntity(model: Album): AlbumEntity {
        return model.toEntity()
    }

    override fun toModel(entity: AlbumEntity): Album {
        return entity.toModel()
    }
}