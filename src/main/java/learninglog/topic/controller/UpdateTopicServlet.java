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

@WebServlet("/updateTopic")
public class UpdateTopicServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        int topic_id = Integer.parseInt(request.getParameter("id"));
        String new_topic_name = request.getParameter("name");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("views/login.jsp");
        }

        TopicDAO topicDAO = new TopicDAO();
        boolean result = topicDAO.updateTopic(topic_id, new_topic_name, user.getId());
        if (result) {
            session.setAttribute("success", "Topic updated successfully");
        } else {
            session.setAttribute("error", "Topic failed to update");
        }
        response.sendRedirect("viewTopic");
    }
}
