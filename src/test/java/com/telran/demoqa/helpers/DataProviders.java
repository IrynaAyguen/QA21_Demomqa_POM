package com.telran.demoqa.helpers;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> StudentRegistrationForm() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Iryna", "Irynova", "iryna@web.de", "0123456789", "Female", "01 May 1972"
                , "Maths", "Music", "C:/Tools/foto_lebenslauf.jpg"
//                , "Tortuga", "NRC", "Noida"
                });


        list.add(new Object[]{"Iryna2", "Irynova2", "iryna2@web.de", "2123456789", "Female", "02 May 1972"
                , "English", "Sports", "C:/Tools/foto_lebenslauf.jpg"
//                , "Tortuga", "NRC", "Noida"
               });

        return list.iterator();
    }



    @DataProvider
    public static Iterator<Object[]> UsingFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/students.csv")));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(","));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
}


