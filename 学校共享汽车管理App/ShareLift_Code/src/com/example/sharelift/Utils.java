package com.example.sharelift;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static long dateToStamp(String s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long ts = date.getTime();
		return ts;
	}
	 
     
    public static String stampToDate(long l){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(l);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
