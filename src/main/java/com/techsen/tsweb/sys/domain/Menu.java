package com.techsen.tsweb.sys.domain;

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
     * 转换为二进制位权限对象
     */
    public BinaryPermission binaryPermission() {
        return new BinaryPermission(this.resourceGroup, 1 << this.resourceIndex);
    }

    @Override
    public ResourceType getResourceType() {
        return ResourceType.Menu;
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

    /*@Override
    public String getResourceGroup() {
        return this.resourceGroup;
    }*/

    public Menu setResourceGroup(String authGroup) {
        this.resourceGroup = authGroup;
        return this;
    }

    public int getAuthIndex() {
        return resourceIndex;
    }

    public Menu setAuthIndex(int authIndex) {
        this.resourceIndex = authIndex;
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
