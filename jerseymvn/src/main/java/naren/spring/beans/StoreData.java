package naren.spring.beans;

import java.util.HashMap;
import java.util.Map;

import naren.jersey.pojo.User;

import org.springframework.stereotype.Component;

@Component
public class StoreData {

	private Map<Integer,User> user = new HashMap<Integer,User>();

	public Map<Integer,User> getUser() {
		return user;
	}

	public void addUser(int userId, User user) {
		this.user.put(userId,user);
	}

}
