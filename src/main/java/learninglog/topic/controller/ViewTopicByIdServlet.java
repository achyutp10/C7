package learninglog.topic.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import learninglog.topic.model.dao.TopicDAO;
import learninglog.topic.model.dto.TopicDTO;

import java.io.IOException;

@WebServlet("/viewTopicById")
public class ViewTopicByIdServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        TopicDAO topicDAO = new TopicDAO();
        int topic_id = Integer.parseInt(request.getParameter("id"));
        TopicDTO topic = topicDAO.viewTopicById(topic_id);
        request.setAttribute("topic", topic);
        request.getRequestDispatcher("views/viewTopicById.jsp").forward(request,response);
    }
}
