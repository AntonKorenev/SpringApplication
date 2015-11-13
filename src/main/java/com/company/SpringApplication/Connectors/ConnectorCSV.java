package com.company.SpringApplication.Connectors;

import com.company.SpringApplication.Processors.Processor;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>The ConnectorCSV class is responsible for getting date from service in CSV format
 * and then sending it to {@link Processor} for further processing.</p>
 *
 * @author AntonKorenev
 * @version 0.1
 */
public class ConnectorCSV {
    private Processor processor;

    public ConnectorCSV(Processor processor){
        this.processor = processor;
    }

    //now it's just creating a new temporary file. It will be replaced by Servlet request soon. Planning to make a
    // property in a bean which will post a file from servlet to increase a level of beans self-independence.
    private File getFileFromService() throws NullPointerException{
        File csvFile = null;

        //creating string to write into file
        String[][] dataArray = {
                {"Erick", "Amsterdam", "sailor"},
                {"Sarah","Chicago","driver"},
                {"Judie","Winnipeg","manager"}
        };
        StringBuilder fileContentBuilder = new StringBuilder();
        for(String[] line: dataArray){
            for (int p=0; p<line.length-1; p++ ){
                fileContentBuilder.append(line[p]).append(',');
            }
            fileContentBuilder.append('\n');
        }

        //creating temp file and writing formed string to it
        try {
            csvFile = File.createTempFile("data", ".csv");
            PrintWriter csvFileWriter = new PrintWriter(csvFile.getAbsolutePath());
            csvFileWriter.print(fileContentBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvFile;
    }

    public void sendNewFileForProcessing(){
        //not sure how is this code block correlated with Spring app logic(Specifically, putting createFile() to
        // process(File f)).
        try {
            processor.proccess(getFileFromService());
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }
}