package com.allen.stone.dto;

import java.io.Serializable;

/** mq 案例
 * @Author Allen
 * @Description
 * @Date 2018/10/9 23:03
 **/
public class BookDto implements Serializable {

    private static final long serialVersionUID = 3002892601816143133L;

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
