package com.hbnu.Lwenku.service;

import com.hbnu.Lwenku.dao.UserDao;
import com.hbnu.Lwenku.model.Role;
import com.hbnu.Lwenku.model.User;
import com.hbnu.Lwenku.util.TransactionUtil;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();
    public Boolean registry(User user){
        try {
            TransactionUtil.beginTransaction();
            int id = userDao.insertUser(user);
            userDao.afterInsert(id);
            TransactionUtil.commitTransaction();
            return true;
        } catch (SQLException throwables) {
            try {
                TransactionUtil.rollbackTransaction();
                System.out.println("roll back");
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
        return true;//true代表成功注册
    }
    public User login(User user){
        User realUser = userDao.getUserByUsername(user.getUsername());
        System.out.println("realUser = " + realUser);
        //存在该用户
        if (realUser!=null){
            //密码错误
            if (!realUser.getPassword().equals(user.getPassword())){
                return null;
            }else {
                //设置角色
                List<Role> roleByUser = userDao.getRoleByUser(realUser.getId());
                for (Role role : roleByUser) {
                    System.out.println("role = " + role);
                }
                if (roleByUser!=null) {
                    realUser.setRoles(roleByUser);
                }
                return realUser;
            }
        }else {
            return null;
        }
    }
}
