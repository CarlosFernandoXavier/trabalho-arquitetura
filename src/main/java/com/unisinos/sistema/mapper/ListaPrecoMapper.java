package com.unisinos.sistema.mapper;

import com.unisinos.sistema.entity.ListaPrecoEntity;
import com.unisinos.sistema.model.request.ListaPrecoRequest;
import com.unisinos.sistema.model.response.ListaPrecoResponse;
import org.springframework.util.ObjectUtils;

public class ListaPrecoMapper {

    public static ListaPrecoEntity mapToEntity(ListaPrecoRequest listaPrecoRequest) {
        if (ObjectUtils.isEmpty(listaPrecoRequest)) return null;

        return ListaPrecoEntity.builder()
                .codigo(listaPrecoRequest.getCodigo())
                .nome(listaPrecoRequest.getNome())
                .dataInicial(listaPrecoRequest.getDataInicial())
                .dataFinal(listaPrecoRequest.getDataFinal())
                .itens(ItemMapper.mapToEntityList(listaPrecoRequest.getItens()))
                .build();
    }

    public static ListaPrecoResponse mapToResponse(ListaPrecoEntity listaPrecoEntity) {
        if (ObjectUtils.isEmpty(listaPrecoEntity)) return null;

        return ListaPrecoResponse.builder()
                .id(listaPrecoEntity.getId())
                .codigo(listaPrecoEntity.getCodigo())
                .nome(listaPrecoEntity.getNome())
                .dataInicial(listaPrecoEntity.getDataInicial())
                .dataFinal(listaPrecoEntity.getDataFinal())
                .itens(ItemMapper.mapToResponseList(listaPrecoEntity.getItens()))
                .build();
    }
}
