package com.techsen.tsweb.core.util;

import org.apache.shiro.SecurityUtils;

public class SubjectUtil {
    
    /**
     * 获取登录用户的唯一标识<br/>
     * 在LocalRealm中用户的唯一标识为用户的id
     */
    public static String getPrincipal() {
        return (String) SecurityUtils.getSubject().getPrincipal();
    }
    
}
