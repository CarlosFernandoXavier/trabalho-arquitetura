package com.unisinos.sistema.controller;

import com.unisinos.sistema.config.SwaggerConfig;
import com.unisinos.sistema.service.RelatorioService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/v1/relatorio")
@Api(tags = SwaggerConfig.RELATORIO_V1)
@AllArgsConstructor
public class RelatorioController {

    private RelatorioService relatorioService;

    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)

    public ResponseEntity<InputStream> citiesReport() {

       try {


           File file = relatorioService.relatorioTeste();
           Path path = Paths.get(file.getAbsolutePath());



       /* ClassPathResource pdfFile = new ClassPathResource("pdf-sample.pdf");

        return ResponseEntity
                .ok()
                .contentLength(pdfFile.contentLength())
                .contentType(
                        MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(pdfFile.getInputStream()));*/



           var headers = new HttpHeaders();
           headers.add("Content-Disposition", "inline; filename=" + path.getFileName());

           return ResponseEntity
                   .ok()
                   .headers(headers)
                   .contentType(MediaType.APPLICATION_PDF)
                   .body(new FileInputStream(file));
           //.body(new InputStreamResource((InputStream) file));
       }catch (Exception e) {
           e.printStackTrace();
       }
       return null;
    }
}
