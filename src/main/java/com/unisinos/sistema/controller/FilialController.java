package com.unisinos.sistema.controller;

import com.unisinos.sistema.config.SwaggerConfig;
import com.unisinos.sistema.exceptionhandler.ErrorMessage;
import com.unisinos.sistema.model.response.FilialResponse;
import com.unisinos.sistema.service.FilialService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/filial")
@Api(tags = SwaggerConfig.FILIAL_V1)
@AllArgsConstructor
public class FilialController {

    private FilialService filialService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Buscar filiais")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = FilialResponse.class),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorMessage.class),
    })

    public List<FilialResponse> getSubsidiary(
            @ApiParam(name = "id", value = "Id filial", example = "4")
            @RequestParam(required = false) Integer id) {
        return filialService.getSubsidiary(id);
    }
}
