package com;

public class Visa extends Card {
	String card_num;
    public Visa(String card_number) {
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
            if(value.length() == 13 || value.length() == 16) {
	            if ((value.charAt(0) == '4') ) {
	                return "Visa";
	            }
	            else {
	            	return "Invalid";
	            }
            }
            else {
            	return "Card Number length inaccurate";
            }
        }catch(Exception e){
            return "Card Number with special characters";
        }
    }
}
