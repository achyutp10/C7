package learninglog.topic.model.dao;

import learninglog.topic.model.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;

public class TopicDAO implements TopicInterface{
    @Override
    public boolean insertTopic(Topic topic) {
        if (topic.getName() == null || topic.getName().trim().isEmpty()) {
            return false;
        }

        String sql ="INSERT INTO topic(name,user_id,created_at,updated_at) values(?,?,NOW(),NOW())";

        try (Connection conn = learninglog.c5.utils.DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, topic.getName());
            ps.setInt(2,topic.getUser_id());
            int row = ps.executeUpdate();
            return row > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
