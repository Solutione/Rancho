package org.solutione.rancho.api;

public class Apilog {

    int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int differenceDate(String date1, String date2) {
        int difference = 0;
        int startD, startM, startY;
        int endD, endM, endY;

        String[] dateStart = date1.split("/");
        startD = Integer.parseInt(dateStart[0]);
        startM = Integer.parseInt(dateStart[1]);
        startY = Integer.parseInt(dateStart[2]);

        String[] dateEnd = date2.split("/");
        endD = Integer.parseInt(dateEnd[0]);
        endM = Integer.parseInt(dateEnd[1]);
        endY = Integer.parseInt(dateEnd[2]);

        difference = countDays(startM - 1, endM - 1, startY, endY) + (endD - startD);

        return difference;
    }

    int countDays(int month1, int month2, int year1, int year2) {
        int days = 0;
        if (year1 == year2) {
            if (leap_year(year1)) {
                months[1] = 29;
            } else {
                months[1] = 28;
            }
            for (int i = month1; i < month2; i++) {
                days += months[i];
                System.out.println(days);
            }

        } else {
            int aux = 0;
            for (int i = year1; i <= year2; i++) {
            
                if (leap_year(i)) {
                    months[1] = 29;
                } else {
                    months[1] = 28;
                }

                if (i == year2) {
                    for (int j = 0; j < month2; j++) {
                        days += months[j];
                        
                    }
                } else {
                    if (aux == 0) {
                        for (int j = month1; j < 12; j++) {
                            days += months[j];
                            
                        }
                    }else{
                        for (int j = 0; j < 12; j++) {
                            days += months[j];
                            
                        }
                    }

                    aux++;
                }

            }
        }
        return days;
    }

    boolean leap_year(int year) {
        boolean status = false;
        float aux = (float) year / 4;
        if (aux % 1 == 0) {
            status = true;
        }
        return status;
    }
}
