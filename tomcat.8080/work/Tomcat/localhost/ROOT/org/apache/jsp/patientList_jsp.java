/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.14
 * Generated at: 2019-03-22 05:37:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class patientList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("  function redirection(index, letter) {\n");
      out.write("    location.href='index.html';\n");
      out.write("   // location.href=\"patientList.jsp?index=0&letter=\" + letter;\n");
      out.write("   // \"location.href = 'patientList.jsp?index=0&letter='\"\n");
      out.write("  }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/meta.jsp", out, false);
      out.write("\n");
      out.write("  <title>Patient Data App</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/header.jsp", out, false);
      out.write("\n");
      out.write("<div class=\"main\">\n");
      out.write("  <h2>Patients:</h2>\n");
      out.write("  <input type=\"radio\" name=\"letter\" onclick= \"location.href = 'patientList.jsp?index=0&letter=null'\" value = \"all\" > All\n");
      out.write("  ");
      int index;
          String letter = request.getParameter("letter");
      out.write('\n');
      out.write(' ');
      out.write(' ');
 for (char i = 'A'; i <= 'Z'; i++)
  {
  
      out.write("\n");
      out.write("  <input type=\"radio\" name=\"letter\" onclick= \"location.href = 'patientList.jsp?index=0&letter=");
      out.print(i);
      out.write("'\" value = ");
      out.print("" + i);
      out.write(' ');
      out.write('>');
      out.write(' ');
      out.print(i);
      out.write('\n');
      out.write(' ');
      out.write(' ');
}
      out.write("\n");
      out.write("  <ul>\n");
      out.write("    ");

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
    
      out.write("\n");
      out.write("    <li><a href=\"patientsInfo.jsp?firstName=");
      out.print(first);
      out.write("&lastName=");
      out.print(patients.get(first));
      out.write('"');
      out.write('>');
      out.print(first + "  " + patients.get(first));
      out.write("</a>\n");
      out.write("    </li>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("  </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("  ");
if (index == 0 && pages.size() - 1 == 0)
  { 
      out.write("\n");
      out.write("  Prev page\n");
      out.write("  Next page\n");
      out.write("  ");
}
  else if (index == 0 && pages.size() - 1 != 0)
  { 
      out.write("\n");
      out.write("  Prev page\n");
      out.write("  <a href=\"patientList.jsp?index=");
      out.print(index + 1);
      out.write("&letter=");
      out.print(letter);
      out.write("\">Next page</a>\n");
      out.write("  ");
}
  else if (index == pages.size() - 1)
  { 
      out.write("\n");
      out.write("  <a href=\"patientList.jsp?index=");
      out.print(index - 1);
      out.write("&letter=");
      out.print(letter);
      out.write("\">Prev page</a>\n");
      out.write("  Next page\n");
      out.write("  ");
}
  else
  {
      out.write("\n");
      out.write("  <a href=\"patientList.jsp?index=");
      out.print(index - 1);
      out.write("&letter=");
      out.print(letter);
      out.write("\">Prev page</a>\n");
      out.write("  <a href=\"patientList.jsp?index=");
      out.print(index + 1);
      out.write("&letter=");
      out.print(letter);
      out.write("\">Next page</a>\n");
      out.write(" ");
}
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}