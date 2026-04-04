package learninglog.topic.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import learninglog.topic.model.Topic;
import learninglog.topic.model.dao.TopicDAO;
import learninglog.user.model.User;

import java.io.IOException;

@WebServlet("/addTopic")
public class AddTopicServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Topic topic = new Topic(name, user.getId());

        TopicDAO topicDAO = new TopicDAO();
        boolean result = topicDAO.insertTopic(topic);

        if (result) {
            session.setAttribute("success", "Topic added successfully");
        } else {
            session.setAttribute("error", "Topic not added");
        }
        response.sendRedirect("views/dashboard.jsp");
    }
}
