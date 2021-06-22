package com.unisinos.sistema.service;

import com.unisinos.sistema.mapper.ListaPrecoMapper;
import com.unisinos.sistema.model.request.ListaPrecoRequest;
import com.unisinos.sistema.model.response.ListaPrecoResponse;
import com.unisinos.sistema.repository.ListaPrecoRepository;
import com.unisinos.sistema.validator.ListaPrecoValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public List<ListaPrecoResponse> getPriceList(Integer idList) {
        List<ListaPrecoResponse> lista = new ArrayList<>();
        if (Objects.isNull(idList)) {
            lista.addAll((ListaPrecoMapper.mapToResponseList(listaPrecoRepository.findAll())));
        } else {
            lista.add(findPriceListById(idList));
        }
        return lista;
    }

    public ListaPrecoResponse findPriceListById(Integer idList) {
        return Optional.ofNullable(listaPrecoRepository.getById(idList))
                .map(ListaPrecoMapper::mapToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Lista de preço com o id = %d, não existe", idList)));
    }
}
