/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.medvedev.soap;

import java.math.BigDecimal;

/**
 *
 * @author emedvedev
 */
public class ResponcePojo {
    
    private String name;
    private BigDecimal area;
    
    public ResponcePojo(String name, BigDecimal area) {
        this.name = name;
        this.area = area;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
