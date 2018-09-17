package com.example.microservice.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="t_user")
public class User implements Serializable {
    private static final long serialVersionUID = -7394614494734699602L;
    private Integer id;
    private String loginAccount;
    private String loginPwd;
    private String userName;
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "login_account")
    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }
    @Column(name = "login_pwd")
    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
