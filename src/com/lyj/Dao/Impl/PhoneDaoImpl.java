package com.lyj.Dao.Impl;

import com.lyj.Dao.IPhoneDao;
import com.lyj.entity.Phone;
import com.lyj.utils.DBClose;
import com.lyj.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements IPhoneDao {

    @Override
    public List<Phone> getPhoneBySid(Integer sid) {
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rSet =null;
        List<Phone> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from Phone where sid=? and is_delete=1");
            ps.setInt(1,sid);
            rSet = ps.executeQuery();
            String relation ;
            String tel;
            int id =0;
            Phone phone =null;
            while (rSet.next()){
               relation = rSet.getString("relation");
                tel = rSet.getString("tel");
                id = rSet.getInt("id");
                phone = new Phone(id,relation, tel, sid);
                list.add(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(rSet,ps,conn);
        }
        return list;
    }

    @Override
    public Phone getPhoneBYid(Integer id) {
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rSet =null;
        Phone phone =null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from Phone where id=? and is_delete=1");
            ps.setInt(1,id);
            rSet = ps.executeQuery();
            String relation ;
            String tel;

            if (rSet.next()){
                relation = rSet.getString("relation");
                tel = rSet.getString("tel");
                phone = new Phone(id,relation, tel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(rSet,ps,conn);
        }
        return phone;

    }

    @Override
    public Integer upDatePhone(Integer id,String relarion,String tel) {
        Connection conn = null;
        PreparedStatement ps =null;
        int rSet =0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("update Phone set relation=?,tel=? where id=? ");
            ps.setString(1,relarion);
            ps.setString(2,tel);
            ps.setInt(3,id);
            rSet = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(ps,conn);
        }
        return rSet;
    }

    @Override
    public Integer deletePhoneById(Integer id) {
        Connection conn = null;
        PreparedStatement ps =null;
        int rSet =0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("update Phone set is_delete=0 where id=? ");
            ps.setInt(1,id);
            rSet = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(ps,conn);
        }
        return rSet;
    }


    @Override
    public Integer addPhone(Phone phone) {
        Connection conn = null;
        PreparedStatement ps =null;
        int rSet =0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("insert into Phone (relation,tel,sid) values (?,?,?)");
            ps.setString(1,phone.getRelation());
            ps.setString(2,phone.getTel());
            ps.setInt(3,phone.getSid());
            rSet = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(ps,conn);
        }
        return rSet;
    }

    @Override
    public Integer countPhoneByRelation(String relation) {
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rSet =null;
        int count =0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select count(*) from Phone where relation=? ");
            ps.setString(1,relation);
            rSet = ps.executeQuery();
            if(rSet.next()){
               count = rSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(rSet,ps,conn);
        }
        return count;
    }
}
