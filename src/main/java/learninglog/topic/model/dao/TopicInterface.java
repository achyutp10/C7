package learninglog.topic.model.dao;

import learninglog.topic.model.Topic;
import learninglog.topic.model.dto.TopicDTO;

import java.util.ArrayList;

public interface TopicInterface {
    boolean insertTopic(Topic topic);
    ArrayList<TopicDTO> viewAllTopics();
    boolean updateTopic(int topicId, String topicName, int userId);
    boolean deleteTopic(int topicId, int userId);
    TopicDTO viewTopicById(int topic_id);

}
