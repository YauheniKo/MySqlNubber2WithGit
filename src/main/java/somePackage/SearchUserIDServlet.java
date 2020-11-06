package somePackage;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user-searchID")
public class SearchUserIDServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        String id = request.getParameter("idS");

        Controller controller = new Controller();
        String result =(controller.doAction("SEARCH_USER_ID, "+id));
        pw.println(result);

        if (result.equalsIgnoreCase("Ошибка")|result.equalsIgnoreCase(null)) {
            response.sendRedirect("http://localhost:8080/error-page");
        }


    }
}

