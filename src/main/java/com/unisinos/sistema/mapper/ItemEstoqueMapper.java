package com.unisinos.sistema.mapper;

import com.unisinos.sistema.entity.ItemEstoqueEntity;
import com.unisinos.sistema.model.ItemEstoqueModel;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ItemEstoqueMapper {

    public static List<ItemEstoqueModel> mapToModelList(List<ItemEstoqueEntity> itemEntities) {
        if (ObjectUtils.isEmpty(itemEntities)) return Collections.emptyList();

        return itemEntities.stream()
                .map(ItemEstoqueMapper::mapToModel)
                .collect(Collectors.toList());
    }

    private static ItemEstoqueModel mapToModel(ItemEstoqueEntity itemEstoqueEntity) {
        if (ObjectUtils.isEmpty(itemEstoqueEntity)) return null;

        return ItemEstoqueModel.builder()
                .codigo(itemEstoqueEntity.getCodigo())
                .nome(itemEstoqueEntity.getNome())
                .quantidade(itemEstoqueEntity.getQuantidade())
                .fornecedor(itemEstoqueEntity.getFornecedor())
                .build();
    }
}
