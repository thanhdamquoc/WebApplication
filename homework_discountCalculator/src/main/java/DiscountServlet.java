import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("product-name");
        double productPrice = Double.parseDouble(request.getParameter("product-price"));
        double discountPercentage = Double.parseDouble(request.getParameter("discount-percentage"));
        double discountAmount = productPrice * discountPercentage / 100;
        double discountPrice = productPrice - discountAmount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println(productName + "<br>");
        writer.println("Discount Amount: " + discountAmount + "<br>");
        writer.println("Discount Price: " + discountPrice + "<br>");
        writer.println("</html>");
    }
}
