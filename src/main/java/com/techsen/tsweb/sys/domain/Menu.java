package com.techsen.tsweb.sys.domain;

import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.sys.auth.BinaryPermission;
import com.techsen.tsweb.sys.auth.Resource;
import com.techsen.tsweb.sys.auth.ResourceType;

public class Menu extends BaseEntity<Menu> implements Resource {

    private static final long serialVersionUID = -7771118378089691104L;

    private String name;
    private String label;
    private String path;
    private String resourceGroup;
    private int resourceIndex;
    
    private Menu parent;
    private List<Menu> subMenus;

    /**
     * 根据resourceIndex计算出授权码
     */
    @Override
    public int getAuthCode() {
        return 1 << this.resourceIndex;
    }
    
    /**
     * 转换为二进制位权限对象
     */
    public BinaryPermission binaryPermission() {
        return new BinaryPermission(this.getResourceType().toString(),
                this.resourceGroup, this.getAuthCode());
    }

    @Override
    public ResourceType getResourceType() {
        return ResourceType.menu;
    }

    @Override
    public String getResourceGroup() {
        return this.resourceGroup;
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Menu setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Menu setPath(String path) {
        this.path = path;
        return this;
    }

    /*
     * @Override public String getResourceGroup() { return this.resourceGroup; }
     */

    public Menu setResourceGroup(String authGroup) {
        this.resourceGroup = authGroup;
        return this;
    }

    public int getResourceIndex() {
        return resourceIndex;
    }

    public Menu setResourceIndex(int resourceIndex) {
        if (resourceIndex < 0 || resourceIndex > 30) {
            throwRuntimeException("resourceIndex的值必须在0 ~ 30之间");
        }
        this.resourceIndex = resourceIndex;
        return this;
    }

    public Menu getParent() {
        return parent;
    }

    public Menu setParent(Menu parent) {
        this.parent = parent;
        return this;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public Menu setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
        return this;
    }

}
