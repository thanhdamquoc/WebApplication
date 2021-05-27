import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String word = request.getParameter("search");
        HashMap<String,String> dictionary = new HashMap<>();
        dictionary.put("dog","dawg");
        dictionary.put("cat","meow");
        String result = "Not found";
        if (dictionary.containsKey(word)) {
            result = dictionary.get(word);
        }
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println(result);
        writer.println("</html>");
    }
}
