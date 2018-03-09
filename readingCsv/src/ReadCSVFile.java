package com.vn;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSVFile {

    public static void main(String[] args){
        String COMMA_DELIMITER = ",";
        BufferedReader bufReader = null;
        try {
            bufReader = new BufferedReader(new FileReader("C:/Users/User/Documents/Tozsde/MT4ek/XM1/MQL4/Files/XM_19061180.csv"));
            String rowData = "";
            //bufReader.readLine();
            String[] dataByRow;
            while((rowData = bufReader.readLine()) != null){
                dataByRow = rowData.split(";");

                for(String s: dataByRow){
                    System.out.println(s);
                }
            }
        } catch (Exception e)
        {

        }
    }
}
