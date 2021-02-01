import java.util.Date;

public class User {
    private int id;
    private String userName;
    private String passWord;
    private int userLevel;
    private boolean isDeleted;
    private Date lastSeen;

    public User(String userName, String userPass) {
        this.userName = userName;
        this.passWord = userPass;
        this.userLevel = 0;
        this.isDeleted = false;
        this.lastSeen = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userLevel=" + userLevel +
                ", isDeleted=" + isDeleted +
                ", lastSeen=" + lastSeen +
                '}';
    }
}
