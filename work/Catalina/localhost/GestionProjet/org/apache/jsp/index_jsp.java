/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.99
 * Generated at: 2025-03-24 13:06:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Les JSPs ne permettent que GET, POST ou HEAD. Jasper permet aussi OPTIONS");
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"fr\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>GestionProjet</title>\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <style>\r\n");
      out.write("        /* Importer la police */\r\n");
      out.write("        @import url('https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Roboto:wght@400;700&display=swap');\r\n");
      out.write("\r\n");
      out.write("        /* Style général */\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: 'Roboto', sans-serif;\r\n");
      out.write("            background: url('https://images.pexels.com/photos/585418/pexels-photo-585418.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1') no-repeat center center fixed;\r\n");
      out.write("            background-size: cover;\r\n");
      out.write("            height: 100vh;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Barre de navigation */\r\n");
      out.write("        .navbar {\r\n");
      out.write("            background: rgba(255, 255, 255, 0.42);\r\n");
      out.write("            backdrop-filter: blur(10px);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar-brand {\r\n");
      out.write("            font-family: 'Roboto', serif;\r\n");
      out.write("            font-size: 24px;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            color: black !important;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar-nav .nav-link {\r\n");
      out.write("\r\n");
      out.write("            color: black !important;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Conteneur principal */\r\n");
      out.write("        .container-box {\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            top: 50%;\r\n");
      out.write("            left: 10%;\r\n");
      out.write("            transform: translateY(-50%);\r\n");
      out.write("            background: white;\r\n");
      out.write("            padding: 40px;\r\n");
      out.write("            border-radius: 50px;\r\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);\r\n");
      out.write("            width: 400px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .btn-primary {\r\n");
      out.write("            background-color: black;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 20px;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .btn-primary:hover {\r\n");
      out.write("            background-color: gray;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Masquer toutes les sections sauf l'accueil */\r\n");
      out.write("        .section {\r\n");
      out.write("            display: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Afficher uniquement la section active */\r\n");
      out.write("        .section.active {\r\n");
      out.write("            display: block;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- Barre de navigation -->\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <img style=\"width: 70px; height: 70px;\" src=\"img.png\">\r\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\" onclick=\"showSection('home')\">ConstructionXpert</a>\r\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\">\r\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"collapse navbar-collapse justify-content-end\" id=\"navbarNav\">\r\n");
      out.write("            <ul class=\"navbar-nav\">\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"btn btn-outline-dark me-2\" href=\"#\">ACCUEIL</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"btn btn-outline-dark me-2\" href=\"#\">INSCRIRE</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"btn btn-outline-dark\" href=\"#\">CONNEXION</a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<!-- Accueil -->\r\n");
      out.write("<div id=\"home\" class=\"container-box section active\">\r\n");
      out.write("    <h2>Bienvenue sur GestionProjet</h2>\r\n");
      out.write("    <p>Optimisez la gestion de vos projets facilement.</p>\r\n");
      out.write("    <button class=\"btn btn-primary\" onclick=\"showSection('inscription')\">Commencer</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Inscription -->\r\n");
      out.write("<div id=\"inscription\" class=\"container-box section\">\r\n");
      out.write("    <h2>INSCRIPTION</h2>\r\n");
      out.write("    <form action=\"InscriptionServlet\" method=\"post\">\r\n");
      out.write("        <div class=\"mb-3\">\r\n");
      out.write("            <label for=\"nom\" class=\"form-label\">NOM</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"nom\" name=\"nom\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"mb-3\">\r\n");
      out.write("            <label for=\"email\" class=\"form-label\">EMAIL</label>\r\n");
      out.write("            <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"mb-3\">\r\n");
      out.write("            <label for=\"password\" class=\"form-label\">MOT DE PASSE</label>\r\n");
      out.write("            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-primary w-100\">S'inscrire</button>\r\n");
      out.write("    </form>\r\n");
      out.write("    <p class=\"mt-3\">Déjà inscrit ? <a href=\"#\" onclick=\"showSection('connexion')\">Se connecter</a></p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Connexion -->\r\n");
      out.write("<div id=\"connexion\" class=\"container-box section\">\r\n");
      out.write("    <h2>CONNEXION</h2>\r\n");
      out.write("    <form action=\"Projet.jsp\" method=\"post\">\r\n");
      out.write("        <div class=\"mb-3\">\r\n");
      out.write("            <label for=\"emailLogin\" class=\"form-label\">EMAIL</label>\r\n");
      out.write("            <input type=\"email\" class=\"form-control\" id=\"emailLogin\" name=\"email\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"mb-3\">\r\n");
      out.write("            <label for=\"passwordLogin\" class=\"form-label\">MOT DE PASSE</label>\r\n");
      out.write("            <input type=\"password\" class=\"form-control\" id=\"passwordLogin\" name=\"password\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-primary w-100\">Se connecter</button>\r\n");
      out.write("    </form>\r\n");
      out.write("    <p class=\"mt-3\">Pas encore de compte ? <a href=\"#\" onclick=\"showSection('inscription')\">S'inscrire</a></p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function showSection(sectionId) {\r\n");
      out.write("        document.querySelectorAll('.section').forEach(section => {\r\n");
      out.write("            section.classList.remove('active');\r\n");
      out.write("        });\r\n");
      out.write("        document.getElementById(sectionId).classList.add('active');\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
