package com.adi.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

 

public class JobServe {

	public static void main (String arg[])
	{
		
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://localhost/IACFeesCPI/");
		driver.findElement(By.xpath(".//*[@id='screening']/div[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='screening']/div[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='screening']/div[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='Content']/div/div/div[2]/div[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='qa_paper']")).click();
		driver.findElement(By.xpath(".//*[@id='qa_representative']")).click();
		driver.findElement(By.xpath(".//*[@id='s1_tod_2']")).click();
		driver.findElement(By.xpath(".//*[@id='Content']/div/div[2]/div/form/div/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='s1a']/span[2]/input")).sendKeys("Dave");
		driver.findElement(By.xpath(".//*[@id='s1b']/span[2]/input")).sendKeys("Turning");
		driver.findElement(By.xpath(".//*[@id='s1c']/span[2]/input")).sendKeys("Mr");
		
		driver.findElement(By.xpath(".//*[@id='s1d']/span[2]/select[1]")).sendKeys("01");
		driver.findElement(By.xpath(".//*[@id='s1d']/span[2]/select[2]")).sendKeys("11");
		driver.findElement(By.xpath(".//*[@id='s1d']/span[2]/select[3]")).sendKeys("1982");
		driver.findElement(By.xpath(".//*[@id='s1e']/span[2]/input[1]")).click();
		driver.findElement(By.xpath(".//*[@id='s1f']/span[4]/input")).sendKeys("123");
		driver.findElement(By.xpath(".//*[@id='s1f']/span[6]/input")).sendKeys("Turning Lane");
		driver.findElement(By.xpath(".//*[@id='s1f']/span[8]/input")).sendKeys("");
		driver.findElement(By.xpath(".//*[@id='s1f']/span[10]/select")).sendKeys("Armenia");
		driver.findElement(By.xpath(".//*[@id='s1f_pcode']")).sendKeys("E12 3RR");
		driver.findElement(By.xpath(".//*[@id='s1g']/span[2]/select")).sendKeys("Angolan");
		driver.findElement(By.xpath(".//*[@id='Content']/div/div[2]/div/form/div/div[2]/input")).click();
		
		
		//Page 3
		driver.findElement(By.xpath(".//*[@id='s2a']/span[2]/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='s2b']/span[2]/input")).sendKeys("12345");
		driver.findElement(By.xpath(".//*[@id='s2c']/span[2]/select[1]")).sendKeys("Accra");
		driver.findElement(By.xpath(".//*[@id='s2d']/span[2]/input[1]")).click();
		driver.findElement(By.xpath(".//*[@id='s2d']/span[4]/input")).sendKeys("Post Accra");
		driver.findElement(By.xpath(".//*[@id='s2e']/span[2]/select[1]")).sendKeys("01");
		driver.findElement(By.xpath(".//*[@id='s2e']/span[2]/select[2]")).sendKeys("11");
		driver.findElement(By.xpath(".//*[@id='s2e']/span[2]/select[3]")).sendKeys("2012");
		driver.findElement(By.xpath(".//*[@id='s2i']/span[2]/select[1]")).sendKeys("01");
		driver.findElement(By.xpath(".//*[@id='s2i']/span[2]/select[2]")).sendKeys("11");
		driver.findElement(By.xpath(".//*[@id='s2i']/span[2]/select[3]")).sendKeys("2012");
		driver.findElement(By.xpath(".//*[@id='Content']/div/div[2]/div/form/div/div[2]/input")).click();
		
		//Page4
		driver.findElement(By.xpath(".//*[@id='Content']/div/div[2]/div/form/div/div[2]/input")).click();
		
		//Page 5
		
		driver.findElement(By.xpath(".//*[@id='s3d_grounds']")).sendKeys("12345");
		driver.findElement(By.xpath(".//*[@id='s3e_no']")).click();
		driver.findElement(By.xpath(".//*[@id='s3f_no']")).click();
		driver.findElement(By.xpath(".//*[@id='Content']/div/div[2]/div/form/div/div[2]/input")).click();
		//page 6
		 driver.findElement(By.xpath(".//*[@id='rep_yes']")).click();
		 driver.findElement(By.xpath(".//*[@id='spo_no']")).click();
		 driver.findElement(By.xpath(" .//*[@id='s4_decalaration']")).click();
		 driver.findElement(By.xpath(".//*[@id='Content']/div/div[2]/div/form/div/div[2]/input")).click();
		 //page7
		 driver.findElement(By.xpath(".//*[@id='s5a']/span[2]/input")).sendKeys("Dave");
			//driver.findElement(By.xpath(".//*[@id='s1b']/span[2]/input")).sendKeys("Turning");
			//driver.findElement(By.xpath(".//*[@id='s1c']/span[2]/input")).sendKeys("Mr");
			
			driver.findElement(By.xpath(".//*[@id='s5b']/span[2]/select[1]")).sendKeys("Other");
			driver.findElement(By.xpath(".//*[@id='s5l']")).sendKeys("Other rep");
	
			driver.findElement(By.xpath(".//*[@id='s5c']/span[4]/input")).sendKeys("123");
			driver.findElement(By.xpath(".//*[@id='s5c']/span[6]/input")).sendKeys("Turning Lane");
			driver.findElement(By.xpath(".//*[@id='s5c']/span[8]/input")).sendKeys("");
			driver.findElement(By.xpath(".//*[@id='s5c']/span[10]/select")).sendKeys("Armenia");
			driver.findElement(By.xpath(".//*[@id='s5c']/span[12]/input")).sendKeys("E12 3RR");
			driver.findElement(By.xpath(".//*[@id='s5d']/span[2]/input")).sendKeys("s5d");
			driver.findElement(By.xpath(".//*[@id='s5e']/span[2]/input")).sendKeys("020 33346974");
			driver.findElement(By.xpath(".//*[@id='s5f']/span[2]/input")).sendKeys("020 33346974");
			driver.findElement(By.xpath(".//*[@id='s5g']/span[2]/input")).sendKeys("test@test.com.david");
			driver.findElement(By.xpath(".//*[@id='s5h']/span[2]/input")).sendKeys("s5h");
			driver.findElement(By.xpath(".//*[@id='s5i']/span[2]/select")).sendKeys("England and Wales");
			 driver.findElement(By.xpath(" .//*[@id='s4_decalaration']")).click();
			driver.findElement(By.xpath(".//*[@id='Content']/div/div[2]/div/form/div/div[2]/input")).click();
			
		 
		
		 /*ExcelSheetReader reader  = new ExcelSheetReader("C:\\Data.xls");
			
		String selection="";
		selection = reader.GetData("Int",0,1);
		
		String xpath_start=".//*[@id='ddcl-selInd-ddw']/div/div[";
		String xpath_end="]/label";
		
		logger.info(selection);
		
		driver.findElement(By.xpath(xpath_start+"10"+xpath_end)).click();
		selection = reader.GetData("String",1,1);
		driver.findElement(By.xpath(".//*[@id='txtKey']")).sendKeys("Java Developer");
		selection = reader.GetData("String",2,1);
		driver.findElement(By.xpath(".//*[@id='selJType']")).sendKeys("CONTRACT");

		driver.findElement(By.xpath(".//*[@id='btnSearch']")).click();
		*/
		
		
	}
}






