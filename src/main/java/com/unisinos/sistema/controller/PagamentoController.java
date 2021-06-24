package com.unisinos.sistema.controller;

import com.unisinos.sistema.config.SwaggerConfig;
import com.unisinos.sistema.exceptionhandler.ErrorMessage;
import com.unisinos.sistema.model.request.PagamentoRequest;
import com.unisinos.sistema.model.response.ListaPrecoResponse;
import com.unisinos.sistema.model.response.PagamentoResponse;
import com.unisinos.sistema.service.PagamentoService;
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
@RequestMapping("/v1/pagamento")
@Api(tags = SwaggerConfig.PAGAMENTO_V1)
@AllArgsConstructor
public class PagamentoController {

    private PagamentoService pagamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Gravar pagamento")
    @ApiResponses({
            @ApiResponse(code = 201, message = "CREATED", response = ListaPrecoResponse.class),
            @ApiResponse(code = 412, message = "PRECONDITION_FAILED", response = ErrorMessage.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = ErrorMessage.class)
    })

    public PagamentoResponse payment(@RequestBody @NotNull @Valid PagamentoRequest pagamentoRequest) {
        return pagamentoService.payment(pagamentoRequest);
    }
}
