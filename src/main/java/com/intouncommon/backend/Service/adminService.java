package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.*;

public interface adminService {
    String madeSecreteKey(String username, String password);
    boolean checkTokenValidity(String token) throws Exception;
    admin addAdmin(admin admin);
    String changeAdmin(String oldUsername,String username,String oldPassword,String password);
    String getLoginStatus();
    String setLoginStatus();
    int addLogin(login login);
    login getLogin();



}
