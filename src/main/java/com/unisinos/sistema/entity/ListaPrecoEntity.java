package com.unisinos.sistema.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("listaDePreco")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ListaPrecoEntity {

    @Id
    private String id;
    private String codigo;
    private String nome;
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
    List<ItemEntity> itens;

}
