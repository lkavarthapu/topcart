package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//DataProviders 1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\Opencart_LoginData.xlsx";  // taking xls data from testData
		ExcelUtility xlutil = new ExcelUtility(path); //creating a object for xlutility
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1",1);
		String logindata[][]= new String[totalrows][totalcols] ;//returning two dimentional array
		for (int i=1; i<= totalrows; i++)
		{
			for(int j=0; j< totalcols; j++)// read data from xl storing in 2 dimentiional array
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);// i for row j for colls
			}
		}
		return logindata;//returning 2 dimentional array
	}
  //Dataprovider 2
	//Dataprovider 3
}
