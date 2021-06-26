package com.unisinos.sistema.mapper;

import com.unisinos.sistema.entity.ItemEntity;
import com.unisinos.sistema.model.request.ItemListaPrecoRequest;
import org.springframework.util.ObjectUtils;

public class ItemListaPrecoMapper {

    public static ItemEntity mapToEntity(ItemListaPrecoRequest itemListaPrecoRequest) {
        if (ObjectUtils.isEmpty(itemListaPrecoRequest)) return null;

        return ItemEntity.builder()
                .codigo(itemListaPrecoRequest.getCodigo())
                .nome(itemListaPrecoRequest.getNome())
                .preco(itemListaPrecoRequest.getPreco())
                .build();
    }
}
