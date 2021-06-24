package com.unisinos.sistema.validator;

import com.unisinos.sistema.model.request.ItemRequest;
import com.unisinos.sistema.model.request.PagamentoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

public class PagamentoValidator {

    public static void validateItemValue(PagamentoRequest pagamentoRequest) {
        BigDecimal valorItens = pagamentoRequest.getItens().stream()
                .map(ItemRequest::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (!valorItens.equals(pagamentoRequest.getValorTotal())) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
                    "Valor total difere do valor dos itens");
        }
    }

    public static void validateCupomValue(PagamentoRequest pagamentoRequest) {
        if (!ObjectUtils.isEmpty(pagamentoRequest.getValorCupom()) &&
                pagamentoRequest.getValorTotal().compareTo(pagamentoRequest.getValorCupom()) == 1) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
                    "Vale presente é menor que o valor da compra");
        }
    }


}
