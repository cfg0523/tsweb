package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.sys.auth.BinaryPermission;
import com.techsen.tsweb.sys.auth.PrincipalType;
import com.techsen.tsweb.sys.auth.ResourceType;

public class Auth extends BaseEntity<Auth> {

    private static final long serialVersionUID = 1651997840821737066L;

    private PrincipalType principalType;
    private String principalId;
    private ResourceType resourceType;
    private String resourceGroup;
    private int code;

    /**
     * 转换为二进制位权限对象
     */
    public BinaryPermission binaryPermission() {
        return new BinaryPermission(this.resourceType.toString(),
                this.resourceGroup, this.code);
    }

    public PrincipalType getPrincipalType() {
        return principalType;
    }

    public Auth setPrincipalType(PrincipalType principalType) {
        this.principalType = principalType;
        return this;
    }

    public String getPrincipalId() {
        return principalId;
    }

    public Auth setPrincipalId(String principalId) {
        this.principalId = principalId;
        return this;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public Auth setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    public Auth setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Auth setCode(int code) {
        this.code = code;
        return this;
    }

}
