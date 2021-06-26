package com.unisinos.sistema.controller;

import com.unisinos.sistema.config.SwaggerConfig;
import com.unisinos.sistema.exceptionhandler.ErrorMessage;
import com.unisinos.sistema.model.request.ItemListaPrecoRequest;
import com.unisinos.sistema.model.response.ListaPrecoResponse;
import com.unisinos.sistema.service.ListaPrecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/item")
@Api(tags = SwaggerConfig.LISTA_PRECO_V1)
@AllArgsConstructor
public class ItemController {

    private ListaPrecoService listaPrecoService;

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Adicionar item a lista de preço")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = ListaPrecoResponse.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorMessage.class),
            @ApiResponse(code = 412, message = "PRECONDITION_FAILED", response = ErrorMessage.class)
    })

    public ListaPrecoResponse addPriceList(@RequestBody @NotNull @Valid ItemListaPrecoRequest itemListaPrecoRequest) {
        return listaPrecoService.addItem(itemListaPrecoRequest);
    }
}
