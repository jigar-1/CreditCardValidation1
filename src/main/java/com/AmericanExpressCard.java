package com;

public class AmericanExpressCard extends Card {
	String card_num;
    public AmericanExpressCard(String card_number) {
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
            if(value.length() == 15) {
	            if ((value.charAt(0) == '3') && (value.charAt(1) == '4' || value.charAt(1) == '7')) {
	                return "AmericanExpress";
	            }
            }
            else {
            	return "Card Number length inaccurate";
            }
        }catch(Exception e){
            return "Invalid";
        }
        return "Invalid";
    }
}