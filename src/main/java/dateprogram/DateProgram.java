package dateprogram;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class DateProgram {
    public static void main(String[] args) {

        LocalDate[] date = new LocalDate[args.length];
        LocalDate y;
        LocalDate now = LocalDate.now();
        int index = 0;

        if (args.length > 0) {
            for (String i : args) {
                boolean match = i.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
                if (match) {
                    y = LocalDate.parse(i);
                    date[index] = y;
                    index++;
                }
            }
            date = Arrays.copyOf(date, index);
        } else {
            System.err.println("Musisz podać jako argumenty uruchomieniowe daty w formacie yyyy-MM-dd" +
                    " przy następnym uruchomieniu programu.");
        }

        Arrays.sort(date);
        System.out.println("Najdawniejsza data to: " + date[0] + " a najpóźniejsza: " + date[date.length-1]);
        Period period = Period.between(now, date[0]);
        Period period2 = Period.between(now, date[date.length-1]);
        System.out.println();
        System.out.println("Od " + date[0] + " do teraz mineło " + period);
        System.out.println("Od " + date[date.length-1] + " do teraz mineło " + period2);

    }

    }






