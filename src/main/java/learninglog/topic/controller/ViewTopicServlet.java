package learninglog.topic.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import learninglog.topic.model.dao.TopicDAO;
import learninglog.topic.model.dto.TopicDTO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/viewTopics")
public class ViewTopicServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        TopicDAO topicDAO = new TopicDAO();
        ArrayList<TopicDTO> topics = topicDAO.viewAllTopics();
        request.setAttribute("topics", topics);
        request.getRequestDispatcher("views/viewTopics.jsp").forward(request,response);
    }
}
