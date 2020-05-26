package deal;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jdk.internal.dynalink.beans.StaticClass;

public class GetExcel {
	public static double[][] minPath1;
	public static  int getData(String a) throws IOException {
		InputStream xlsFile = new FileInputStream(a);
		// ��ù���������
		XSSFWorkbook workbook = new XSSFWorkbook(xlsFile);

		XSSFSheet sheet = workbook.getSheetAt(0);

		// 0��ʾ��һ��sheet,1��ʾ�ڶ���sheet
		/*
		 * �����ҽ����ݸ��Ƶ��ڶ���sheet,�������
		 */
		// �������
	    int cols = sheet.getPhysicalNumberOfRows();
		// �������
		int rows = sheet.getLastRowNum();
//		
//		System.out.println("rows��" + rows);
//		System.out.println("cols��" + cols);

		minPath1 = new double[cols - 2][rows - 1];// ��ʼ��һ��9*9���飬ȥ����ͷ�������֪����
		for (int row = 2; row <= rows; ++row) {

			XSSFRow r = sheet.getRow(row);
			// ������
			int heng = r.getPhysicalNumberOfCells();

			for (int col = 1; col < r.getPhysicalNumberOfCells(); col++) {// colΪ������

				XSSFCell cell = r.getCell(col);
				cell.setCellType(cell.CELL_TYPE_STRING);
				String cellValue = cell.getStringCellValue();
//				System.out.print(cellValue + "\t");
				minPath1[row-2][col-1] = Float.parseFloat(cellValue);

			}
//			System.out.println();
		}
		//���������ֵ
//		System.out.println("��������");
//		for (int i = 0; i <rows-1; i++) {
//			for (int j = 0; j < cols-2; j++) {
//				System.out.print(distanceData[i][j]+"\t");
////				 = Float.parseFloat(cellValue);
//			}
//			System.out.println();
//		}
		
		return 1;
	}
}