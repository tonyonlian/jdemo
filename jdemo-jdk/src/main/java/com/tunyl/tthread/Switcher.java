package com.tunyl.tthread;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 演示内存可见性,使用volatile 代替重的synchronzied
 * @author create by Tunyl on 2019/9/18
 * @version 1.0
 */
public class Switcher {
    private volatile boolean on;
    public boolean isOn(){

        return on;
    }
    public void setOn(boolean on ){
        this.on = on ;
    }

}
