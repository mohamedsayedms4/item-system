package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import service.ItemService;
import service.impl.ItemServiceImpl;

@WebServlet("/items")
public class ItemController extends HttpServlet {
    private ItemService itemService = new ItemServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            // Get all items
            List<Item> itemsList = itemService.getAllItem();
            req.setAttribute("items", itemsList);

            // Forward to JSP
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/items.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("items", null);
            req.setAttribute("errorMessage", "Error loading data: " + e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/items.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        HttpSession session = req.getSession();

        try {
            boolean result = false;

            if ("add".equals(action)) {
                String name = req.getParameter("name");
                double price = Double.parseDouble(req.getParameter("price"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));

                Item newItem = new Item(name.trim(), price, quantity);
                result = itemService.addItem(newItem);

                session.setAttribute("successMessage", result ? "Item added successfully" : "Failed to add item");

            } else if ("update".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                double price = Double.parseDouble(req.getParameter("price"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));

                Item updateItem = new Item(id, name.trim(), price, quantity);
                result = itemService.updateItemById(updateItem);

                session.setAttribute("successMessage", result ? "Item updated successfully" : "Failed to update item");

            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                result = itemService.removeItemById(id);

                session.setAttribute("successMessage", result ? "Item deleted successfully" : "Failed to delete item");

            } else {
                session.setAttribute("errorMessage", "Unsupported action: " + action);
            }

        } catch (NumberFormatException e) {
            session.setAttribute("errorMessage", "Invalid input data");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Unexpected error: " + e.getMessage());
        }

        // Redirect to avoid duplicate submission
        resp.sendRedirect("items");
    }
}
