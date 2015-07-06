package com.techsen.tsweb.sys.domain;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;

public class Menu extends BaseEntity<Menu> {

    private static final long serialVersionUID = -7771118378089691104L;

    private String name;
    private String label;
    private String path;
    private MenuType type = MenuType.MENU;
    private String auth;

    private Menu parent;
    private List<Menu> subMenus;

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

    public MenuType getType() {
        return type;
    }

    public Menu setType(MenuType type) {
        this.type = type;
        return this;
    }

    public String getAuth() {
        return auth;
    }

    public Menu setAuth(String auth) {
        this.auth = auth;
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
