package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styles.css\"></link>\r\n");
      out.write("\t<script language=\"javascript\" type=\"text/javascript\" src=\"js/addProduct.js\"></script>\r\n");
      out.write("\t<script language=\"javascript\" type=\"text/javascript\" src=\"js/showAddForm.js\"></script>\r\n");
      out.write("\t<script language=\"javascript\" type=\"text/javascript\" src=\"js/closeAddForm.js\"></script>\r\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("        $(document).ready(function(){\r\n");
      out.write("            $(\"#submit_button\").click(function(){\r\n");
      out.write("                var firstName = $(\"#fname\").val();\r\n");
      out.write("        \t\tvar lastName = $(\"#lname\").val();\r\n");
      out.write("        \t\tvar taskDescription = $( \"#task_select option:selected\" ).text();\r\n");
      out.write("        \t\tvar positions = $('#product_table tr:has(td)').map(function(i, v) {\r\n");
      out.write("            \t\tvar $td =  $('td', this);\r\n");
      out.write("                \t\treturn {\r\n");
      out.write("                         \tid: ++i,\r\n");
      out.write("                         \tid: $td.eq(2).text(),\r\n");
      out.write("                         \tprice: $td.eq(1).text(),\r\n");
      out.write("                         \tname: $td.eq(0).text()\r\n");
      out.write("                       \t}\r\n");
      out.write("        \t\t}).get();\r\n");
      out.write("\r\n");
      out.write("        \t\tvar postData = {\r\n");
      out.write("        \t\t\tfirstName: firstName\r\n");
      out.write("        \t\t\t, lastName: lastName\r\n");
      out.write("        \t\t\t, taskDescription: taskDescription\r\n");
      out.write("        \t\t\t, products: positions\r\n");
      out.write("        \t\t}\r\n");
      out.write("\r\n");
      out.write("        \t\t$.ajax({\r\n");
      out.write("                    url: 'ServletJSON'\r\n");
      out.write("                    , type: 'POST'\r\n");
      out.write("                    , data: JSON.stringify(postData)\r\n");
      out.write("                    , success: function(res) {\r\n");
      out.write("                        alert(res);\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t<h1>Check your order details</h1>\r\n");
      out.write("\t</header>\r\n");
      out.write("\r\n");
      out.write("\t<nav>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><a href=\"index.html\">Order</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t<section class=\"order_section\">\r\n");
      out.write("\t\t<h2>Details</h2>\r\n");
      out.write("\r\n");
      out.write("\t\t<article class=\"order_article\">\r\n");
      out.write("\t\t\t<h2>Order N:</h2>\r\n");
      out.write("\t\t\t<div name=\"order_form\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<p align=\"center\">\r\n");
      out.write("\t\t\t\t\t<table class=\"contact_table\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t<td class=\"contact_text\">First Name: </td>\r\n");
      out.write("                    \t\t<td class=\"contact_input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"contact_input_field\" type=\"text\" name=\"fname\" id=\"fname\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("                \t\t</tr>\r\n");
      out.write("                \t\t<tr>\r\n");
      out.write("                    \t\t<td class=\"contact_text\">Last Name: </td>\r\n");
      out.write("                    \t\t<td class=\"contact_input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"contact_input_field\" type=\"text\" name=\"lname\" id=\"lname\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("                \t\t</tr>\r\n");
      out.write("                \t\t<tr>\r\n");
      out.write("                    \t\t<td class=\"contact_text\">Action: </td>\r\n");
      out.write("                    \t\t<td class=\"contact_input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"task_select\" class=\"contact_input_field\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option>buy</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option>change</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option>service</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("                \t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"product_container\">\r\n");
      out.write("\t\t\t\t\t<table class=\"product_table\" id=\"product_table\">\r\n");
      out.write("\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr class=\"product_table_cell\">\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"product_table_cell\">Product</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"product_table_cell\">Price</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"product_table_cell\">Id</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t<tbody id=\"product_table_content\">\r\n");
      out.write("\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<p class=\"buttons_panel\">\r\n");
      out.write("\t\t\t\t\t\t<button onclick=\"showAddForm()\">Add</button>\r\n");
      out.write("\t\t\t\t\t\t<button id=\"submit_button\">Submit</button>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</article>\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"add pop-up content\" class=\"add_window\">\r\n");
      out.write("\t\t<div class=\"add_window_content\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"order_position_text\">Name: </td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"p_name\" id=\"p_name\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"order_position_text\">Price: </td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"p_price\" id=\"p_price\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"order_position_text\">Id: </td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"p_id\" id=\"p_id\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<button onclick=\"addProduct()\">Add</button>\r\n");
      out.write("       \t\t\t<button onclick=\"closeAddForm()\">Close</button>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<footer class=\"page_footer\">\r\n");
      out.write("\t\t<address>\r\n");
      out.write("\t\t\tWritten by Anton Korenev.<br>\r\n");
      out.write("\t\t\tanton.korenev@sigma.software<br>\r\n");
      out.write("\t\t\tKiev, Ukraine\r\n");
      out.write("\t\t</address>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
