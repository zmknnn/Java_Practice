import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "detailsServlet", value = "/details-servlet")
public class DetailsServlet extends HttpServlet {
    private long totalMemory;
    private long freeMemory;
    private int processors;
    private String os;
    private String architecture;

    public void init() {
        Runtime runtime = Runtime.getRuntime();

        totalMemory = runtime.totalMemory();
        freeMemory = runtime.freeMemory();

        processors = runtime.availableProcessors();

        os = System.getProperty("os.name");
        architecture = System.getProperty("os.arch");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<div>");
        out.println("<html><body>");
        out.println("<h2>" + "TotalMemory: " + totalMemory + "</h2>");
        out.println("<h2>" + "FreeMemory: " + freeMemory + "</h2>");
        out.println("<h2>" + "Processors: " + processors + "</h2>");
        out.println("<h2>" + "OS:" + os + "</h2>");
        out.println("<h2>" + "Architecture: " + architecture + "</h2>");
        out.println("</body></html>");
        out.println("<div>");
    }

    public void destroy() {
    }
}