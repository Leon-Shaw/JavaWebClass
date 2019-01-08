package class7_2.dao;

import class7_2.domain.User;
import class7_2.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDao {
    public boolean insert(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnecting();
            String sql = "INSERT INTO users VALUES (?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getSex());
            pstmt.setInt(5, user.getAge());
            pstmt.setDate(6, (java.sql.Date) user.getBirthday());
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(null, pstmt, conn);
        }
        return false;
    }

    public ArrayList<User> findAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try {
            conn = JDBCUtils.getConnecting();
            String sql = "SELECT * FROM users";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirthday(rs.getDate("birthday"));
                list.add(user);
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstmt, conn);
        }
        return null;
    }

    public User find(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnecting();
            String sql = "SELECT * FROM users WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }
            return null;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstmt, conn);
        }
        return null;
    }

    public boolean delete(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnecting();
            String sql = "DELETE FROM users WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int result = pstmt.executeUpdate();
            return result != 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstmt, conn);
        }
        return false;
    }

    public boolean update(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnecting();
            String sql = "UPDATE users SET name=?,password=?,sex=?,age=?,birthday=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(6, user.getId());
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getSex());
            pstmt.setInt(4, user.getAge());
            pstmt.setDate(5, (java.sql.Date) user.getBirthday());
            int num = pstmt.executeUpdate();
            return num > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(null, pstmt, conn);
        }
        return false;
    }
}
