package com.techsen.tsweb.core.util.sql;

import static com.techsen.tsweb.core.util.Const.EMPTY_STRING;

public class Pager implements Sql {
    private Sentence sentence;
    private int pagesize = -1;
    private int pagecode = 1;

    public Pager() {
    }

    public Pager(Sentence sentence) {
        this.sentence = sentence;
    }

    public String getSql() {
        String retStr = EMPTY_STRING;
        StringBuilder sb = new StringBuilder();
        if (this.sentence != null) {
            sb.append(this.sentence.getSql());
        }
        if (this.pagesize >= 0) {
            if (this.pagesize == 0) {
                this.pagesize = 1;
            }
            if (this.pagecode <= 0) {
                this.pagecode = 1;
            }
            sb.append(" limit ").append((pagecode - 1) * pagesize).append(", ").append(pagesize);
        }
        retStr = sb.toString().trim();
        return retStr;
    }

    public Sentence getSentence() {
        return sentence;
    }

    public Pager setSentence(Sentence sentence) {
        this.sentence = sentence;
        return this;
    }

    public int getPagesize() {
        return pagesize;
    }

    public Pager setPagesize(int pagesize) {
        this.pagesize = pagesize;
        return this;
    }

    public int getPagecode() {
        return pagecode;
    }

    public Pager setPagecode(int pagecode) {
        this.pagecode = pagecode;
        return this;
    }

}
