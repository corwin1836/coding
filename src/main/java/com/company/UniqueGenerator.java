package com.company;

public class UniqueGenerator {

    public String charGenerator(String starter) {
        String backEnd = starter.substring(4);
        String frontEnd = starter.substring(0, 3);
        int newlyMintedInt = Integer.parseInt(backEnd);
        if (newlyMintedInt < 999) {
            newlyMintedInt++;
            return frontEnd + '-' + newlyMintedInt;
        } else {
            backEnd = "111";
            char firstChar = frontEnd.charAt(0);
            char secondChar = frontEnd.charAt(1);
            char thirdChar = frontEnd.charAt(2);
            if (thirdChar == 'Z') {
                thirdChar = 'A';
                if (secondChar == 'Z') {
                    secondChar = 'A';
                    if (firstChar == 'Z') {
                        throw new IllegalStateException("You suck you ran my simulator too long. Get a life.");
                    } else {
                        firstChar += 1;
                    }
                } else {
                    secondChar += 1;
                }
            } else {
                thirdChar += 1;
            }
            return "" + firstChar + secondChar + thirdChar +'-'+ backEnd;
        }
    }
}
