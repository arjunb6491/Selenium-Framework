package com.hms.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/** this method is uesd to get random number
	 * 
	 * 
	 * @return
	 */
	public int getRandomNo()
	{
		
		Random ran = new Random();
		int random = ran.nextInt(2000);
		return random;
	}
	public String getsystemDate()
	/**this method is used to get system Date
	 * 
	 */
	{
		Date d=new Date();
		String date = d.toString();
		return date;
    }
	public String getsystemformatDatedateformate()
	{
		/** This method is used get system date in formate
		 * 
		 */
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy hh-MM-SS");
		Date d=new Date();
		String SimpleDateFormat = dateformat.format(d);
		return SimpleDateFormat;
		}
	

}
