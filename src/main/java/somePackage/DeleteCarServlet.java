package somePackage;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCarServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest" +
            "?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("idDel");
        String model = request.getParameter("modelDel");
        String type = request.getParameter("typeDel");

        Controller con1 = new Controller();
        con1.doAction("DELETE, " + id + ", " + model + ", " + type);
        String res1 = con1.doAction("DELETE, " + id + ", " + model + ", " + type);

        if (res1.equalsIgnoreCase("Ошибка")) {
            response.sendRedirect("http://localhost:8080/error-page");
        }






    }
}
