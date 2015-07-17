package com.techsen.tsweb.sys.vo;

public class Node {
    private String id;
    private String pid;
    private String name;
    private boolean open = true;
    private boolean checked;

    public String getId() {
        return id;
    }

    public Node setId(String id) {
        this.id = id;
        return this;
    }

    public String getPid() {
        return pid;
    }

    public Node setPid(String pid) {
        this.pid = pid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Node setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isOpen() {
        return open;
    }

    public Node setOpen(boolean open) {
        this.open = open;
        return this;
    }

    public boolean isChecked() {
        return checked;
    }

    public Node setChecked(boolean checked) {
        this.checked = checked;
        return this;
    }

}
