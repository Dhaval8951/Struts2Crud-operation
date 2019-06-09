package com.struts2crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.struts2crud.Bean.User;

public class UserDaoImpl implements UserDao {

	// private static final Logger log = Logger.getLogger(UserDaoImpl.class);

	private static final String insertUser = "Insert into Users(uname,email,pass,deg) values (?,?,?,?)";
	private static final String updateUser = "update Users set uname=?,email=?,pass=?,deg=? where id = ?";
	private static final String deleteUser = "Delete from Users where id = ?";
	private static final String fetchUsers = "select * from Users";
	private static final String searchUsers = "select * from Users where uname like ?";
	private static final String fetchUser = "select * from Users where id = ?";
	private static final String fetchUserByEmail = "select * from Users where email = ?";

	public boolean registerUser(User u) throws Exception {
		Connection conn = DBManager.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement stmt = conn.prepareStatement(insertUser);
		stmt.setString(1, u.getName());
		stmt.setString(2, u.getEmail());
		stmt.setString(3, u.getPass());
		stmt.setString(4, u.getDeg());
		int res;
		try {
			res = stmt.executeUpdate();
			if (res > 0) {
				conn.commit();
				// log.info("User inserted into Database: " + u.getEmail());
				return true;
			}
		} catch (SQLException e) {
			// log.error("Unable to insert User");
			e.printStackTrace();
		} finally {
			stmt.close();
			DBManager.releaseConnection(conn);
		}

		return false;

	}

	@Override
	public User getUser(int id) throws Exception {
		User user = null;
		Connection conn = DBManager.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement stmt = conn.prepareStatement(fetchUser);
		stmt.setInt(1, id);
		try {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPass(rs.getString(4));
				user.setDeg(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			DBManager.releaseConnection(conn);
		}

		return user;
	}

	@Override
	public List<User> getUsers() throws Exception {
		List<User> users = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		PreparedStatement stmt = conn.prepareStatement(fetchUsers);
		User user = null;
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPass(rs.getString(4));
				user.setDeg(rs.getString(5));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			DBManager.releaseConnection(conn);
		}

		return users;
	}

	@Override
	public boolean updateUser(User u) throws Exception {
		Connection conn = DBManager.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement stmt = conn.prepareStatement(updateUser);
		stmt.setString(1, u.getName());
		stmt.setString(2, u.getEmail());
		stmt.setString(3, u.getPass());
		stmt.setString(4, u.getDeg());
		stmt.setInt(5, u.getId());
		int res = 0;
		try {
			res = stmt.executeUpdate();
			if (res > 0) {
				conn.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			DBManager.releaseConnection(conn);
		}

		return false;
	}

	@Override
	public boolean deleteUser(int id) throws Exception {
		Connection conn = DBManager.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement stmt = conn.prepareStatement(deleteUser);
		stmt.setInt(1, id);
		int res = 0;
		try {
			res = stmt.executeUpdate();
			if (res > 0) {
				conn.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			DBManager.releaseConnection(conn);
		}

		return false;
	}

	@Override
	public List<User> getUsers(String name) throws Exception {
		List<User> users = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		PreparedStatement stmt = conn.prepareStatement(searchUsers);
		stmt.setString(1, "%" + name + "%");
		User user = null;
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPass(rs.getString(4));
				user.setDeg(rs.getString(5));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			DBManager.releaseConnection(conn);
		}

		return users;
	}

	@Override
	public User getUser(String email) throws Exception {
		User user = null;
		Connection conn = DBManager.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement stmt = conn.prepareStatement(fetchUserByEmail);
		stmt.setString(1, email);
		try {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPass(rs.getString(4));
				user.setDeg(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			DBManager.releaseConnection(conn);
		}

		return user;
	}

}
