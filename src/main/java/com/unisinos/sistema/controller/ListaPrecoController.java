package com.unisinos.sistema.controller;

import com.unisinos.sistema.config.SwaggerConfig;
import com.unisinos.sistema.exceptionhandler.ErrorMessage;
import com.unisinos.sistema.model.request.ListaPrecoRequest;
import com.unisinos.sistema.model.response.ListaPrecoResponse;
import com.unisinos.sistema.service.ListaPrecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

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
            @ApiResponse(code = 201, message = "CREATED", response = ListaPrecoResponse.class),
            @ApiResponse(code = 412, message = "PRECONDITION_FAILED", response = ErrorMessage.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = ResponseStatusException.class)
    })

    public ListaPrecoResponse addPriceList(@RequestBody @NotNull @Valid ListaPrecoRequest listaPrecoRequest) {
        return listaPrecoService.addPriceList(listaPrecoRequest);
    }

    @GetMapping("/exibir")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Exibir lista de preço")
    @ApiResponses({
            @ApiResponse(code = 201, message = "CREATED", response = ListaPrecoResponse.class),
            @ApiResponse(code = 412, message = "PRECONDITION_FAILED", response = ErrorMessage.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = ResponseStatusException.class)
    })

    public List<ListaPrecoResponse> addPriceList(Integer idList) {
//        return listaPrecoService.addPriceList(listaPrecoRequest);
        return listaPrecoService.getPriceList(idList);
    }
}
