package com.intouncommon.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class login {
    
    @Id
    private int id=1;
    private boolean loginStats = true;
    private int loginCount = 0;

    public login() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLoginStats() {
        return loginStats;
    }

    public void setLoginStats(boolean loginStats) {
        this.loginStats = loginStats;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }
}
