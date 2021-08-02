package com.trip.spring_mybatis.pojo.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TblHotLine {
    private Integer id;
    private String fromCity;
    private String toCity;
    private Integer hotLevel;
    private Timestamp createTime;
    private Timestamp datachangeLasttime;
}
