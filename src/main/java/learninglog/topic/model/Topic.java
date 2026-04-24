package learninglog.topic.model;

import java.time.LocalDateTime;

public class Topic {
    private int id;
    private String name;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private int user_id;
    private String topic_image;

    public String getTopic_image() {
        return topic_image;
    }

    public void setTopic_image(String topic_image) {
        this.topic_image = topic_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Topic(String name, int user_id) {
        this.name = name;
        this.user_id = user_id;
    }

    public Topic(String name, int user_id, String topic_image) {
        this.name = name;
        this.user_id = user_id;
        this.topic_image = topic_image;
    }
}
