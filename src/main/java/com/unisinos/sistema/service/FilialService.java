package com.unisinos.sistema.service;

import com.unisinos.sistema.mapper.FilialMapper;
import com.unisinos.sistema.model.FilialModel;
import com.unisinos.sistema.repository.FilialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilialService {

    private FilialRepository filialRepository;

    List<FilialModel> findAllSubsidiaries() {
        return FilialMapper.mapToModelList(filialRepository.findAll());
    }
}
