package com.trip.spring_mybatis.dao;

import com.trip.spring_mybatis.pojo.dto.TblHotLine;
import org.springframework.stereotype.Repository;

@Repository
public interface TblHotLineDao {
    TblHotLine findById(Integer id);
}
