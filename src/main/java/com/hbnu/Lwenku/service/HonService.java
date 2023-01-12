package com.hbnu.Lwenku.service;

import com.hbnu.Lwenku.dao.HonDao;
import com.hbnu.Lwenku.model.Hon;
import java.text.SimpleDateFormat;
import java.util.List;

public class HonService{
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
    HonDao honDao = new HonDao();
    public List<Hon> search(String param,String by){
        //1代表查找书名 2代表查找作者
        if ("1".equals(by)){
            return honDao.getHonsByName(param);
        }else {
            return honDao.getHonByAuthor(param);
        }
    }
    public void addHon(Hon hon){
        if ("".equals(hon.getCover())){
            //设置默认封面
            hon.setCover("img\\default.png");
        }
        honDao.addHon(hon);
    }
    public void updateHon(Hon hon){
        if ("".equals(hon.getCover())){
            //设置默认封面
            hon.setCover("img\\default.png");
        }
        honDao.updateHon(hon);
    }
    public List<Hon> getAllHon(){
        return honDao.getAllHon();
    }
    public List<Hon> orderByHot(){
        return honDao.orderByHot();
    }
    public List<Hon> orderByDate(){
        return honDao.orderByDate();
    }
    public List<Hon> getHonByPrice(String year){
        return honDao.getHonByPrice(year);
    }
    public void toRecommend(String name){
        honDao.toRecommend(name);
    }
    public Boolean delHon(int id,String role){
        boolean flag = true;
        if ("1".equals(role)){
            honDao.delHonById(id);
        }else {
            flag=false;
        }
        return flag;
    }
    public Boolean toUpdateUser(String role){
        if ("1".equals(role)) {
            return true;
        }else {
            return false;
        }
    }
}
