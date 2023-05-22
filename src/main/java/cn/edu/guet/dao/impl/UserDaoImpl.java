package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.UserDao;
import cn.edu.guet.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author liwei
 * @Date 2023/5/16 20:27
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int saveUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt;//Statement：语句，PreparedStatement：预编译语句对象
        String url = "jdbc:mysql://localhost:3306/16ban?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "INSERT INTO users(username,address) VALUES(?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "123456");
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getAddress());
            int save=pstmt.executeUpdate();
            conn.commit();
            return save;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
