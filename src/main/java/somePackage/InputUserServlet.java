package somePackage;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user-input")
public class InputUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Controller con1 = new Controller();
        con1.doAction("INPUT, " + login + ", " + password );
        String res1 = con1.doAction("INPUT, " + login + ", " + password );

        if (res1.equalsIgnoreCase("Ошибка")|res1.equalsIgnoreCase(null)) {
            response.sendRedirect("http://localhost:8080/error-page");
        }
        else
            response.sendRedirect("https://yandex.ru/drive");
    }
}
