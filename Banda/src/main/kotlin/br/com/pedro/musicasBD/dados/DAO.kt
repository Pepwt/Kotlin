package br.com.pedro.musicasBD.dados

import javax.persistence.EntityManager

abstract class DAO<TModel,TEntity>(
    val manager: EntityManager,
    val entityType: Class<TEntity>
) {

    abstract fun toEntity(model: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    open fun getLista(): List<TModel> {
        val query = manager
            .createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map{ entity -> toModel(entity)}
    }

    open fun adicionar(model: TModel) {
        val entity = toEntity(model)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    private fun recuperarEntityPeloId(id: Int): TEntity {
        val query = manager.createQuery(
            "FROM ${entityType.simpleName} WHERE id = :id",
            entityType
        )
        query.setParameter("id", id)
        return query.singleResult
    }

    open fun recuperarPeloId(id: Int): TModel {
        val entity = recuperarEntityPeloId(id)
        return toModel(entity)
    }

    open fun apagar(id: Int) {
        val entity = recuperarEntityPeloId(id)
        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }
}