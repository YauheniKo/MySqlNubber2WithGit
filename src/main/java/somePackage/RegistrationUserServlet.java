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

        String role = request.getParameter("roleR");
        String login = request.getParameter("loginR");
        String password = request.getParameter("passwordR");


        Controller con1 = new Controller();

        String res2 = con1.doAction("REGISTRATION, " + login + ", " + password + ", "+role );

        if (res2.equalsIgnoreCase("Ошибка")) {
            response.sendRedirect("http://localhost:8080/error-page");
        }
        else
            response.sendRedirect("http://localhost:8080/view-page");


    }
}
