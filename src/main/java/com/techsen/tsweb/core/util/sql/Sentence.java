package com.techsen.tsweb.core.util.sql;

import static com.techsen.tsweb.core.util.Const.EMPTY_STRING;
import static com.techsen.tsweb.core.util.Const.SPACE;
import static com.techsen.tsweb.core.util.ValidUtil.isValid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Sentence implements Sql {
	private List<Phrase> phrases;
	private List<String> orderBys;
    private int pagesize = -1;
    private int pagecode = 1;
	
	public Sentence(){}
	
	public Sentence(Relation[] relations, String[] conditions, Operator[] operators, String[] values){
		List<Phrase> phrases = new ArrayList<Phrase>();
		if(isValid(conditions)){
			for(int i=0; i<conditions.length; i++){
				Phrase phrase = new Phrase(relations[i], conditions[i], operators[i], values[i]);
				phrases.add(phrase);
			}
		}
		this.phrases = phrases;
	}
	
	public Sentence(List<Phrase> phrases){
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
    
	public Sentence appendPhrases(Collection<Phrase> phrases){
		if(this.phrases == null){
			this.phrases = new ArrayList<Phrase>();
		}
		if(isValid(phrases)){
			this.phrases.addAll(phrases);
		}
		return this;
	}
	
	public Sentence appendPhrases(Phrase ... phrases){
		if(this.phrases == null){
			this.phrases = new ArrayList<Phrase>();
		}
		for(Phrase phrase : phrases){
			this.phrases.add(phrase);
		}
		return this;
	}
	
	public Sentence appendOrderBys(Collection<String> orderBys){
		if(this.orderBys == null){
			this.orderBys = new ArrayList<String>();
		}
		if(isValid(orderBys)){
			this.orderBys.addAll(orderBys);
		}
		return this;
	}
	
	public Sentence appendOrderBys(String ... orderBys){
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

	public Sentence setPhrases(List<Phrase> phrases) {
		this.phrases = phrases;
		return this;
	}
	
	public List<String> getOrderBys() {
		return orderBys;
	}

	public Sentence setOrderBys(List<String> orderBys) {
		this.orderBys = orderBys;
		return this;
	}
	
	public int getPagesize() {
        return pagesize;
    }

    public Sentence setPagesize(int pagesize) {
        this.pagesize = pagesize;
        return this;
    }

    public int getPagecode() {
        return pagecode;
    }

    public Sentence setPagecode(int pagecode) {
        this.pagecode = pagecode;
        return this;
    }

    public static void main(String args[]){
		Sentence sentence = new Sentence();
		sentence.appendPhrases(new Phrase(Relation.and, "def_code", Operator.gt, "100"))
				.appendPhrases(new Phrase(Relation.and, "def_code", Operator.lt, "500"))
				.appendOrderBys("def_type")
				.appendOrderBys("def_code desc")
				.setPagecode(5)
		        .setPagesize(10);
		System.out.println(sentence.getSql());
	}
}
