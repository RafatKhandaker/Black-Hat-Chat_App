package com.example.reddragon.blackjackapp.API;

/**
 * Created by RedDragon on 10/27/16.
 */

public class token {

    public static final String Key = "AIzaSyDDTBI_GRLf1LS_F_9G5hcVmA_S_jURlS0";

    public static String getKey(){
        return Key;
    }

    public static String getRandomVideoCode(){
        String[] code = {
                "FYUjvbaj4bo&list=PLtoSlPOzD0YXoPud60x55mg77gX2p9nTl&index=2",
                "p_crXt_xJQQ&index=4&list=PLtoSlPOzD0YXoPud60x55mg77gX2p9nTl",
                "SV8eG32vyc0&index=6&list=PLtoSlPOzD0YXoPud60x55mg77gX2p9nTl",
                "ybz59LbbACQ&index=8&list=PLtoSlPOzD0YXoPud60x55mg77gX2p9nTl",
                "kuuPQBniKww&index=13&list=PLtoSlPOzD0YXoPud60x55mg77gX2p9nTl",
                "vtA335Nosww&index=18&list=PLtoSlPOzD0YXoPud60x55mg77gX2p9nTl",
                "Z40_oAnK-fk&list=PLtoSlPOzD0YXoPud60x55mg77gX2p9nTl&index=23"
        };

        return code[0];
    }
}
