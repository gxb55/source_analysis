package com.trip.spring_mybatis.dao;

import com.trip.spring_mybatis.pojo.dto.CustomerSale;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSaleDao {
    CustomerSale findById(Integer id);
}
