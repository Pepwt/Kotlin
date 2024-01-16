package br.com.fiap.pegames.utilitario

import br.com.fiap.pegames.dados.PlanoAssinaturaEntity
import br.com.fiap.pegames.dados.PlanoAvulsoEntity
import br.com.fiap.pegames.dados.PlanoEntity
import br.com.fiap.pegames.modelo.Plano
import br.com.fiap.pegames.modelo.PlanoAssinatura
import br.com.fiap.pegames.modelo.PlanoAvulso

fun Plano.toEntity(): PlanoEntity {
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}

fun PlanoEntity.toModel(): Plano {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
    } else {
        PlanoAvulso(this.tipo, this.id)
    }
}