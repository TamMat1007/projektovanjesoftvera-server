/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.util.Objects;

/**
 *
 * @author Tamara
 */
public class Operator {
    Long operatorID;
    String operatorName;
    String operatorLastname;
    String username;
    String password;

    public Operator() {
    }

    public Operator(Long operatorID, String operatorName, String operatorLastname, String username, String password) {
        this.operatorID = operatorID;
        this.operatorName = operatorName;
        this.operatorLastname = operatorLastname;
        this.username = username;
        this.password = password;
    }

    public Long getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(Long operatorID) {
        this.operatorID = operatorID;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorLastname() {
        return operatorLastname;
    }

    public void setOperatorLastname(String operatorLastname) {
        this.operatorLastname = operatorLastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  operatorName + " " + operatorLastname ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.operatorID);
        hash = 89 * hash + Objects.hashCode(this.operatorName);
        hash = 89 * hash + Objects.hashCode(this.operatorLastname);
        hash = 89 * hash + Objects.hashCode(this.username);
        hash = 89 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Operator other = (Operator) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    
    
    
}
