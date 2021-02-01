import java.util.ArrayList;
import java.util.List;

public class UserTable {
	private List<User> users = new ArrayList<>();

	public UserTable() {
	}

	public UserTable(List<User> users) {
		this.users = users;
	}

	public final List<User> getUsers() {
		return users;
	}

	public final void setUsers(List<User> users) {
		this.users = users;
	}

	public void add(User user) {
		users.add(user);
	}

	public int getSize() {
		return users.size();
	}

	public int logIn(String userName,String passWord) {
		User result = users.stream().filter(users -> userName.equals(users.getUserName())).findFirst().orElse(null);
		if (result != null) {
			System.out.println("Welcome back!");
			return result.getUserLevel();
		}
		System.out.println("This email isn't registered in this system!");
		return 0;
	}

	public void updateUser(int id, String userName, String passWord, int userLevel) {
		User user = users.get(id - 1);
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setUserLevel(userLevel);
	}

	public void deleteUser(int id) {
		users.remove(id);
	}

}
