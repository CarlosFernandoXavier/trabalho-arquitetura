package com.unisinos.sistema.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ListaPrecoRequest {
    @ApiModelProperty(value = "código da lista de preço", example = "895D")
    @NotEmpty(message = "codigo deve ser preenchido")
    private String codigo;

    @ApiModelProperty(value = "Nome da lista da lista de preço", example = "Torra torra NH")
    @NotEmpty(message = "nome deve ser preenchido")
    private String nome;

    @ApiModelProperty(value = "Data inicial da lista de preço")
    @NotNull
    private LocalDateTime dataInicial;

    @ApiModelProperty(value = "Data de expiração da lista de preço")
    @NotNull
    private LocalDateTime dataFinal;

    @ApiModelProperty(value = "Itens da lista de preço")
    @NotNull
    @Valid
    List<ItemRequest> itens;
}
