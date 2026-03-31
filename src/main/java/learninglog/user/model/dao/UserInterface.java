package learninglog.user.model.dao;


import learninglog.user.model.User;

public interface UserInterface {
    boolean registerUser(User user);
    User loginUser(String email, String password);
}
