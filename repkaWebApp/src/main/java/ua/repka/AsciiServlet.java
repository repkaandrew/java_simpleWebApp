package ua.repka;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/toAscii")
public class AsciiServlet extends HttpServlet {
    private AsciiConverter asciiConverter1;
    private AsciiConverter asciiConverter2;
    private String pathToAscii = "/WEB-INF/asciiIndex.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        asciiConverter1 = new AsciiConverter("ascii.txt");
        asciiConverter2 = new AsciiConverter("ascii_.txt");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String asciiString = req.getParameter("asciiString");
        System.out.println(asciiString);
        if (asciiString.equals("")) {
            resp.sendRedirect(req.getContextPath() + "/notFound");
        } else {
            String alphabetStyle = req.getParameter("asciiType");
            System.out.println(alphabetStyle);
            List<String> list = new ArrayList<>();
            if (alphabetStyle.equals("1")) {
                list = asciiConverter1.convertWord(asciiString);
            } else if (alphabetStyle.equals("2")) {
                list = asciiConverter2.convertWord(asciiString);
            }
            req.setAttribute("asciiList", list);
            this.doGet(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher(pathToAscii);
        requestDispatcher.forward(req, resp);
    }
}

