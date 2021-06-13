package com.unisinos.sistema.controller;

import com.unisinos.sistema.config.SwaggerConfig;
import com.unisinos.sistema.model.request.ListaPrecoRequest;
import com.unisinos.sistema.model.response.ListaPrecoResponse;
import com.unisinos.sistema.service.ListaPrecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/lista-preco")
@Api(tags = SwaggerConfig.LISTA_PRECO_V1)
@AllArgsConstructor
public class ListaPrecoController {

    ListaPrecoService listaPrecoService;

    @PostMapping("/adicinar")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Adicionar lista de preço")
    @ApiResponses({
            @ApiResponse(code = 201, message = "CREATED", response = ListaPrecoResponse.class)})

    public ListaPrecoResponse adicionarListaPreco(@RequestBody @NotNull @Valid ListaPrecoRequest listaPrecoRequest) {
        return listaPrecoService.adicionarListaPreco(listaPrecoRequest);
    }
}
