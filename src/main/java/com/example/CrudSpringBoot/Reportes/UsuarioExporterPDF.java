package com.example.CrudSpringBoot.Reportes;

import com.example.CrudSpringBoot.Entity.Usuario;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class UsuarioExporterPDF {

    private List<Usuario> listaUsuarios;

    public UsuarioExporterPDF(List<Usuario> listaUsuarios) {
        super();
        this.listaUsuarios = listaUsuarios;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable tabla){
        PdfPCell celda = new PdfPCell();

        celda.setBackgroundColor(Color.BLUE);
        celda.setPadding(5);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.WHITE);

        celda.setPhrase(new Phrase("ID",fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Nombre",fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Apellido",fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Email",fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Ciudad",fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Fecha",fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Telefono",fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Genero",fuente));
        tabla.addCell(celda);
    }

    private void escribirDatosDeLaTabla(PdfPTable tabla){
        for (Usuario usuario:listaUsuarios) {
            tabla.addCell(String.valueOf(usuario.getId()));
            tabla.addCell(usuario.getNombre());
            tabla.addCell(usuario.getApellido());
            tabla.addCell(usuario.getEmail());
            tabla.addCell(usuario.getCiudad());
            tabla.addCell(usuario.getFecha().toString());
            tabla.addCell(String.valueOf(usuario.getTelefono()));
            tabla.addCell(usuario.getSexo());
        }
    }

    public void exportar(HttpServletResponse response) throws IOException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento,response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLUE);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de usuarios",fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(8);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        //linea de codigo para asignar espacios entre tablas
        tabla.setWidths(new float[]{1f,2.3f,2.3f,6f,2.3f,2.9f,3.5f,2f});
        tabla.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(tabla);
        escribirDatosDeLaTabla(tabla);

        documento.add(tabla);
        documento.close();
    }

}
