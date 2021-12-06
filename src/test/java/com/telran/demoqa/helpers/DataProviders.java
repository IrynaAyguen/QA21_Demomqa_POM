package com.telran.demoqa.helpers;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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


//        list.add(new Object[]{"Iryna2", "Irynova2", "iryna2@web.de", "2123456789", "Female", "02 May 1972"
//                , "English", "Sports", "C:/Tools/foto_lebenslauf.jpg"
////                , "Tortuga", "NRC", "Noida"
//               });

        return list.iterator();
    }

}
