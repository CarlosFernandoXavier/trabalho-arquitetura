package com.unisinos.sistema.repository;

import com.unisinos.sistema.entity.ListaPrecoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaPrecoRepository extends MongoRepository<ListaPrecoEntity, String> {

    ListaPrecoEntity save(ListaPrecoEntity listaPrecoEntity);

    ListaPrecoEntity getByCodigo(String codigo);

}
