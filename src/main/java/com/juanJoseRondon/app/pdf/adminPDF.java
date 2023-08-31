package com.juanJoseRondon.app.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.juanJoseRondon.app.entity.estudiantes;

@Component("/inicio/listaEstudiantesGrado")
public class adminPDF extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<estudiantes> listadoEstudiantes = (List<estudiantes>) model.get("estudiantes");
		
		/*FUENTES Y TAMAÑOS CELDAS*/
		Font fuenteT = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, Color.white);
		Font fuenteTC = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, new Color(13,27,42));
		Font fuenteTexto = FontFactory.getFont(FontFactory.COURIER, 10, Color.black);
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-80, -80, 10, 10);
		document.open();
		PdfPCell celda = null;
		
		/*TITULO*/
		PdfPTable tablaTitulo = new PdfPTable(1);
		celda = new PdfPCell(new Phrase("LISTADO ESTUDIANTES - JUAN JOSE RONDÓN", fuenteT));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(13,27,42));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(25);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		/*TABLA PARA MOSTRAR INFORMACION*/
		PdfPTable tablaEstudiantes = new PdfPTable(11);
		tablaEstudiantes.setWidths(new float[] {1f,1f,1f,0.8f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.8f});
		
		celda = new PdfPCell(new Phrase("Documento", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Nombre", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Apellido", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Grado", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Nota 1", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Nota 2", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Nota 3", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Nota 4", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Nota 5", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Nota 6", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Definitiva", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);
		
		for (estudiantes estudiantes : listadoEstudiantes) {
			celda = new PdfPCell(new Phrase(estudiantes.getDocumento(), fuenteTexto));
			celda.setPadding(5);
			tablaEstudiantes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(estudiantes.getNombre(), fuenteTexto));
			celda.setPadding(5);
			tablaEstudiantes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(estudiantes.getApellido(), fuenteTexto));
			celda.setPadding(5);
			tablaEstudiantes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(estudiantes.getGrado().getGrado(), fuenteTexto));
			celda.setPadding(5);
			tablaEstudiantes.addCell(celda);
			
			celda = new PdfPCell(new Phrase("", fuenteTexto));
			celda.setPadding(5);
			tablaEstudiantes.addCell(celda);
			
			celda = new PdfPCell(new Phrase("", fuenteTexto));
			celda.setPadding(5);
			tablaEstudiantes.addCell(celda);
			
			celda = new PdfPCell(new Phrase("", fuenteTexto));
			celda.setPadding(5);
			tablaEstudiantes.addCell(celda);
			
			celda = new PdfPCell(new Phrase("", fuenteTexto));
			celda.setPadding(5);
			tablaEstudiantes.addCell(celda);
			
			celda = new PdfPCell(new Phrase("", fuenteTexto));
			celda.setPadding(5);
			tablaEstudiantes.addCell(celda);
			
			celda = new PdfPCell(new Phrase("", fuenteTexto));
			celda.setPadding(5);
			tablaEstudiantes.addCell(celda);
			
			celda = new PdfPCell(new Phrase("", fuenteTexto));
			celda.setPadding(5);
			tablaEstudiantes.addCell(celda);
			
		}
		
		
		document.add(tablaTitulo);
		document.add(tablaEstudiantes);
		
		
	}
	
}
