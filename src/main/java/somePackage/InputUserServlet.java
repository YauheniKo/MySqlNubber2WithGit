package somePackage;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
            response.sendRedirect("http://localhost:8080/view-page");


        HttpSession session = request.getSession();
        // получаем объект name
        String name = (String) session.getAttribute("name");

        PrintWriter out = response.getWriter();
        try {
            // если объект ранее не установлен
            if(name == null) {
                // устанавливаем объект с ключом name
                session.setAttribute("name", "Tom Soyer");
                out.println("Session data are set");
            }
            else {
                out.println("Name: " + name);
                // удаляем объект с ключом name
                session.removeAttribute("name");
            }
        }
        finally {
            out.close();
        }

    }
}
