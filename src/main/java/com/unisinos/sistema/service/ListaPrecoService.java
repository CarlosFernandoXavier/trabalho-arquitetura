package com.unisinos.sistema.service;

import com.unisinos.sistema.mapper.ListaPrecoMapper;
import com.unisinos.sistema.model.request.ListaPrecoRequest;
import com.unisinos.sistema.model.response.ListaPrecoResponse;
import com.unisinos.sistema.repository.ListaPrecoRepository;
import com.unisinos.sistema.validator.ListaPrecoValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListaPrecoService {

    ListaPrecoRepository listaPrecoRepository;
    SequenceService sequenceService;

    public ListaPrecoResponse addPriceList(ListaPrecoRequest listaPrecoRequest) {
        ListaPrecoValidator.validatePriceListDate(listaPrecoRequest);
        ListaPrecoValidator.validateSubsidiary(listaPrecoRequest);
        ListaPrecoValidator.validateItems(listaPrecoRequest);
        Integer sequence = sequenceService.getSequence("lista_preco_sequence");
        var listaPrecoEntity = ListaPrecoMapper.mapToEntity(listaPrecoRequest, sequence);

        return ListaPrecoMapper.mapToResponse(listaPrecoRepository.save(listaPrecoEntity));

    }
}
