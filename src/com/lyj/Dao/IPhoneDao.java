package com.lyj.Dao;

import com.lyj.entity.Phone;

import java.util.List;

public interface IPhoneDao {
    List<Phone> getPhoneBySid(Integer sid);
    Phone getPhoneBYid(Integer id);
    Integer upDatePhone(Integer id,String relarion,String tel);
    Integer deletePhoneById(Integer id);
    Integer addPhone(Phone phone);
    Integer countPhoneByRelation(String relation);
}
