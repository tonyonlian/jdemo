package com.tongyl.example.jdemoenummybaits.emum;

/**
 *
 * 计算机状态枚举
 * @author Created by Tunyl on 2019/8/30.
 * @version 1.0
 */
public enum ComputerState implements BaseCodeEnum{
    OPEN(10),CLOSE(11),OFF_LINE(12),FAULT(200),UNKNOWN(255);

    private int code;

    private ComputerState(int code) {
        this.code = code;
    }


    @Override
    public int getCode() {
        return this.code;
    }
}
