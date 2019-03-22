<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
  function redirection(index, letter) {
    location.href='index.html';
   // location.href="patientList.jsp?index=0&letter=" + letter;
   // "location.href = 'patientList.jsp?index=0&letter='"
  }
</script>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Patients:</h2>
  <input type="radio" name="letter" onclick= "location.href = 'patientList.jsp?index=0&letter=null'" value = "all" > All
  <%      int index;
          String letter = request.getParameter("letter");%>
  <% for (char i = 'A'; i <= 'Z'; i++)
  {
  %>
  <input type="radio" name="letter" onclick= "location.href = 'patientList.jsp?index=0&letter=<%=i%>'" value = <%="" + i%> > <%=i%>
  <%}%>
  <ul>
    <%
      Map<String, String> patients = (LinkedHashMap<String, String>) session.getAttribute("patientNames");
      Iterator it = patients.entrySet().iterator();
      ArrayList<Map<String, String>> pages = new ArrayList<>();
      Map<String, String> temp = new LinkedHashMap<>();
      if(request.getParameter("index") == null)
      {
        index = 0;
      }
      else
      {
        index = Integer.parseInt(request.getParameter("index"));
      //  System.out.println(index);
      }
      for (int i = 0; i < patients.size(); i++)
      {
          if (temp.size() == 20)
          {
            pages.add(new HashMap<>(temp));
            temp.clear();
          }
          Map.Entry pair = (Map.Entry) it.next();
          String fn = (String) pair.getKey();
          if (letter == null || letter.equals("null") || fn.charAt(0) == letter.charAt(0))
          {
            temp.put((String)pair.getKey(), (String)pair.getValue());
       //     System.out.println(fn.charAt(0)+" "+letter);
          }
      }
      pages.add(temp);
      System.out.println(pages.size() - 1);
      for (String first : pages.get(index).keySet())
      {
    %>
    <li><a href="patientsInfo.jsp?firstName=<%=first%>&lastName=<%=patients.get(first)%>"><%=first + "  " + patients.get(first)%></a>
    </li>
    <% } %>
  </ul>
</div>

  <%if (index == 0 && pages.size() - 1 == 0)
  { %>
  Prev page
  Next page
  <%}
  else if (index == 0 && pages.size() - 1 != 0)
  { %>
  Prev page
  <a href="patientList.jsp?index=<%=index + 1%>&letter=<%=letter%>">Next page</a>
  <%}
  else if (index == pages.size() - 1)
  { %>
  <a href="patientList.jsp?index=<%=index - 1%>&letter=<%=letter%>">Prev page</a>
  Next page
  <%}
  else
  {%>
  <a href="patientList.jsp?index=<%=index - 1%>&letter=<%=letter%>">Prev page</a>
  <a href="patientList.jsp?index=<%=index + 1%>&letter=<%=letter%>">Next page</a>
 <%}%>
<jsp:include page="/footer.jsp"/>
</body>
</html>
