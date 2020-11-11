package somePackage;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/user-registration")
public class RegistrationUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("loginR");
        String password = request.getParameter("passwordR");
        //String role = request.getParameter("role");

        Controller con1 = new Controller();

        String res2 = con1.doAction("REGISTRATION, " + login + ", " + password + ", USER" );

        if (res2.equalsIgnoreCase("Ошибка")) {
            response.sendRedirect("http://localhost:8080/error-page");
        }
        else
            response.sendRedirect("http://localhost:8080/view-page");

        HttpSession session = request.getSession();
        // получаем объект name
        String name = (String) session.getAttribute("name");

        PrintWriter out = response.getWriter();
        try {
            // если объект ранее не установлен
            if(name == null) {
                // устанавливаем объект с ключом name
                session.setAttribute("name", "Tom Soyer");
                out.println("Session data are set");
            }
            else {
                out.println("Name: " + name);
                // удаляем объект с ключом name
                session.removeAttribute("name");
            }
        }
        finally {
            out.close();
        }





    }
}
