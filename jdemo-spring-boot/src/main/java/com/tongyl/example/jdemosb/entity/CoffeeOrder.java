package com.tongyl.example.jdemosb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Created by Tunyl on 2019/8/27.
 * @version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoffeeOrder {
    private Long id;
    private String customer;
    private List<Coffee> items;
    private Integer state;
    private Date createTime;
    private Date updateTime;
}
