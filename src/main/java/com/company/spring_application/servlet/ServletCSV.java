package com.company.spring_application.servlet;

import com.company.spring_application.connector.ConnectorCSV;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletcsv")
public class ServletCSV extends HttpServlet{
    ConnectorCSV connector;
    private static int id = 0;

    @Override
    public void init() throws ServletException {
        super.init();
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring_config.xml");
        connector = (ConnectorCSV) context.getBean("connectorCSV");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

        //getting values from web fields
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String position = req.getParameter("position");
        String task = req.getParameter("task");

        if(!firstName.isEmpty() && !lastName.isEmpty() && !position.isEmpty() && !task.isEmpty()){
            resp.setStatus(1);
        } else {
            resp.setStatus(0);
        }

        //creating csv string
        StringBuilder csvStringBuilder = new StringBuilder();
        csvStringBuilder.append(id).append(',').append(firstName).append(',').append(lastName).append(',')
                .append(position).append(',').append(task);
        //connector.sendForProcessing(csvStringBuilder.toString());
        id++;

        //writing successful response to web part
        printWriter.print("Order with parameters:\n\t id ="+id+"\n\t"+"First Name = "+firstName+"\n\tLast Name = "
                +lastName + "\n\t Position = "+position + "\n\t Task ="+task + "\n Was Succesfully created");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
