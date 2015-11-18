<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <body>
    <style>
       .parent {
        position: absolute;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        overflow: auto;
       }
       .form_style {
        position: absolute;
        background: #1E90FF;
        height: 150px;
        width: 280px;
        top: 50%;
        left: 50%;
        margin: -125px 0 0 -125px;
        align: center;
        transform: scale(2,2);
       }
       .text_style {
        position: relative;
        right: 2px;
        top: 2px;
        color: #FFFFFF;
       }
       .field_style {
        position: relative;
        width: 180px;
        left: 2px;
        top: 2px;
        text-align: center;
       }
       .ok_button_style {
        position: relative;
        bottom: 4px;
        left: 240px;
       }
    </style>
    <form name = "myForm" method="post" action="servletcsv">
        <div class="parent">
            <div class = "form_style">
              <p align="center">
              <table>
                <tr>
                    <td class="text_style">First Name: </td>
                    <td><input class="field_style" type="text" name="fname"></td>
                </tr>
                <tr>
                    <td class="text_style">Last Name: </td>
                    <td><input class="field_style" type="text" name="lname"></td>
                </tr>
                <tr>
                    <td class="text_style">Position: </td>
                    <td><input class="field_style" type="text" name="position"></td>
                </tr>
                <tr>
                    <td class="text_style">Task: </td>
                    <td><input class="field_style" type="text" name="task"></td>
                </tr>
              </table>
              </p>
              <p class="ok_button_style"><input type="submit" value="ok"></p>
            </div>
        </div>
    </form>
 </body>
</head>
</html>