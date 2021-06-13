package com.unisinos.sistema.controller;

import com.unisinos.sistema.entity.ItemEntity;
import com.unisinos.sistema.entity.ListaPrecoEntity;
import com.unisinos.sistema.model.ListaPrecoModel;
import com.unisinos.sistema.repository.ListaPrecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/lista-preco")
@AllArgsConstructor
public class ListaPrecoController {

    ListaPrecoRepository listaPrecoRepository;

    @PostMapping("/adicinar")
    @ResponseStatus(HttpStatus.OK)
    public void adicionarListaPreco(@RequestBody @NotNull @Valid ListaPrecoModel listaPrecoModel) {
        var lista = ListaPrecoEntity.builder()
                .codigo("1234")
                .nome("Liquida Porto Alegre")
                .dataInicial(LocalDateTime.now())
                .dataFinal(LocalDateTime.of(2021, 12, 12, 19, 55))
                .itens(List.of(ItemEntity.builder()
                                .codigo("12AC")
                                .nome("Tênis Nike azul")
                                .preco(BigDecimal.valueOf(127.56))
                                .build(),
                        ItemEntity.builder()
                                .codigo("12AC")
                                .nome("Tênis Nike vermelho")
                                .preco(BigDecimal.valueOf(147.56))
                                .build()))
                .build();
        listaPrecoRepository.save(lista);
    }
}
