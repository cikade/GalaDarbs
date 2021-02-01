import java.util.ArrayList;
import java.util.List;

public class UserTable {
    private List<User> users = new ArrayList<>();

    public UserTable() {
    }

    public void add(User user) {
        user.setId(getSize()+1);
        users.add(user);
    }

    @Override
    public String toString() {
        return "UserTable{" +
                "users=" + users +
                '}';
    }

    public int getSize() {
        return users.size();
    }

    public boolean userExists(User user) {
        for (int i = 0; i < getSize(); i++) {
            if (users.get(i).getUserName().equals(user.getUserName())) {
                return true;
            }
        }
        return false;
    }

    public void updateUser(User appendUser, User newData) {
        if (userExists(appendUser)) {
            users.get(appendUser.getId()-1).setUserName(newData.getUserName());
            users.get(appendUser.getId()-1).setPassWord(newData.getPassWord());
            users.get(appendUser.getId()-1).setUserLevel(newData.getUserLevel());
        }
    }

    public void deleteUser(User user) {
        users.get(user.getId()-1).setDeleted(true);
    }
}
