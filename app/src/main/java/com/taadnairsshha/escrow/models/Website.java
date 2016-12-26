package com.taadnairsshha.escrow.models;

import com.google.auto.value.AutoValue;
import com.taadnairsshha.escrow.enums.WebsiteType;

/**
 * Created by adarsh on 12/26/16.
 */
/*
 * This class implements the objects for a website.
 */
@AutoValue
public abstract class Website {
    /* This method returns the name of the website. */
    public abstract String getName();

    /* This method returns the website type. */
    public abstract WebsiteType getWebsiteType();

    /* This method checks if the website has its own wallet. */
    public abstract boolean hasWallet();

    public static Website create(String newName, WebsiteType newWebsiteType, boolean hasWallet) {
        return new AutoValue_Website(newName, newWebsiteType, hasWallet);
    }


}
