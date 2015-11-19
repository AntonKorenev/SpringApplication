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
        tester.addRequestParameter("fname", "Anton");
        tester.addRequestParameter("lname", "Korenev");
        tester.addRequestParameter("task", "buy");
        tester.addRequestParameter("orders", "1 1000 tv,2 200 monitor");

        // instantiate the servlet
        tester.createServlet(ServletCSV.class);

        tester.doPost();

        assertEquals(200, factory.getMockResponse().getStatusCode());
    }
}