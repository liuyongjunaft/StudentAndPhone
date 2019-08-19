package com.lyj.Dao.Impl;

import com.lyj.Dao.IPhoneDao;
import com.lyj.entity.Phone;
import org.junit.Test;

import java.util.List;

public class TestPhoneDaoImpl {
    IPhoneDao phoneDao=new PhoneDaoImpl();
    @Test
    public void testUpDatePhone(){
        Integer count = phoneDao.upDatePhone(5, "姐弟", "1475212314");
        System.out.println(count);
    }
    @Test
    public void testAddPhone(){
        Phone phone = new Phone("姐弟", "1475212314", 1);
        Integer count = phoneDao.addPhone(phone);
        System.out.println(count);
    }

    @Test
    public void testGetPhoneBySid(){
        List<Phone> phoneBySid = phoneDao.getPhoneBySid(1);
        System.out.println(phoneBySid);
    }
    @Test
    public void testGetPhoneBYid(){
        Phone phoneBYid = phoneDao.getPhoneBYid(1);
        System.out.println(phoneBYid);
    }
}
