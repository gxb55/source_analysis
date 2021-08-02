package com.trip.spring_mybatis.service;

import com.trip.spring_mybatis.config.result.BaseResult;
import com.trip.spring_mybatis.pojo.dto.CustomerSale;
import com.trip.spring_mybatis.pojo.dto.TblHotLine;

public interface MainService {
    BaseResult<TblHotLine> queryHotLineById(Integer id);

    BaseResult<CustomerSale> queryCustomerSaleById(Integer id);
}
