package com.techsen.tsweb.core.util.sql;

import static com.techsen.tsweb.core.util.Const.EMPTY_STRING;
import static com.techsen.tsweb.core.util.Const.SPACE;

public class Phrase implements Sql {
	private Relation relation;
	private String condition;
	private Operator operator;
	private String value;
	
	public Phrase(){}
	
	public Phrase(Relation relation, String condition, Operator operator, String value){
		this.relation = relation;
		this.condition = condition;
		this.operator = operator;
		this.value = value;
	}

	public String getSql() {
		String retStr = EMPTY_STRING;
		if(condition != null && !EMPTY_STRING.equals(condition)){
		    StringBuilder sb = new StringBuilder();
			if(relation != null){
				sb.append(relation).append(SPACE);
			}
			sb.append(condition).append(SPACE).append(operator).append(" '");
			if(operator.equals(Operator.like) || operator.equals(Operator.notlike)){
				sb.append("%").append(value.replace("'", "''")).append("%'");
			} else {
				sb.append(value.replace("'", "''")).append("'");
			}
			retStr = sb.toString();
		}
		return retStr;
	}
	
	public String toString(){
		return getSql();
	}
	
	public Relation getRelation() {
		return relation;
	}
	public void setRelation(Relation relation) {
		this.relation = relation;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public static void main(String args[]){
		Phrase phrase = new Phrase(Relation.and, "def_code", Operator.notlike, "abc'de");
		System.out.println(phrase);
	}
}
