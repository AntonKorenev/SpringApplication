package com.company.spring_application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        //System.out.println(Thread.currentThread().getContextClassLoader().getResourceAsStream("spring_config.xml"));
        try {
            //Объект для чтения файла в буфер
            StringBuilder sb = new StringBuilder();
            BufferedReader in = new BufferedReader(new FileReader( new File("src/main/resources/spring_config.xml").getAbsolutePath()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
                System.out.println(sb.toString());
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
