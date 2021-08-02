package com.trip.spring_mybatis.controller;

import com.trip.spring_mybatis.config.result.BaseResult;
import com.trip.spring_mybatis.pojo.dto.CustomerSale;
import com.trip.spring_mybatis.pojo.dto.TblHotLine;
import com.trip.spring_mybatis.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "findHotLineById", method = RequestMethod.GET)
    public BaseResult<TblHotLine> queryHotLineById(Integer id) {

        return mainService.queryHotLineById(id);

    }

    @RequestMapping(value = "findCustomerSaleById", method = RequestMethod.GET)
    public BaseResult<CustomerSale> queryCustomerSaleById(Integer id) {
        return mainService.queryCustomerSaleById(id);
    }
}
