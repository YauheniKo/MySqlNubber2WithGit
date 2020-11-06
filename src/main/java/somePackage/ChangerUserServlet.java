package somePackage;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangerUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String login = request.getParameter("loginC");
        String password = request.getParameter("passwordC");


        Controller con1 = new Controller();
        String result = con1.doAction("CHANGER_USER_PASS, " + login + ", " + password);

        if (result.equalsIgnoreCase("Ошибка")) {
            response.sendRedirect("http://localhost:8080/error-page");


        }

    }
}
