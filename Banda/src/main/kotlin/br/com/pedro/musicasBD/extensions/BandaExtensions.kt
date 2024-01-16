package br.com.pedro.musicasBD.extensions

import br.com.pedro.musicasBD.dados.BandaEntity
import br.com.pedro.musicasBD.modelos.Banda

fun Banda.toEntity(): BandaEntity {
    return BandaEntity(this.nome, this.descricao, this.id)
}

fun BandaEntity.toModel(): Banda {
    return Banda(this.nome, this.descricao, this.id)
}
