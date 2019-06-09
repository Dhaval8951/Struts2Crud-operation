package com.struts2crud.Action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2crud.Bean.User;
import com.struts2crud.DAO.UserDaoImpl;

public class UserAction extends ActionSupport {

	private String name;
	private String pass;
	private String email;
	private String deg;
	private boolean isRegistered;
	private String msg = "";
	private String from = "";
	private static final Logger log = Logger.getLogger(UserDaoImpl.class);
	int id;
	private List<User> users = null;
	private String submitType;
	HttpSession session;

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	public String registerUser() {
		if (getFrom().equalsIgnoreCase("Report")) {
			return "REGISTER";
		}
		User u = new User();
		u.setName(name);
		u.setPass(pass);
		u.setEmail(email);
		u.setDeg(deg);

		try {
			isRegistered = new UserDaoImpl().registerUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isRegistered) {
			msg = "User registered Successfully";
			// log.info("User registeration successful");
		} else {
			msg = "Registration Failed";
		}

		return "LOGIN";
	}

	public String fetchAllUsers() {
		try {
			users = new UserDaoImpl().getUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}

	public String updateUser() {
		String PAGE = null;
		if (submitType.equalsIgnoreCase("retrieve")) {
			PAGE = "UPDATE";
			try {
				User user = new UserDaoImpl().getUser(getId());
				id = user.getId();
				name = user.getName();
				email = user.getEmail();
				pass = user.getPass();
				deg = user.getDeg();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			PAGE = "REPORT";
			User u = new User();
			u.setId(getId());
			u.setName(getName());
			u.setEmail(getEmail());
			u.setPass(getPass());
			u.setDeg(getDeg());
			try {
				boolean isUpdated = new UserDaoImpl().updateUser(u);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return PAGE;
	}

	public String searchUser() {
		try {
			users = new UserDaoImpl().getUsers(getName());
			setUsers(users);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "RESULT";
	}

	public String deleteUser() {
		try {
			boolean isDeleted = new UserDaoImpl().deleteUser(getId());
			if (isDeleted) {
				msg = "User removed from the system";
			} else {
				msg = "Error in Removing User";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "DELETE";
	}

	public String validateUserLogin() {
		String email = getEmail();
		String pass = getPass();
		User user = null;
		try {
			user = new UserDaoImpl().getUser(email);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user != null) {
			if (user.getPass().equals(pass)) {
				System.out.println("Login Successful");
				session = ServletActionContext.getRequest().getSession();
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(30);
				return SUCCESS;
			}
		}
		addActionError("Invalid User Details");
		return INPUT;

	}

	public String LogoutAction() {
		ServletActionContext.getRequest().getSession(false).invalidate();
		return "LOGOUT";
	}
}
