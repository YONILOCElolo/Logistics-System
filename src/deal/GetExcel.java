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
		// 获得工作簿对象
		XSSFWorkbook workbook = new XSSFWorkbook(xlsFile);

		XSSFSheet sheet = workbook.getSheetAt(0);

		// 0表示第一个sheet,1表示第二个sheet
		/*
		 * 这里我将数据复制到第二个sheet,方便操作
		 */
		// 获得行数
	    int cols = sheet.getPhysicalNumberOfRows();
		// 获得列数
		int rows = sheet.getLastRowNum();
//		
//		System.out.println("rows：" + rows);
//		System.out.println("cols：" + cols);

		minPath1 = new double[cols - 2][rows - 1];// 初始化一个9*9数组，去掉表头，看表就知道了
		for (int row = 2; row <= rows; ++row) {

			XSSFRow r = sheet.getRow(row);
			// 遍历列
			int heng = r.getPhysicalNumberOfCells();

			for (int col = 1; col < r.getPhysicalNumberOfCells(); col++) {// col为横坐标

				XSSFCell cell = r.getCell(col);
				cell.setCellType(cell.CELL_TYPE_STRING);
				String cellValue = cell.getStringCellValue();
//				System.out.print(cellValue + "\t");
				minPath1[row-2][col-1] = Float.parseFloat(cellValue);

			}
//			System.out.println();
		}
		//看看数组的值
//		System.out.println("看看数组");
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