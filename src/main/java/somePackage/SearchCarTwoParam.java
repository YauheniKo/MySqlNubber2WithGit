package somePackage;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchCarTwoParam extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter pw = response.getWriter();

        String model = request.getParameter("modelP");
        String type = request.getParameter("typeP");

        Controller controller = new Controller();
        String result = (controller.doAction("SEARCH_TWO_PARAM, "+model+", "+type));
        pw.println(result.toString());
        if (result.equalsIgnoreCase("Ошибка")|result.equalsIgnoreCase(null)) {
            response.sendRedirect("http://localhost:8080/error-page");
        }

    }
}
