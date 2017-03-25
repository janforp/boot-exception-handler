package com.janita.exceptionHandler.bean;

import java.io.Serializable;

/**
 * Created by Janita on 2017-03-25 09:59
 */
public class User implements Serializable {

    private Long userId;
    private String name;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
