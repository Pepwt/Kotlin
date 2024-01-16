package br.com.fiap.pegames.dados

import br.com.fiap.pegames.modelo.Aluguel
import br.com.fiap.pegames.utilitario.toEntity
import br.com.fiap.pegames.utilitario.toModel
import javax.persistence.EntityManager

class AluguelDAO(manager: EntityManager): br.com.fiap.pegames.dados.DAO<Aluguel, br.com.fiap.pegames.dados.AluguelEntity>(manager, _root_ide_package_.br.com.fiap.pegames.dados.AluguelEntity::class.java) {
    override fun toEntity(objeto: Aluguel): _root_ide_package_.br.com.fiap.pegames.dados.AluguelEntity {
        return _root_ide_package_.br.com.fiap.pegames.dados.AluguelEntity(
            objeto.jogador.toEntity(),
            objeto.jogo.toEntity(),
            objeto.periodo
        )
            .apply { valorDoAluguel = objeto.valorDoAluguel
                id = objeto.id}
    }

    override fun toModel(entity: _root_ide_package_.br.com.fiap.pegames.dados.AluguelEntity): Aluguel {
        return Aluguel(entity.gamer.toModel(), entity.jogo.toModel(), entity.periodo)
            .apply { id = entity.id
            }
    }

}