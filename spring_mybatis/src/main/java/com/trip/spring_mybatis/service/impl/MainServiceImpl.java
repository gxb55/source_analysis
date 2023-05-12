package com.trip.spring_mybatis.service.impl;

import com.trip.spring_mybatis.config.annotation.Clog;
import com.trip.spring_mybatis.config.result.BaseResult;
import com.trip.spring_mybatis.config.result.ResultEnum;
import com.trip.spring_mybatis.config.result.ResultUtil;
import com.trip.spring_mybatis.dao.CustomerSaleDao;
import com.trip.spring_mybatis.dao.TblHotLineDao;
import com.trip.spring_mybatis.pojo.dto.CustomerSale;
import com.trip.spring_mybatis.pojo.dto.TblHotLine;
import com.trip.spring_mybatis.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 */
@Service
public class MainServiceImpl implements MainService {
    @Autowired
    private TblHotLineDao tblHotLineDao;
    @Autowired
    private CustomerSaleDao customerSaleDao;


    @Override
    @Clog
    @Transactional
    public BaseResult<TblHotLine> queryHotLineById(Integer id) {
        TblHotLine tblHotLine = tblHotLineDao.findById(id);
        tblHotLine = tblHotLineDao.findById(id);
        return ResultUtil.buildResult(ResultEnum.SUCCESS, tblHotLine);
    }

    @Transactional
    @Override
    public BaseResult<CustomerSale> queryCustomerSaleById(Integer id) {
        // 查询数据库
        CustomerSale customerSale = customerSaleDao.findById(id);
        return ResultUtil.buildResult(ResultEnum.SUCCESS, customerSale);
    }

    public MainServiceImpl() {
       /* System.out.println(this);
        System.out.println("初始化了");*/
    }
}
