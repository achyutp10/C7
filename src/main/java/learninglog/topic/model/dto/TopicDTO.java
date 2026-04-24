package learninglog.topic.model.dto;

import java.time.LocalDateTime;

public class TopicDTO {
    private int topic_id;
    private String topic_name;
    private LocalDateTime created_at;
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_role;
    private String topic_image;

    public String getTopic_image() {
        return topic_image;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_role() {
        return user_role;
    }

    public TopicDTO(int topic_id, String topic_name, LocalDateTime created_at, int user_id, String user_name, String user_email, String user_role) {
        this.topic_id = topic_id;
        this.topic_name = topic_name;
        this.created_at = created_at;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_role = user_role;
    }

    public TopicDTO(int topic_id, String topic_name, LocalDateTime created_at, int user_id, String user_name, String user_email, String user_role, String topic_image) {
        this.topic_id = topic_id;
        this.topic_name = topic_name;
        this.created_at = created_at;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_role = user_role;
        this.topic_image = topic_image;
    }
}
