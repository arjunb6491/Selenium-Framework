package com.hms.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/** this method is used to fetch the data from Property File
	 *@author shivamma A 
	 * @param Key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String Key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Ipathconstants.FilePath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(Key);
		return value;
	}
	

}
