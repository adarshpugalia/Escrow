package com.taadnairsshha.escrow.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adarsh on 12/26/16.
 */

public enum WebsiteType {
    WALLET("Wallet"),
    TRAVEL("Travel"),
    CABS("Cabs"),
    MOVIES("Movies"),
    FOOD("Food");

    private String name;

    WebsiteType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getWebsiteTypeNames() {
        List<String> websiteTypes = new ArrayList<>();
        for(WebsiteType websiteType: WebsiteType.values()) {
            websiteTypes.add(websiteType.getName());
        }

        return websiteTypes;
    }

}
