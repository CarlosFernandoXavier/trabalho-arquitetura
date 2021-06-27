package com.unisinos.sistema.service;

import com.unisinos.sistema.entity.FilialEntity;
import com.unisinos.sistema.mapper.FilialMapper;
import com.unisinos.sistema.model.response.FilialResponse;
import com.unisinos.sistema.repository.FilialRepository;
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
public class FilialService {

    private FilialRepository filialRepository;

    public List<FilialEntity> findAllSubsidiaries() {
        return filialRepository.findAll();
    }

    public List<FilialResponse> getSubsidiary(Integer id) {
        if (Objects.isNull(id)) {
            return FilialMapper.mapToResponseList(findAllSubsidiaries());
        } else {
            List<FilialResponse> filialResponses = new ArrayList<>();
            filialResponses.add(FilialMapper.mapToResponse(findSubsidiaryById(id)));
            return filialResponses;
        }
    }

    public FilialEntity findSubsidiaryById(Integer id) {
        return Optional.ofNullable(filialRepository.getById(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Filial com o id: %d, não foi encontrada", id)));
    }
}
