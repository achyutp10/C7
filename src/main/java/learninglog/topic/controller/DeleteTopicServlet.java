package learninglog.topic.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import learninglog.topic.model.dao.TopicDAO;
import learninglog.user.model.User;

import java.io.IOException;

@WebServlet("/deleteTopic")
public class DeleteTopicServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        int topic_id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("views/login.jsp");
        }

        TopicDAO topicDAO = new TopicDAO();
        boolean result = topicDAO.deleteTopic(topic_id, user.getId());
        if (result) {
            session.setAttribute("success", "Topic deleted successfully");
        } else {
            session.setAttribute("error", "Failed to delete topic");
        }
        response.sendRedirect("viewTopics");
    }
}
