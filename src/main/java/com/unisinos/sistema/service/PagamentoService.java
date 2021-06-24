package com.unisinos.sistema.service;

import com.unisinos.sistema.entity.PagamentoEntity;
import com.unisinos.sistema.mapper.PagamentoMapper;
import com.unisinos.sistema.model.request.PagamentoRequest;
import com.unisinos.sistema.model.response.PagamentoResponse;
import com.unisinos.sistema.repository.PagamentoRepository;
import com.unisinos.sistema.validator.PagamentoValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PagamentoService {

    private PagamentoRepository pagamentoRepository;
    private SequenceService sequenceService;

    public PagamentoResponse payment(PagamentoRequest pagamentoRequest) {

        PagamentoValidator.validateItemValue(pagamentoRequest);
        PagamentoValidator.validateCupomValue(pagamentoRequest);
        PagamentoEntity pagamentoEntity = PagamentoMapper
                .mapToEntity(pagamentoRequest, sequenceService.getSequence("pagamento_sequence"));

        return PagamentoMapper.mapToResponse(pagamentoRepository.save(pagamentoEntity));
    }
}
