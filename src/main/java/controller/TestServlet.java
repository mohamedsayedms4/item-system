package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        System.out.println("🧪 TestServlet.doGet() called!");
        System.out.println("📍 Request URL: " + req.getRequestURL());
        System.out.println("📍 Context Path: " + req.getContextPath());
        System.out.println("📍 Servlet Path: " + req.getServletPath());
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Test Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>✅ Servlet is working!</h1>");
        out.println("<p>If you see this, your servlet configuration is correct.</p>");
        out.println("<p><a href='items'>Go to Items</a></p>");
        out.println("</body>");
        out.println("</html>");
        
        out.flush();
        out.close();
    }
}