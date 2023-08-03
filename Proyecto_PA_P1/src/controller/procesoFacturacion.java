package controller;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import model.Cliente;
import model.Producto;

import java.awt.Color;
import java.util.Date;
import java.io.File;
import java.io.IOException;

public class procesoFacturacion extends Thread
{
	private String fileName = "src/documents/factura.pdf";
	private String image="src/resources/logo_ST.png";
	private Logica_View_sell_product lvsp;
	private PDType1Font a = new PDType1Font(FontName.HELVETICA_BOLD);
	private PDType1Font b = new PDType1Font(FontName.HELVETICA);
	private Color morado = new Color(116,68,196);
	private Color morado_o = new Color(92,37,180);
	
	public procesoFacturacion(Logica_View_sell_product lvsp)
	{
		this.lvsp=lvsp;
	}
	
	private void crear()
	{
		try (PDDocument document = new PDDocument()) 
		{
			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.beginText();
			contentStream.setFont(a, 40);
			contentStream.setNonStrokingColor(morado_o);
			contentStream.newLineAtOffset(110, 783);
			contentStream.showText("SUPER-TIENDAS");
			contentStream.endText();
			contentStream.beginText();
			contentStream.setFont(a, 15);
			contentStream.setNonStrokingColor(Color.black);
			contentStream.newLineAtOffset(10, 730);
			contentStream.showText("Av. Isabel La Católica N. 23-52 y Madrid");
			contentStream.endText();
			contentStream.beginText();
			contentStream.setFont(a, 15);
			contentStream.setNonStrokingColor(Color.black);
			contentStream.newLineAtOffset(10, 710);
			contentStream.showText("Fecha: ");
			contentStream.endText();
			contentStream.beginText();
			contentStream.setFont(b, 15);
			contentStream.newLineAtOffset(60, 710);
			contentStream.showText(new Date().toString());
			contentStream.endText();
			contentStream.beginText();
			contentStream.setFont(a, 15);
			contentStream.newLineAtOffset(10, 680);
			contentStream.showText("Cliente:");
			contentStream.endText();
			contentStream.beginText();
			contentStream.setFont(b, 15);
			contentStream.newLineAtOffset(70, 680);
			for(Cliente cl:Administrar_info.clientes)
			{
				if(cl.getCedula().equals(this.lvsp.vsp.txt_cedula.getText()))
				{
					contentStream.showText(" "+cl.getName());
					break;
				}
			}
			contentStream.endText();
			contentStream.beginText();
			contentStream.setFont(a, 15);
			contentStream.newLineAtOffset(10, 660);
			contentStream.showText("Cédula:");
			contentStream.endText();
			contentStream.beginText();
			contentStream.setFont(b, 15);
			contentStream.newLineAtOffset(70, 660);
			contentStream.showText(" "+this.lvsp.vsp.txt_cedula.getText());
			contentStream.endText();
			contentStream.beginText();
			contentStream.setFont(a, 15);
			contentStream.setNonStrokingColor(morado);
			contentStream.newLineAtOffset(10, 630);
			contentStream.showText("PRODUCTOS");
			contentStream.endText();
			contentStream.beginText();
			contentStream.newLineAtOffset(140, 630);
			contentStream.showText("TIPO");
			contentStream.endText();
			contentStream.beginText();
			contentStream.newLineAtOffset(210, 630);
			contentStream.showText("PRECIO");
			contentStream.endText();
			contentStream.beginText();
			contentStream.newLineAtOffset(290, 630);
			contentStream.showText("UNIDADES");
			contentStream.endText();
			contentStream.beginText();
			contentStream.newLineAtOffset(400, 630);
			contentStream.showText("GRAMOS");
			contentStream.endText();
			contentStream.beginText();
			contentStream.newLineAtOffset(490, 630);
			contentStream.setNonStrokingColor(morado_o);
			contentStream.showText("TOTAL");
			contentStream.endText();
			int y1=630;
			for(Producto p: Administrar_info.productos_vendidos)
			{
				y1-=30;
				contentStream.beginText();
				contentStream.setFont(b, 15);
				contentStream.setNonStrokingColor(Color.black);
				contentStream.newLineAtOffset(10, y1);
				contentStream.showText(p.getName());
				contentStream.endText();
				contentStream.beginText();
				contentStream.newLineAtOffset(140, y1);
				contentStream.showText(p.getTipo());
				contentStream.endText();
				contentStream.beginText();
				contentStream.newLineAtOffset(210, y1);
				contentStream.showText("$"+p.getPrecio());
				contentStream.endText();
				contentStream.beginText();
				contentStream.newLineAtOffset(290, y1);
				if(p.getTipo().equals("Unidad"))
					contentStream.showText(p.getUnidades());
				contentStream.endText();
				contentStream.beginText();
				contentStream.newLineAtOffset(400, y1);
				if(p.getTipo().equals("Peso"))
					contentStream.showText(p.getPeso());
				contentStream.endText();
				contentStream.beginText();
				contentStream.newLineAtOffset(490, y1);
				if(p.getTipo().equals("Peso"))
					contentStream.showText("$"+Float.parseFloat(p.getPeso())*Float.parseFloat(p.getPrecio()));
				else
					contentStream.showText("$"+Integer.parseInt(p.getUnidades())*Float.parseFloat(p.getPrecio()));
				contentStream.endText();
			}
			y1-=30;
			contentStream.beginText();
			contentStream.setFont(a, 15);
			contentStream.setNonStrokingColor(morado_o);
			contentStream.newLineAtOffset(400, y1);
			contentStream.showText("Subtotal: ");
			contentStream.endText();
			contentStream.beginText();
			contentStream.setFont(b, 15);
			contentStream.setNonStrokingColor(Color.black);
			contentStream.newLineAtOffset(490, y1);
			contentStream.showText("$"+this.lvsp.vsp.txt_subTotal.getText());
			contentStream.endText();
			y1-=30;
			contentStream.beginText();
			contentStream.setFont(a, 15);
			contentStream.setNonStrokingColor(morado_o);
			contentStream.newLineAtOffset(400, y1);
			contentStream.showText("IVA: ");
			contentStream.endText();
			contentStream.beginText();
			contentStream.setFont(b, 15);
			contentStream.setNonStrokingColor(Color.black);
			contentStream.newLineAtOffset(490, y1);
			contentStream.showText("$"+this.lvsp.vsp.txt_iva.getText());
			contentStream.endText();
			y1-=30;
			contentStream.beginText();
			contentStream.setFont(a, 15);
			contentStream.setNonStrokingColor(morado_o);
			contentStream.newLineAtOffset(400, y1);
			contentStream.showText("Total: ");
			contentStream.endText();
			contentStream.beginText();
			contentStream.setFont(b, 15);
			contentStream.setNonStrokingColor(Color.black);
			contentStream.newLineAtOffset(490, y1);
			contentStream.showText("$"+this.lvsp.vsp.txt_total.getText());
			contentStream.endText();
			if(this.lvsp.vsp.rbtn_efectivo.isSelected())
			{
				contentStream.beginText();
				contentStream.setFont(a, 15);
				contentStream.setNonStrokingColor(morado_o);
				contentStream.newLineAtOffset(10, y1);
				contentStream.showText("Tipo de Pago: ");
				contentStream.endText();
				contentStream.beginText();
				contentStream.setFont(b, 15);
				contentStream.setNonStrokingColor(Color.black);
				contentStream.newLineAtOffset(140, y1);
				contentStream.showText("Efectivo");
				contentStream.endText();
			}
			else if(this.lvsp.vsp.rbtn_corriente.isSelected())
			{
				contentStream.beginText();
				contentStream.setFont(a, 15);
				contentStream.setNonStrokingColor(morado_o);
				contentStream.newLineAtOffset(10, y1);
				contentStream.showText("Tipo de Pago: ");
				contentStream.endText();
				contentStream.beginText();
				contentStream.setFont(b, 15);
				contentStream.setNonStrokingColor(Color.black);
				contentStream.newLineAtOffset(140, y1);
				contentStream.showText("Corriente");
				contentStream.endText();
			}
			else
			{
				contentStream.beginText();
				contentStream.setFont(a, 15);
				contentStream.setNonStrokingColor(morado_o);
				contentStream.newLineAtOffset(10, y1);
				contentStream.showText("Tipo de Pago: ");
				contentStream.endText();
				contentStream.beginText();
				contentStream.setFont(b, 15);
				contentStream.setNonStrokingColor(Color.black);
				contentStream.newLineAtOffset(140, y1);
				contentStream.showText("Diferido");
				contentStream.endText();
				y1-=30;
				contentStream.beginText();
				contentStream.setFont(a, 15);
				contentStream.setNonStrokingColor(morado_o);
				contentStream.newLineAtOffset(10, y1);
				contentStream.showText("Tiempo de pago: ");
				contentStream.endText();
				contentStream.beginText();
				contentStream.setFont(b, 15);
				contentStream.setNonStrokingColor(Color.black);
				contentStream.newLineAtOffset(140, y1);
				contentStream.showText(this.lvsp.vsp.cmb_meses.getSelectedItem().toString());
				contentStream.endText();
				y1-=30;
				contentStream.beginText();
				contentStream.setFont(a, 15);
				contentStream.setNonStrokingColor(morado_o);
				contentStream.newLineAtOffset(10, y1);
				contentStream.showText("Valor/mes: ");
				contentStream.endText();
				contentStream.beginText();
				contentStream.setFont(b, 15);
				contentStream.setNonStrokingColor(Color.black);
				contentStream.newLineAtOffset(140, y1);
				contentStream.showText("$"+ this.lvsp.vsp.txt_valorDiferido.getText());
				contentStream.endText();
			}
			
			 try {
	                File file = new File(image);
	                PDImageXObject image = PDImageXObject.createFromFileByContent(file, document);

	                float x = 5; // Posición horizontal de la imagen
	                float y = 750; // Posición vertical de la imagen
	                float width = image.getWidth(); // Ancho de la imagen
	                float height = image.getHeight(); // Alto de la imagen

	                contentStream.drawImage(image, x, y, width, height);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
			contentStream.close();
			document.save(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		crear();
	}

}

