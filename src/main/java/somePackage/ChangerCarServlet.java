package somePackage;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ChangerCarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String id = request.getParameter("idC");
        String model = request.getParameter("modelC");
        String type = request.getParameter("typeC");

        Controller con1 = new Controller();
        String result = con1.doAction("CHANGER_CAR, " + id + ", " + model + ", " + type);

        if (result.equalsIgnoreCase("Ошибка")) {
            response.sendRedirect("http://localhost:8080/error-page");


        }

    }
}
