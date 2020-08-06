package web_scraping;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebElement;

public class Excel {

		public static void Excel2( List <WebElement> descricao,  List <WebElement> Valor) {
			
			Workbook workbook = new HSSFWorkbook();
			
			
			Sheet sheet = workbook.createSheet("Product and prices");
			
		
			int i = 0;
			for(	WebElement x	: descricao	) {
				
				Cell cell2 = sheet.createRow(i).createCell(0);
				cell2.setCellValue(x.getText());
				sheet.autoSizeColumn(0);
				i++;
				
			}
			
			/*Thhere is a lot of products that is actually without pricetag... 
			 * 
			 * */
			
			int a = 0;
			for(	WebElement y	: Valor	) {
				Cell cell3 = sheet.getRow(a).createCell(1); 
				cell3.setCellValue(y.getText());
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