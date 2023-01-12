package com.hbnu.Lwenku.dao;

import com.hbnu.Lwenku.model.Role;
import com.hbnu.Lwenku.model.User;
import com.hbnu.Lwenku.util.DBUtil;
import com.hbnu.Lwenku.util.TransactionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public User getUserById(String id){
        Connection conn = DBUtil.getConn();
        Statement stmt =null;
        ResultSet rs=null;
        User user=null;
        String sql="select * from user where id='" +id+ "'";
        try{
            stmt =conn.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }catch(SQLException e){
            System.out.println("根据id找账户异常："+e.getMessage());
        }finally {
            DBUtil.release(rs,stmt,conn);
        }
        return user;
    }
    public User getUserByUsername(String username){
        Connection conn = DBUtil.getConn();
        Statement stmt =null;
        ResultSet rs=null;
        User user=null;
        String sql="select * from user where username='" +username+ "'";
        try{
            stmt =conn.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }catch(SQLException e){
            System.out.println("根据username找账户异常："+e.getMessage());
        }finally {
            DBUtil.release(rs,stmt,conn);
        }
        return user;
    }
    public List<Role> getRoleByUser(int id){
        List<Role> roles=new ArrayList<>();
        Connection conn = DBUtil.getConn();
        Statement stmt =null;
        ResultSet rs=null;
        try{
            stmt=conn.createStatement();
            String sql="select role.* from (role,user_role) WHERE user_role.rid=role.id and user_role.uid='"+id+"'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                role.setNameZh(rs.getString("nameZh"));
                roles.add(role);
            }
        }catch (SQLException e){
            System.out.println("查询用户角色异常"+e.getMessage());
        }finally {
            DBUtil.release(rs,stmt,conn);
        }
        return roles;
    }
    public Role getRoleById(String id){
        Connection conn = DBUtil.getConn();
        Statement stmt =null;
        ResultSet rs=null;
        Role role=null;
        String sql="select * from role where id='" +id+ "'";
        try{
            stmt =conn.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs.next()){
                role=new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                role.setNameZh(rs.getString("nameZh"));
            }
        }catch(SQLException e){
            System.out.println("根据id找Role异常："+e.getMessage());
        }finally {
            DBUtil.release(rs,stmt,conn);
        }
        return role;
    }
    public int insertUser(User user){
        Connection conn= TransactionUtil.getConnection();
        PreparedStatement pstmt1=null;
        ResultSet rs = null;
        Integer id = null;
        try{
            String sql1="INSERT  INTO `user`(`username`,`password`) VALUES (?,?);";
            pstmt1=conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
            pstmt1.setString(1,user.getUsername());
            pstmt1.setString(2,user.getPassword());
            pstmt1.executeUpdate();
            //获取刚刚插入的id
            rs=pstmt1.getGeneratedKeys();
            if (rs.next()){
                id = rs.getInt(1);
                System.out.println("id = " + id);
            }
        }catch (SQLException e){
            System.out.println("添加账户异常："+e.getMessage());
        }
        return id;
    }
    public void afterInsert(int id){
        Connection conn= TransactionUtil.getConnection();
        PreparedStatement pstmt1=null;
        try{
            //默认普通用户
            String sql2="INSERT  INTO `user_role`(`uid`,`rid`) VALUES (?,2);";
            pstmt1=conn.prepareStatement(sql2);
            pstmt1.setInt(1,id);
            pstmt1.executeUpdate();
        }catch (SQLException e){
            System.out.println("添加账户异常："+e.getMessage());
        }
    }

}
