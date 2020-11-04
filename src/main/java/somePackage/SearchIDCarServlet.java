package somePackage;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchIDCarServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest" +
            "?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        String id = request.getParameter("idS");

        Controller controller = new Controller();
        String result = (controller.doAction("SEARCH_ID, "+id));
        pw.println(result);

        if (result.equalsIgnoreCase("Ошибка")|result.equalsIgnoreCase(null)) {
            response.sendRedirect("http://localhost:8080/error-page");
        }


    }
}
