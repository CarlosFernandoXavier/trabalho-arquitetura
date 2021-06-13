package com.unisinos.sistema.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemRequest {
    @ApiModelProperty(value = "código do item", example = "12356")
    @NotEmpty(message = "codigo deve ser preenchido")
    private String codigo;
    @ApiModelProperty(value = "nome do item", example = "Chuteira de couro")
    @NotEmpty(message = "nome do item deve ser preenchido")
    private String nome;
    @ApiModelProperty(value = "preço do item", example = "127.56")
    @NotNull
    private BigDecimal preco;
}