<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Patient Data App</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
   <%
       String firstName = request.getParameter("firstName");
       String lastName = request.getParameter("lastName");
       Model model = ModelFactory.getModel();
       String[] fields = model.getFields();
       String[] values = model.getProperty(firstName, lastName);
  %>
   <table style="width:50%">
       <tr>
           <th>Fields</th>
           <th>Values</th>
       </tr>
           <%
           for (int i = 0; i < fields.length - 1; i++)
           {
           %>
       <tr>
           <td width="70%"><%=fields[i]%></td>
           <td width="30%"><%=values[i]%></td>
           <%}%>
       </tr>
   </table>

</body>
</html>
