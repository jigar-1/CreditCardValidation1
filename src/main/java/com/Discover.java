package com;

public class Discover extends Card {
	String card_num;
    public Discover(String card_number) {
        super(card_number);
        this.card_num = card_number;
    }

    public String getCardNum() {
		return this.card_num;
	}
    
    @Override
    String validateCardType(String card_number) {
    	if(card_number.equals("") || card_number.contains(" ")){
            return "Invalid";
        }
        try {
            long number = Double.valueOf(card_number).longValue();
            String value = Long.toString(number);
            if(value.length() == 16) {
	            if (value.substring(0, 4).equals("6011")) {
	                return "Discover";
	            }
            }
            else {
            	return "Card Number length inaccurate";
            }
        }catch(Exception e){
            return "Card Number with special characters";
        }
        return "Invalid";
    }
}
