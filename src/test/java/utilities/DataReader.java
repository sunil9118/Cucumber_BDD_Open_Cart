package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	public static List<HashMap<String, String>> data(String filePath, String sheetName) throws IOException

	{

		List<HashMap<String, String>> mydata = new ArrayList<>();

		try {
			FileInputStream fi = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fi);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			for (int r = 1; r < sheet.getPhysicalNumberOfRows(); r++) {
				Row currentRow = sheet.getRow(r);
				HashMap<String, String> currentHash = new HashMap<>();

				for (int c = 0; c < currentRow.getPhysicalNumberOfCells(); c++) {
					Cell currentCell = currentRow.getCell(c);

					switch (currentCell.getCellType()) {
					case STRING:
						currentHash.put(headerRow.getCell(c).getStringCellValue(), currentCell.getStringCellValue());
						break;

					}

				}
				mydata.add(currentHash);

			}
			workbook.close();
			fi.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mydata;

	}
}
