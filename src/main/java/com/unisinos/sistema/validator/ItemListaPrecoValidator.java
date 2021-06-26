package com.unisinos.sistema.validator;

import com.unisinos.sistema.entity.ItemEntity;

import java.util.List;

public class ItemListaPrecoValidator {

    public static Boolean isExistingItem(List<ItemEntity> itemEntities, String itemCode) {
        return itemEntities.stream()
                .anyMatch(itemEntity -> itemEntity.getCodigo().equals(itemCode));
    }
}
