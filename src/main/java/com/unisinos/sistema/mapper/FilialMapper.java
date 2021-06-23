package com.unisinos.sistema.mapper;

import com.unisinos.sistema.entity.FilialEntity;
import com.unisinos.sistema.model.FilialModel;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

public class FilialMapper {

    public static List<FilialModel> mapToModelList(List<FilialEntity> filialEntities) {
        if (ObjectUtils.isEmpty(filialEntities)) return List.of();

        return filialEntities.stream()
                .map(FilialMapper::mapToModel)
                .collect(Collectors.toList());
    }

    private static FilialModel mapToModel(FilialEntity filialEntity) {
        if (ObjectUtils.isEmpty(filialEntity)) return null;

        return FilialModel.builder()
                .id(filialEntity.getId())
                .nome(filialEntity.getNome())
                .itens(ItemMapper.mapToModelList(filialEntity.getItens()))
                .build();
    }
}
