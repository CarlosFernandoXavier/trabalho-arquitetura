package com.unisinos.sistema.model;

import com.unisinos.sistema.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ListaPrecoModel {
    private String id;
    private String codigo;
    private String nome;
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
    List<ItemModel> itens;
}
