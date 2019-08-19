package com.lyj.Dao.Impl;

import com.lyj.Dao.IStudentDao;
import org.junit.Test;

public class TestStudentDaoImpl {
    IStudentDao studentDao=new StudentDaoImpl();
    @Test
    public void testGetStudent(){
        Integer id = studentDao.getStudent("李四", "147");
        System.out.println(id);
    }

}
