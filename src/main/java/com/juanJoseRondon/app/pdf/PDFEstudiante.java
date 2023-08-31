package com.juanJoseRondon.app.pdf;

import java.awt.Color;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.juanJoseRondon.app.entity.estudiantes;
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

@Component("/inicio/inicioEstudiantes")
public class PDFEstudiante  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		estudiantes objetoEstudiantes = (estudiantes) model.get("estudiantes");

		/* FUENTES Y TAMAÑOS CELDAS */
		Font fuenteT = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, Color.white);
		Font fuenteTC = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, new Color(13, 27, 42));
		Font fuenteTexto = FontFactory.getFont(FontFactory.COURIER, 10, Color.black);

		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-80, -80, 10, 10);
		document.open();
		PdfPCell celda = null;

		/* TITULO */
		PdfPTable tablaTitulo = new PdfPTable(1);
		celda = new PdfPCell(new Phrase("NOTAS DEL ESTUDIANTE", fuenteT));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(13, 27, 42));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(25);

		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);

		/* TABLA PARA MOSTRAR INFORMACION */
		PdfPTable tablaEstudiantes = new PdfPTable(6);
		
		tablaEstudiantes.setWidths(new float[] { 0.4f, 1f, 1f, 1f, 1f, 1.7f});

		celda = new PdfPCell(new Phrase("T.D", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);

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

		celda = new PdfPCell(new Phrase("Correo", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEstudiantes.addCell(celda);

		celda = new PdfPCell(new Phrase(objetoEstudiantes.getTipoDocumento(), fuenteTexto));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(objetoEstudiantes.getDocumento(), fuenteTexto));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);

		celda = new PdfPCell(new Phrase(objetoEstudiantes.getNombre(), fuenteTexto));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);

		celda = new PdfPCell(new Phrase(objetoEstudiantes.getApellido(), fuenteTexto));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);

		celda = new PdfPCell(new Phrase(objetoEstudiantes.getGrado().getGrado(), fuenteTexto));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);

		celda = new PdfPCell(new Phrase(objetoEstudiantes.getCorreoElectronico(), fuenteTexto));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		tablaEstudiantes.setSpacingAfter(20);
		/*NNOTAS ACADEMICAS*/
		
		PdfPTable tablaMatematicas = new PdfPTable(3);
		celda = new PdfPCell(new Phrase("Matematicas P.1", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaMatematicas.addCell(celda);

		celda = new PdfPCell(new Phrase("Matematicas P.2", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaMatematicas.addCell(celda);

		celda = new PdfPCell(new Phrase("Matematicas P.3", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaMatematicas.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getMatematicas1()), fuenteTexto));
		celda.setPadding(5);
		tablaMatematicas.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getMatematicas2()), fuenteTexto));
		celda.setPadding(5);
		tablaMatematicas.addCell(celda);

		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getMatematicas3()), fuenteTexto));
		celda.setPadding(5);
		tablaMatematicas.addCell(celda);
		
		
		
		PdfPTable tablaEspañol = new PdfPTable(3);
		celda = new PdfPCell(new Phrase("Español P.1", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEspañol.addCell(celda);

		celda = new PdfPCell(new Phrase("Español P.2", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEspañol.addCell(celda);

		celda = new PdfPCell(new Phrase("Español P.3", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEspañol.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getEspañol1()), fuenteTexto));
		celda.setPadding(5);
		tablaEspañol.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getEspañol2()), fuenteTexto));
		celda.setPadding(5);
		tablaEspañol.addCell(celda);

		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getEspañol3()), fuenteTexto));
		celda.setPadding(5);
		tablaEspañol.addCell(celda);
		
		
		
		PdfPTable tablaSociales = new PdfPTable(3);
		celda = new PdfPCell(new Phrase("Sociales P.1", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaSociales.addCell(celda);

		celda = new PdfPCell(new Phrase("Sociales P.2", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaSociales.addCell(celda);

		celda = new PdfPCell(new Phrase("Sociales P.3", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaSociales.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getSociales1()), fuenteTexto));
		celda.setPadding(5);
		tablaSociales.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getSociales2()), fuenteTexto));
		celda.setPadding(5);
		tablaSociales.addCell(celda);

		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getSociales3()), fuenteTexto));
		celda.setPadding(5);
		tablaSociales.addCell(celda);
		
		
		
		PdfPTable tablaEmprendimiento = new PdfPTable(3);
		celda = new PdfPCell(new Phrase("Emprendimiento P.1", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEmprendimiento.addCell(celda);

		celda = new PdfPCell(new Phrase("Emprendimiento P.2", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEmprendimiento.addCell(celda);

		celda = new PdfPCell(new Phrase("Emprendimiento P.3", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEmprendimiento.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getEmprendimiento1()), fuenteTexto));
		celda.setPadding(5);
		tablaEmprendimiento.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getEmprendimiento2()), fuenteTexto));
		celda.setPadding(5);
		tablaEmprendimiento.addCell(celda);

		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getEmprendimiento3()), fuenteTexto));
		celda.setPadding(5);
		tablaEmprendimiento.addCell(celda);
		
		
		
		PdfPTable tablaIngles = new PdfPTable(3);
		celda = new PdfPCell(new Phrase("Ingles P.1", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaIngles.addCell(celda);

		celda = new PdfPCell(new Phrase("Ingles P.2", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaIngles.addCell(celda);

		celda = new PdfPCell(new Phrase("Ingles P.3", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaIngles.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getIngles1()), fuenteTexto));
		celda.setPadding(5);
		tablaIngles.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getIngles2()), fuenteTexto));
		celda.setPadding(5);
		tablaIngles.addCell(celda);

		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getIngles3()), fuenteTexto));
		celda.setPadding(5);
		tablaIngles.addCell(celda);
		
		
		
		PdfPTable tablaContabilidad = new PdfPTable(3);
		celda = new PdfPCell(new Phrase("Contablidad P.1", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaContabilidad.addCell(celda);

		celda = new PdfPCell(new Phrase("Contabilidad P.2", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaContabilidad.addCell(celda);

		celda = new PdfPCell(new Phrase("Contabilidad P.3", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaContabilidad.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getContabilidad1()), fuenteTexto));
		celda.setPadding(5);
		tablaContabilidad.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getContabilidad2()), fuenteTexto));
		celda.setPadding(5);
		tablaContabilidad.addCell(celda);

		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getContabilidad3()), fuenteTexto));
		celda.setPadding(5);
		tablaContabilidad.addCell(celda);
		
		
		
		PdfPTable tablaInformatica = new PdfPTable(3);
		celda = new PdfPCell(new Phrase("Informatica P.1", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaInformatica.addCell(celda);

		celda = new PdfPCell(new Phrase("Informatica P.2", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaInformatica.addCell(celda);

		celda = new PdfPCell(new Phrase("Informatica P.3", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaInformatica.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getInformatica1()), fuenteTexto));
		celda.setPadding(5);
		tablaInformatica.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getInformatica2()), fuenteTexto));
		celda.setPadding(5);
		tablaInformatica.addCell(celda);

		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getInformatica3()), fuenteTexto));
		celda.setPadding(5);
		tablaInformatica.addCell(celda);
		
		
		
		PdfPTable tablaEduFisica = new PdfPTable(3);
		celda = new PdfPCell(new Phrase("Educación Fisica P.1", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEduFisica.addCell(celda);

		celda = new PdfPCell(new Phrase("Educación Fisica P.2", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEduFisica.addCell(celda);

		celda = new PdfPCell(new Phrase("Educación Fisica P.3", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaEduFisica.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getEduFisica1()), fuenteTexto));
		celda.setPadding(5);
		tablaEduFisica.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getEduFisica2()), fuenteTexto));
		celda.setPadding(5);
		tablaEduFisica.addCell(celda);

		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getEduFisica3()), fuenteTexto));
		celda.setPadding(5);
		tablaEduFisica.addCell(celda);
		
		
		
		PdfPTable tablaArtistica = new PdfPTable(3);
		celda = new PdfPCell(new Phrase("Artistica P.1", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaArtistica.addCell(celda);

		celda = new PdfPCell(new Phrase("Artistica P.2", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaArtistica.addCell(celda);

		celda = new PdfPCell(new Phrase("Artistica P.3", fuenteTC));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaArtistica.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getArtistica1()), fuenteTexto));
		celda.setPadding(5);
		tablaArtistica.addCell(celda);
		
		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getArtistica2()), fuenteTexto));
		celda.setPadding(5);
		tablaArtistica.addCell(celda);

		celda = new PdfPCell(new Phrase(toString().valueOf(objetoEstudiantes.getArtistica3()), fuenteTexto));
		celda.setPadding(5);
		tablaArtistica.addCell(celda);
		
		
		
		

		document.add(tablaTitulo);
		document.add(tablaEstudiantes);
		document.add(tablaMatematicas);
		document.add(tablaEspañol);
		document.add(tablaSociales);
		document.add(tablaEmprendimiento);
		document.add(tablaIngles);
		document.add(tablaContabilidad);
		document.add(tablaInformatica);
		document.add(tablaEduFisica);
		document.add(tablaArtistica);
		
		
	}

}
