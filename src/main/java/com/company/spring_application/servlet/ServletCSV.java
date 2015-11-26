package com.company.spring_application.servlet;

import com.company.spring_application.mapper.MapperFromCSV;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletCSV extends HttpServlet{
    MapperFromCSV mapperFromCSV;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        this.mapperFromCSV = (MapperFromCSV) ctx.getBean("mapperFromCSV");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = req.getReader();
        String str;
        while( (str = br.readLine()) != null ){
            sb.append(str);
        }

        mapperFromCSV.sendForProcessing(sb.toString());

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(sb.toString());
    }
}
