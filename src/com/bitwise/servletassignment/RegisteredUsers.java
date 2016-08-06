
package com.bitwise.servletassignment;

import java.util.HashMap;
import java.util.Map;

public class RegisteredUsers {
	Map<String, String> usersData = new HashMap<String , String>();
	public RegisteredUsers(){
		usersData.put("gaurav", "gaurav@123");
		usersData.put("varun", "varun@456");
		usersData.put("tarun", "tarun@789");
		usersData.put("simranjit", "simranjit@987");
		usersData.put("saurabh", "saurabh@654");
	}
	public Map<String , String> getUsersData(){
		return usersData;
	}
}
