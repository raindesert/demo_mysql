package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name="t_user")
public class TUser {
    @EmbeddedId
    LoadKey loadKey;

    public LoadKey getLoadKey() {
        return loadKey;
    }

    public void setLoadKey(LoadKey loadKey) {
        this.loadKey = loadKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="password")
    private String password;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Column(name="job")
    private String job;
}
