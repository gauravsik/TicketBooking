
package com.bitwise.servletassignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RegisteredUsers {
	List<User> usersData = new ArrayList<User>();
	//Map<Integer , User> usersData = new HashMap<Integer, User>();
	public RegisteredUsers(){
		usersData.add(new User("gaurav", "g123"));
		usersData.add(new User("varun", "v456"));
		usersData.add(new User("tarun", "t789"));
		usersData.add(new User("simranjit", "s987"));
		usersData.add(new User("saurabh", "s654"));
		/*usersData.put(1,new User("gaurav", "g123"));
		usersData.put(2,new User("varun", "v456"));
		usersData.put(3,new User("simranjit", "s987"));
		usersData.put(4,new User("saurabh", "s654"));*/
	}
	public List<User> getUsersData(){
		return this.usersData;
	}
	
/*	public Map<Integer , User> getUsersData(){
		return this.usersData;
	}*/
}
