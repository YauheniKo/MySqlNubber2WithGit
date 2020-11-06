package somePackage;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user-delete")
public class DeleteUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String login = request.getParameter("loginD");
        String password = request.getParameter("passwordD");

        Controller con1 = new Controller();
        con1.doAction("DELETE_USER, " + login + ", " + password );
        String res1 = con1.doAction("DELETE_USER, " + login + ", " + password);

        if (res1.equalsIgnoreCase("Ошибка")) {
            response.sendRedirect("http://localhost:8080/error-page");
        }






    }

}
