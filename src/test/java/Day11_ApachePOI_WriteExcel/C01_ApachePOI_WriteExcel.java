package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.BaseTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_ApachePOI_WriteExcel {

    /*

    Store the path of the file as string and open the file.
    Open the workbook.
    Open the first worksheet.
    Go to the first row.
    Create a cell on the 3rd column (2nd index) on the first row.
    Write “POPULATION” on that cell.
    Create a cell on the 2nd row 3rd cell(index2), and write data.
    Create a cell on the 3rd row 3rd cell(index2), and write data.
    Create a cell on the 4th row 3rd cell(index2), and write data.
    Write and save the workbook.
    Close the file.
    Close the workbook.
    */

    public static class C01_WriteExcelExample extends BaseTest {

        @Test
        public void writeExcel() throws IOException {

            // dosyamızın pathini alıyoruz.
            String path= "src/test/java/resources/excelfile.xlsx";

            // dosyamızı seçiyoruz.
            FileInputStream fis=new FileInputStream(path);

            // dosyamazı bir worbook haline getiriyoruz
            Workbook workbook = WorkbookFactory.create(fis);
            // sheet imizi oluşturduk.
            Sheet sheet2  = workbook.getSheetAt(1);

            // ilk satırımıza gittik
            Row row1= sheet2.getRow(0);

            //ilk satırımızın 3. hücresini oluşturduk.
            Cell row1Cell3 =row1.createCell(2);

            // hücremize değer ataması yaptık
            row1Cell3.setCellValue("PAPULATION");

            // mehdot chain ile data ekleme/değiştirme methodu
            sheet2.getRow(1).createCell(2).setCellValue("Rusyanın popilasyonu");

            sheet2.getRow(2).createCell(2).setCellValue("Cin in popilasyonu");
            sheet2.getRow(3).createCell(2).setCellValue("ABD nin popilasyonu");


            // Excell dosyamıza yazma işlemini yapıyoruz.
            FileOutputStream fos= new FileOutputStream(path);

            workbook.write(fos);
// dosyaları kapattık
            fis.close();
            fos.close();
// workbook kapattık.
        workbook.close();



        }

    }
}
