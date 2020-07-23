package web_scraping;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Excel {

		public static void Excel2( Elements descricao,  Elements Valor) {
			
			Workbook workbook = new HSSFWorkbook();
			
			
			Sheet sheet = workbook.createSheet("Product");
			Sheet sheet2 = workbook.createSheet("Prices");
		
			int i = 0;
			for(	Element x	: descricao	) {
				
				Cell cell2 = sheet.createRow(i).createCell(0);
				cell2.setCellValue(x.getElementsByTag("a").first().text());
				sheet.autoSizeColumn(0);
				i++;
				
			}
			
			int a = 0;
			for(	Element y	: Valor	) {
				Cell cell3 = sheet2.createRow(a).createCell(0); 
				cell3.setCellValue(y.getElementsByTag("span").first().text());
				sheet.autoSizeColumn(0);
				a++;
			}
			
			
			
			try {
				FileOutputStream output = new FileOutputStream("Resultados de Pesquisa.xls");
				workbook.write(output);
				output.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
	
}
