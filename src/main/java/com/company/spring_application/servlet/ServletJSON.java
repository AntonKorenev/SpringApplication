package com.company.spring_application.servlet;

import com.company.spring_application.connector.ConnectorJSON;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletJSON")
public class ServletJSON extends HttpServlet {
    ConnectorJSON connectorJSON;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("spring_config");
        this.connectorJSON = (ConnectorJSON) context.getBean("connectorJSON");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = req.getReader();
        String str;
        while( (str = br.readLine()) != null ){
            sb.append(str);
        }
        sb.insert(1,"\"id\":\"1\",");

        connectorJSON.sendForProcessing(sb.toString());

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(sb.toString());
    }
}
