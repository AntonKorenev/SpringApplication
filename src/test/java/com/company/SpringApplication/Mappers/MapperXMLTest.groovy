package com.company.SpringApplication.Mappers

import org.junit.Test
import java.lang.reflect.InvocationTargetException
import static org.junit.Assert.assertTrue;

class MapperXMLTest {
    @Test
    void conversionOfFileToXMLWasSuccessful() {
        try {
            File csvFile = File.createTempFile("d", ".csv");
            String content="a,b,c\n1,2,3\n4,5,6\n";
            PrintWriter pw = new PrintWriter(csvFile);
            pw.write(content);
            pw.close();

            File convertedFile = MapperXML.convert(csvFile,"user","table");
            BufferedReader br = new BufferedReader(new FileReader(convertedFile));
            assertTrue(br.readLine().contains("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"))
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
