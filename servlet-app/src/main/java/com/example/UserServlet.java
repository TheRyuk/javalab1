package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Отримуємо або створюємо сесію
        HttpSession session = request.getSession();
        
        // Встановлюємо атрибут сесії
        session.setAttribute("username", "JohnDoe");
        
        // Додаємо кукі
        response.addCookie(new Cookie("user", "JohnDoe"));
        
        out.println("<html><body>");
        out.println("<h1>Hello, Servlet!</h1>");
        out.println("<p>Session username: " + session.getAttribute("username") + "</p>");
        out.println("</body></html>");
    }
} 