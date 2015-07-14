package com.techsen.tsweb.core.util.sql;

import static com.techsen.tsweb.core.util.Const.EMPTY_STRING;
import static com.techsen.tsweb.core.util.Const.SPACE;
import static com.techsen.tsweb.core.util.ValidUtil.isValid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pager<T> implements Sql {
	private List<Phrase> phrases;
	private List<String> orderBys;
    private int pagesize = 10;
    private int pagecode = 1;
	
    private List<T> entities;
    private int totalsize;
    
	public Pager(){}
	
	public Pager(Relation[] relations, String[] conditions, Operator[] operators, String[] values){
		List<Phrase> phrases = new ArrayList<Phrase>();
		if(isValid(conditions)){
			for(int i=0; i<conditions.length; i++){
				Phrase phrase = new Phrase(relations[i], conditions[i], operators[i], values[i]);
				phrases.add(phrase);
			}
		}
		this.phrases = phrases;
	}
	
	public Pager(List<Phrase> phrases){
		this.phrases = phrases;
	}

    public String getSql(){
        String retStr = EMPTY_STRING;
        StringBuilder sb = new StringBuilder();
        if(isValid(phrases)){
            sb.append(phrases.get(0));
            for(int i=1; i<phrases.size(); i++){
                sb.append(SPACE).append(phrases.get(i));
            }
        }
        if(isValid(orderBys)){
            sb.append(" order by ").append(orderBys.get(0));
            for(int i=1; i<orderBys.size(); i++){
                sb.append(", ").append(orderBys.get(i));
            }
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
    
	public Pager<T> appendPhrases(Collection<Phrase> phrases){
		if(this.phrases == null){
			this.phrases = new ArrayList<Phrase>();
		}
		if(isValid(phrases)){
			this.phrases.addAll(phrases);
		}
		return this;
	}
	
	public Pager<T> appendPhrases(Phrase ... phrases){
		if(this.phrases == null){
			this.phrases = new ArrayList<Phrase>();
		}
		for(Phrase phrase : phrases){
			this.phrases.add(phrase);
		}
		return this;
	}
	
	public Pager<T> appendOrderBys(Collection<String> orderBys){
		if(this.orderBys == null){
			this.orderBys = new ArrayList<String>();
		}
		if(isValid(orderBys)){
			this.orderBys.addAll(orderBys);
		}
		return this;
	}
	
	public Pager<T> appendOrderBys(String ... orderBys){
		if(this.orderBys == null){
			this.orderBys = new ArrayList<String>();
		}
		for(String orderBy : orderBys){
			this.orderBys.add(orderBy);
		}
		return this;
	}
	
	public String toString(){
		return this.getSql();
	}

	public List<Phrase> getPhrases() {
		return phrases;
	}

	public Pager<T> setPhrases(List<Phrase> phrases) {
		this.phrases = phrases;
		return this;
	}
	
	public List<String> getOrderBys() {
		return orderBys;
	}

	public Pager<T> setOrderBys(List<String> orderBys) {
		this.orderBys = orderBys;
		return this;
	}
	
	public int getPagesize() {
        return pagesize;
    }

    public Pager<T> setPagesize(int pagesize) {
        this.pagesize = pagesize;
        return this;
    }

    public int getPagecode() {
        return pagecode;
    }

    public Pager<T> setPagecode(int pagecode) {
        this.pagecode = pagecode;
        return this;
    }

    public List<T> getEntities() {
        return entities;
    }

    public Pager<T> setEntities(List<T> entities) {
        this.entities = entities;
        return this;
    }

    public int getTotalsize() {
        return totalsize;
    }

    public Pager<T> setTotalsize(int totalsize) {
        this.totalsize = totalsize;
        return this;
    }

    public static void main(String args[]){
		Pager sentence = new Pager();
		sentence.appendPhrases(new Phrase(Relation.and, "def_code", Operator.gt, "100"))
				.appendPhrases(new Phrase(Relation.and, "def_code", Operator.lt, "500"))
				.appendOrderBys("def_type")
				.appendOrderBys("def_code desc")
				.setPagecode(5)
		        .setPagesize(10);
		System.out.println(sentence.getSql());
	}
}
