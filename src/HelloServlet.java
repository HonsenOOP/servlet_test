import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Honsen on 2016/9/5.
 *
 */
public class HelloServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        HelloModel helloModel = (HelloModel)req.getAttribute("hello");

        System.out.println("The input: " + helloModel);
        req.setAttribute("hello",helloModel);
        req.getRequestDispatcher("/hello.jsp").forward(req,resp);
    }
}
