package com.packageForEnum;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packageForEnum.common.Month;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vijee on 7/25/17.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println( "Please enter a month (Example: January)" );

        Scanner scanner = new Scanner( System.in );
        String userEnteredMonth = scanner.nextLine();
        userEnteredMonth = userEnteredMonth.toUpperCase();

        List<Month> userListOfMonths = new ArrayList<Month>();
        int indexMonth = 0 ;
        boolean flag = false;

        try{
            for(Month month: Month.values()) {
                if (month.toString().equals( userEnteredMonth )) {
                    flag = true;
                    indexMonth = month.ordinal(); // Get the index of the month entered by user
                }
            }

            for(int i= indexMonth; i<(Month.values().length); i++){ // Loop through and get the months from the one entered by the user till the end
                userListOfMonths.add(Month.values()[i]);
            }
            Month.setEnglishName( userListOfMonths.toString() );

        }catch(ArithmeticException e){
           e.printStackTrace();
        }

        System.out.println("--------------------------------------");
        System.out.println("User entered month:" + userEnteredMonth);
        System.out.println("--------------------------------------");


        if(flag) {
            System.out.println( "Output (Written to Json)" );
            System.out.println( Month.getEnglishName() );

            try{
                userEnteredMonth = userEnteredMonth.substring( 0,1 ) + userEnteredMonth.substring( 1 ).toLowerCase();
                File jsonFile = new File( "Month."+ userEnteredMonth +".json" );

                ObjectMapper objectmapper = new ObjectMapper(); // File written in JSON
                objectmapper.writeValue( jsonFile, Month.getEnglishName() );

            }catch(IOException e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Invalid input. Please enter a month (Example: January)");
        }
    }

}
