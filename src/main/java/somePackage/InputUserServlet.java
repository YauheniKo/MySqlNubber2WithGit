package somePackage;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InputUserServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest" +
            "?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");


        Controller con1 = new Controller();
        con1.doAction("INPUT, " + login + ", " + password );
        String res1 = con1.doAction("INPUT, " + login + ", " + password );

        if (res1.equalsIgnoreCase("Ошибка")|res1.equalsIgnoreCase(null)) {
            response.sendRedirect("http://localhost:8080/error-page");
        }
    }
}
