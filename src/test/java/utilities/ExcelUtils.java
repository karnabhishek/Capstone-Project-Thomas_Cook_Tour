package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Utility class for handling Excel operations (Apache POI).
 */
public class ExcelUtils {

    private static Workbook workbook;

    /**
     * Loads the Excel file into memory.
     * 
     * @param filePath path to the Excel file (e.g. "src/test/resources/testData/RegistrationData.xlsx")
     * @throws IOException if file not found or cannot be read
     */
    public static void loadExcel(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
    }

    /**
     * Reads a single cell value as String.
     * 
     * @param sheetName name of the Excel sheet
     * @param rowIndex  row number (0-based)
     * @param colIndex  column number (0-based)
     * @return cell value as String
     */
    public static String readExcelData(String sheetName, int rowIndex, int colIndex) {
        if (workbook == null) {
            throw new RuntimeException("Excel file not loaded. Call loadExcel(filePath) first.");
        }

        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file.");
        }

        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            throw new RuntimeException("Row " + rowIndex + " not found in sheet " + sheetName);
        }

        Cell cell = row.getCell(colIndex);
        if (cell == null) {
            return ""; // return empty if cell is blank
        }

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell).trim();
    }

    /**
     * Closes the workbook to free resources.
     */
    public static void closeExcel() {
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
