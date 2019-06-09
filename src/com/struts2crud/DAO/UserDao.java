package com.struts2crud.DAO;

import java.util.List;
import com.struts2crud.Bean.User;

public interface UserDao {

	User getUser(int id) throws Exception;

	User getUser(String email) throws Exception;

	List<User> getUsers() throws Exception;

	boolean updateUser(User u) throws Exception;

	boolean deleteUser(int id) throws Exception;

	List<User> getUsers(String name) throws Exception;

}
