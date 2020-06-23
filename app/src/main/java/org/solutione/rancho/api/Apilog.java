package org.solutione.rancho.api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Apilog {
    int differenceDate(String date1, String date2 ) {
        int difference=0;

        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyy");

        try {
            Date star_date=dateFormat.parse(date1);
            Date end_date=dateFormat.parse(date2);

            difference=(int)((end_date.getTime()-star_date.getTime())/86400000);

        } catch (Exception e) {

        }

        return difference;
    }

}