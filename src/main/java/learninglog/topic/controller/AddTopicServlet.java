package learninglog.topic.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import learninglog.topic.model.Topic;
import learninglog.topic.model.dao.TopicDAO;
import learninglog.user.model.User;

import java.io.File;
import java.io.IOException;

@WebServlet("/addTopic")
@MultipartConfig
public class AddTopicServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Part filePart = request.getPart("topic_image");
        if (filePart.getSize() > 3*1024*1024) {
            session.setAttribute("error", "Image should be less than 3 MB");
            response.sendRedirect("views/dashboard.jsp");
            return;
        }
        String fileName = new File(filePart.getSubmittedFileName()).getName();
        String uploadPath = "D:\\Important\\ACollege\\IICBIT\\1-A-Work\\Advance Programming & Technologies\\Projects\\C7Tutorial\\src\\main\\webapp\\uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        filePart.write(uploadPath + File.separator + fileName);

        Topic topic = new Topic(name, user.getId(), fileName);

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
