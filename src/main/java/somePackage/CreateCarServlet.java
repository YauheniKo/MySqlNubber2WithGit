package somePackage;


import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/car-create")
public class CreateCarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String id = request.getParameter("id");
        String model = request.getParameter("model");
        String type = request.getParameter("type");

        Controller con1 = new Controller();
            String result = con1.doAction("CREATE, " + id + ", " + model + ", " + type);

       if (result.equalsIgnoreCase("Ошибка")) {
           response.sendRedirect("http://localhost:8080/error-page");


        }

    }

}











