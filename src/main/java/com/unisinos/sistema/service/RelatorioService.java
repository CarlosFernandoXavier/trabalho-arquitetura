package com.unisinos.sistema.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.unisinos.sistema.model.FilialModel;
import com.unisinos.sistema.model.ItemModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class RelatorioService {

    private FilialService filialService;

    public File createSubsidiaryReport() {

        try {

            List<FilialModel> filiais = filialService.findAllSubsidiaries();

            String pasta = "pdf";
            Path path = Paths.get(FileSystemView.getFileSystemView()
                            .getHomeDirectory()
                            .getAbsolutePath(),
                    pasta);
            if (!Files.exists(path)) {
                path.toFile().mkdir();
            }

            String destino = path.toAbsolutePath() + "/relatorio.pdf";
            PdfDocument pdfDoc = null;

            pdfDoc = new PdfDocument(new PdfWriter(destino));

            Document documento = new Document(pdfDoc);

            documento.add(createReportTitle("Relatório de agrupamento por filiais"));

            filiais.stream().forEach(filialModel -> documento.add(createTable(filialModel)));

            documento.close();
            File file = new File(destino);
            return file;

        } catch (FileNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());
        }
    }

    private Cell celulaComBorda(String texto, TextAlignment alinnhamento) {
        Paragraph paragrafo = new Paragraph(String.format("%s", texto))
                .setTextAlignment(alinnhamento);

        return new Cell()
                .add(paragrafo);
    }

    private Table createTable(FilialModel filialModel) {

        Table tabela = new Table(UnitValue.createPercentArray(new float[]{17, 17, 17}));
        tabela.setWidth(UnitValue.createPercentValue(100))
                .setMarginTop(20);

        Cell celula = new Cell(1, 3)
                .add(new Paragraph(filialModel.getNome())
                        .setTextAlignment(TextAlignment.CENTER));

        tabela.addHeaderCell(celula);
        tabela.addCell(celulaComBorda("Código", TextAlignment.CENTER));
        tabela.addCell(celulaComBorda("Nome", TextAlignment.CENTER));
        tabela.addCell(celulaComBorda("Preço", TextAlignment.CENTER));


        filialModel.getItens().forEach(itemModel -> {
            tabela.addCell(celulaComBorda(itemModel.getCodigo(), TextAlignment.CENTER));
            tabela.addCell(celulaComBorda(itemModel.getNome(), TextAlignment.CENTER));
            tabela.addCell(celulaComBorda(itemModel.getPreco().toString(), TextAlignment.CENTER));
        });


        BigDecimal total = filialModel.getItens().stream()
                .map(ItemModel::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        tabela.addCell(new Cell(1, 2).setBorderRight(Border.NO_BORDER));

        tabela.addCell(new Cell().setBorderLeft(Border.NO_BORDER)
                .add(new Paragraph("Total: " + total))
                .setTextAlignment(TextAlignment.CENTER));

        return tabela;
    }

    private Table createReportTitle(String title) {
        Table tabela = new Table(UnitValue.createPercentArray(new float[]{17, 17, 17}));
        tabela.setWidth(UnitValue.createPercentValue(100))
                .setMarginTop(20);

        Cell celula = new Cell(1, 3).setBorder(Border.NO_BORDER)
                .add(new Paragraph(title)
                        .setTextAlignment(TextAlignment.CENTER));
        tabela.addCell(celula);
        return tabela;
    }
}
