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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.filechooser.FileSystemView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@AllArgsConstructor
public class RelatorioService {

    public File relatorioTeste() {

        try {
            String pasta = "pdf";
            Path path = Paths.get(FileSystemView.getFileSystemView()
                            .getHomeDirectory()
                            .getAbsolutePath(),
                    pasta);
            if (!Files.exists(path)) {
                path.toFile().mkdir();
            }

            String destino = path.toAbsolutePath() + "/relatorio.pdf";
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(destino));
            Document documento = new Document(pdfDoc);


            Table tabela = new Table(UnitValue.createPercentArray(new float[]{17, 17}));
            tabela.setWidth(UnitValue.createPercentValue(100));

            var celula = celulaSemBorda("Procedimento", "teste", TextAlignment.LEFT);
            tabela.addCell(celula);

            celula = celulaSemBorda("Id cirurgia", "teste", TextAlignment.RIGHT);
            tabela.addCell(celula);

            documento.add(tabela);

            documento.close();
            File file = new File(destino);
            return file;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Cell celulaSemBorda(String texto, String conteudo, TextAlignment alinnhamento) {
        Paragraph paragrafo = new Paragraph(String.format("%s: %s", texto, conteudo))
                .setTextAlignment(alinnhamento);

        return new Cell()
                .add(paragrafo)
                .setBorder(Border.NO_BORDER);
    }

    private Cell celulaComBorda(String texto, TextAlignment alinnhamento) {
        Paragraph paragrafo = new Paragraph(String.format("%s", texto))
                .setTextAlignment(alinnhamento);

        return new Cell()
                .add(paragrafo);
    }
}
