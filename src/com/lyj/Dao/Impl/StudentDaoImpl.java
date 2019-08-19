package com.lyj.Dao.Impl;

import com.lyj.Dao.IStudentDao;
import com.lyj.utils.DBClose;
import com.lyj.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements IStudentDao {
    @Override
    public Integer getStudent(String username,String password) {
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rSet =null;
        int id=0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select id from Student where username=? and password=? and is_delete=1");
           ps.setString(1,username);
           ps.setString(2,password);
           rSet = ps.executeQuery();
           if(rSet.next()){
               id = rSet.getInt(1);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(rSet,ps,conn);
        }
        return id;
    }
}
