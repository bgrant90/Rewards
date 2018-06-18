package com.gettingdressed.enums;

public enum RuleValues {
	SHIRT_ON(new Integer(4)),
	HEAD_WEAR(new Integer(2)),
	PJS_OFF(new Integer(8)),
	FOOT_WEAR(new Integer(1)),
	PANTS_ON(new Integer(6)),
	SOCKS_ON(new Integer(3)),
	LEAVING_HOUSE(new Integer(7));
	
	private Integer ruleValue;
	private RuleValues(Integer value){
		ruleValue = value;
	}
	
	public Integer toInteger() {
		return ruleValue;
	}
	

}
