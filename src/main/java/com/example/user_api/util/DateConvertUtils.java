package com.example.user_api.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertUtils {
        public static Date convertDate(String dateStr){
            Date date = null;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date =dateFormat.parse(dateStr);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return date;
        }

        public static String convertStr(Date date){
            String strFormat;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            strFormat = formatter.format(date);
            return strFormat;
        }
}
