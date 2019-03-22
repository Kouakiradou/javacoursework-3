<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1>Search Result</h1>
  <%
    Map<String, String> patients = (Map<String, String>) request.getAttribute("result");
    if (patients.size() !=0)
    {
    %>
    <ul>
      <%
        for (String patient : patients.keySet())
        {
      %>
      <li><a href="patientsInfo.jsp?firstName=<%=patient%>&lastName=<%=patients.get(patient)%>"><%=patient + "  " + patients.get(patient)%></a></li>
     <% }
    } else
    {%>
      <p>Nothing found</p>
  <%}%>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>