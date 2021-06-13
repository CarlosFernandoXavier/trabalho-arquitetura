package com.unisinos.sistema.service;

import com.unisinos.sistema.mapper.ListaPrecoMapper;
import com.unisinos.sistema.model.request.ListaPrecoRequest;
import com.unisinos.sistema.model.response.ListaPrecoResponse;
import com.unisinos.sistema.repository.ListaPrecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListaPrecoService {

    ListaPrecoRepository listaPrecoRepository;

    public ListaPrecoResponse adicionarListaPreco(ListaPrecoRequest listaPrecoModel) {
        var listaPrecoEntity = ListaPrecoMapper.mapToEntity(listaPrecoModel);
        var resposta = listaPrecoRepository.save(listaPrecoEntity);
        return ListaPrecoMapper.mapToResponse(resposta);
    }
}
