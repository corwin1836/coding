package com.company;

public class Hanger {
    private static int store;
    Airplane [] planeList = new Airplane[100];

    public void fillHanger() {
        while (store != 100) {
            // create new airplane and store it in planeList
            // iterate store counter
            for (int i =0; i < planeList.length; i++) {
                Airplane x = new Airplane();
                planeList[i] = x;
            }
            store++;
        }
    }
}
