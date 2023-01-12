package com.hbnu.Lwenku.dao;

import com.hbnu.Lwenku.model.Hon;
import com.hbnu.Lwenku.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HonDao {
    public List<Hon> getAllHon(){
        List<Hon> all=new ArrayList<>();
        Connection conn= DBUtil.getConn();
        Statement stmt=null;
        ResultSet rs=null;
        try{
            stmt=conn.createStatement();
            String sql="select * from hon";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Hon hon=new Hon();
                hon.setId(rs.getInt("id"));
                hon.setCover(rs.getString("cover"));
                hon.setName(rs.getString("name"));
                hon.setAuthor(rs.getString("author"));
                hon.setHeat(rs.getInt("heat"));
                hon.setDate(rs.getDate("date"));
                hon.setPrice(rs.getString("price"));
                hon.setRecommend(rs.getInt("recommend"));
                all.add(hon);
            }
        }catch (SQLException e){
            System.out.println("查询所有异常"+e.getMessage());
        }finally {
            DBUtil.release(rs,stmt,conn);
        }
        return all;
    }
    public List<Hon> getHonsByName(String name){
        List<Hon> hons=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt=conn.createStatement();
            String sql="select * from hon where name like'%"+name+"%'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Hon hon=new Hon();
                hon.setId(rs.getInt("id"));
                hon.setCover(rs.getString("cover"));
                hon.setName(rs.getString("name"));
                hon.setAuthor(rs.getString("author"));
                hon.setHeat(rs.getInt("heat"));
                hon.setDate(rs.getDate("date"));
                hon.setPrice(rs.getString("price"));
                hon.setRecommend(rs.getInt("recommend"));
                hons.add(hon);
            }
        }catch (SQLException e){
            System.out.println("按书名查询异常："+e.getMessage());
        }finally {
            DBUtil.release(rs,stmt,conn);
        }
        return hons;
    }
    public List<Hon> getHonByAuthor(String author){
        List<Hon> hons=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt=conn.createStatement();
            String sql="select * from hon where author like'%"+author+"%'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Hon hon=new Hon();
                hon.setId(rs.getInt("id"));
                hon.setCover(rs.getString("cover"));
                hon.setName(rs.getString("name"));
                hon.setAuthor(rs.getString("author"));
                hon.setHeat(rs.getInt("heat"));
                hon.setDate(rs.getDate("date"));
                hon.setPrice(rs.getString("price"));
                hon.setRecommend(rs.getInt("recommend"));
                hons.add(hon);
            }
        }catch (SQLException e){
            System.out.println("按作者查询异常："+e.getMessage());
        }finally {
            DBUtil.release(rs,stmt,conn);
        }
        return hons;
    }
    public List<Hon> getHonByPrice(String year){
        List<Hon> hons=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt=conn.createStatement();
            String sql="select * from hon where price like'%"+year+"%'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Hon hon=new Hon();
                hon.setId(rs.getInt("id"));
                hon.setCover(rs.getString("cover"));
                hon.setName(rs.getString("name"));
                hon.setAuthor(rs.getString("author"));
                hon.setHeat(rs.getInt("heat"));
                hon.setDate(rs.getDate("date"));
                hon.setPrice(rs.getString("price"));
                hon.setRecommend(rs.getInt("recommend"));
                hons.add(hon);
            }
        }catch (SQLException e){
            System.out.println("获奖查询异常："+e.getMessage());
        }finally {
            DBUtil.release(rs,stmt,conn);
        }
        return hons;
    }
    public List<Hon> orderByHot(){
        List<Hon> hons=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt=conn.createStatement();
            String sql="SELECT * FROM hon ORDER BY heat DESC LIMIT 10;" ;
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Hon hon=new Hon();
                hon.setId(rs.getInt("id"));
                hon.setCover(rs.getString("cover"));
                hon.setName(rs.getString("name"));
                hon.setAuthor(rs.getString("author"));
                hon.setHeat(rs.getInt("heat"));
                hon.setDate(rs.getDate("date"));
                hon.setPrice(rs.getString("price"));
                hon.setRecommend(rs.getInt("recommend"));
                hons.add(hon);
            }
        }catch (SQLException e){
            System.out.println("按热度排序异常："+e.getMessage());
        }finally {
            DBUtil.release(rs,stmt,conn);
        }
        return hons;
    }
    public List<Hon> orderByDate(){
        List<Hon> hons=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt=conn.createStatement();
            String sql="SELECT * FROM hon ORDER BY DATE DESC;";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Hon hon=new Hon();
                hon.setId(rs.getInt("id"));
                hon.setCover(rs.getString("cover"));
                hon.setName(rs.getString("name"));
                hon.setAuthor(rs.getString("author"));
                hon.setHeat(rs.getInt("heat"));
                hon.setDate(rs.getDate("date"));
                hon.setPrice(rs.getString("price"));
                hon.setRecommend(rs.getInt("recommend"));
                hons.add(hon);
            }
        }catch (SQLException e){
            System.out.println("按日期排序异常："+e.getMessage());
        }finally {
            DBUtil.release(rs,stmt,conn);
        }
        return hons;
    }
    public List<Hon> orderByRecommend(){
        List<Hon> hons=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt=conn.createStatement();
            String sql="SELECT * FROM hon ORDER BY recommend DESC;";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Hon hon=new Hon();
                hon.setId(rs.getInt("id"));
                hon.setCover(rs.getString("cover"));
                hon.setName(rs.getString("name"));
                hon.setAuthor(rs.getString("author"));
                hon.setHeat(rs.getInt("heat"));
                hon.setDate(rs.getDate("date"));
                hon.setPrice(rs.getString("price"));
                hon.setRecommend(rs.getInt("recommend"));
                hons.add(hon);
            }
        }catch (SQLException e){
            System.out.println("按推荐排序异常："+e.getMessage());
        }finally {
            DBUtil.release(rs,stmt,conn);
        }
        return hons;
    }
    public void toRecommend(String name){
        Connection conn=DBUtil.getConn();
        PreparedStatement pstmt=null;
        try{
            String sql="UPDATE hon SET recommend=recommend+1 WHERE name = ?;";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("推荐异常："+e.getMessage());
        }finally {
            DBUtil.release(pstmt,conn);
        }
    }
    public void addHon(Hon hon){
        Connection conn=DBUtil.getConn();
        PreparedStatement pstmt=null;
        try{
            String sql="INSERT INTO hon (cover,name,author,heat,date,price)VALUES(?,?,?,?,?,?);";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,hon.getCover());
            pstmt.setString(2,hon.getName());
            pstmt.setString(3,hon.getAuthor());
            pstmt.setInt(4,hon.getHeat());
            pstmt.setDate(5,new java.sql.Date(hon.getDate().getTime()));
            pstmt.setString(6,hon.getPrice());
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("添加书本异常"+e.getMessage());
        }finally {
            DBUtil.release(pstmt,conn);
        }
    }
    public void delHonById(int id){
        Connection conn=DBUtil.getConn();
        PreparedStatement pstmt=null;
        try{
            String sql="delete from hon where id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("删除异常："+e.getMessage());
        }finally {
            DBUtil.release(pstmt,conn);
        }
    }
    public void updateHon(Hon hon){
        Connection conn=DBUtil.getConn();
        PreparedStatement pstmt=null;
        try{
            String sql="update hon set cover=?,author=?,heat=?,date=?,price=?,name = ? where id =?;";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,hon.getCover());
            pstmt.setString(2,hon.getAuthor());
            pstmt.setInt(3,hon.getHeat());
            pstmt.setDate(4,new java.sql.Date(hon.getDate().getTime()));
            pstmt.setString(5,hon.getPrice());
            pstmt.setString(6,hon.getName());
            pstmt.setInt(7,hon.getId());
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("更新书本异常"+e.getMessage());
        }finally {
            DBUtil.release(pstmt,conn);
        }
    }
}
