package com.company.spring_application.servlet;

import com.mockrunner.mock.web.WebMockObjectFactory;
import com.mockrunner.servlet.ServletTestModule;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ServletCSVTest {
    private ServletTestModule tester;
    private WebMockObjectFactory factory;


    @Before
    public void init() {
        factory = new WebMockObjectFactory();
        tester = new ServletTestModule(factory);
    }

    @Test
    public void postReturnNotEmpty() throws Exception {
        int expectedCode = 1;

        tester.addRequestParameter("fname", "Anton");
        tester.addRequestParameter("lname", "Korenev");
        tester.addRequestParameter("position", "tv");
        tester.addRequestParameter("task", "buy");

        // instantiate the servlet
        tester.createServlet(ServletCSV.class);

        tester.doPost();

        // assertion: status code should be 1
        assertEquals(expectedCode, factory.getMockResponse().getStatusCode());
    }

    @Test
    public void postReturnEmpty() throws Exception {
        int expectedCode = 0;

        tester.addRequestParameter("fname", "");
        tester.addRequestParameter("lname", "Korenev");
        tester.addRequestParameter("position", "tv");
        tester.addRequestParameter("task", "buy");

        // instantiate the servlet
        tester.createServlet(ServletCSV.class);

        tester.doPost();

        // assertion: status code should be 0
        assertEquals(expectedCode, factory.getMockResponse().getStatusCode());
    }
}