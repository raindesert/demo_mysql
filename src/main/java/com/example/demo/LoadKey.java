package com.example.demo;

import java.io.Serializable;

public class LoadKey implements Serializable {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
