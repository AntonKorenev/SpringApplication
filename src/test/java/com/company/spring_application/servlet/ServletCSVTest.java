package com.company.spring_application.servlet;


import com.company.spring_application.mapper.MapperFromCSV;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath:web.xml")
@ContextConfiguration("classpath:spring_config.xml")
public class ServletCSVTest extends Mockito {
    @Autowired
    WebApplicationContext context;
    ServletCSV servletCSV;

    @Before
    public void init() {
        servletCSV = new ServletCSV();
    }

    @Test
    public void postReturnNotEmpty() throws Exception {
        HttpServletRequest httpRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpResponse = mock(HttpServletResponse.class);

        String s= "1,Anton,Korenev,buy\n1,1000,tv\n2,200,monitor";
        // convert String into InputStream
        InputStream is = new ByteArrayInputStream(s.getBytes());

        // read it with BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        File tmp = File.createTempFile("temp-file-name", ".tmp");
        PrintWriter pr = new PrintWriter(tmp);

        when(httpRequest.getReader()).thenReturn(br);
        when(httpResponse.getWriter()).thenReturn(pr);

        servletCSV.mapperFromCSV = (MapperFromCSV) context.getBean("mapperFromCSV");
        servletCSV.doPost(httpRequest,httpResponse);

        verify(httpRequest,atLeast(1)).getReader();
    }
}