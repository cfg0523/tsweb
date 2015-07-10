package com.techsen.tsweb.sys.auth;

public interface Principal {

    PrincipalType getPrincipalType();
    String getPrincipalId();
    
}
