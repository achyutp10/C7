package learninglog.topic.model.dao;

import learninglog.topic.model.Topic;
import learninglog.topic.model.dto.TopicDTO;
import learninglog.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class TopicDAO implements TopicInterface{
    @Override
    public boolean insertTopic(Topic topic) {
        if (topic.getName() == null || topic.getName().trim().isEmpty()) {
            return false;
        }

        String sql ="INSERT INTO topic(name,user_id,created_at,updated_at) values(?,?,NOW(),NOW())";

        try (Connection conn = DBConnection.getConnection();
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

    @Override
    public ArrayList<TopicDTO> viewAllTopics() {
        ArrayList<TopicDTO> topics = new ArrayList<>();
        String sql = "SELECT t.id, t.name, t.created_at, t.user_id, u.name as user_name, u.email,u.role FROM topic t JOIN user u on t.user_id = u.id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TopicDTO topic = new TopicDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_email"),
                        rs.getString("user_role")
                );
                topics.add(topic);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return topics;
    }

    @Override
    public boolean updateTopic(int topicId, String topicName, int userId) {
        String sql = "UPDATE topic SET name=?, updated_at=NOW() where id=?, user_id=?";

        try (Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, topicName);
            ps.setInt(2, topicId);
            ps.setInt(3, userId);

            int row = ps.executeUpdate();
            return row>0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTopic(int topicId, int userId) {
        String sql = "DELETE FROM topic where id=? AND user_id=?";

        try (Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, topicId);
            ps.setInt(2, userId);

            int row = ps.executeUpdate();
            return row>0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
