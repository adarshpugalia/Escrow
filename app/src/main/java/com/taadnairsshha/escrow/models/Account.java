package com.taadnairsshha.escrow.models;

import android.icu.math.BigDecimal;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

/**
 * Created by adarsh on 12/26/16.
 */
/*
 * This class implements an account object.
 * TODO: Add account type to the class.
 */
@AutoValue
public abstract class Account {
    /*
     * This method returns the website the account is for.
     * TODO: Change it to enum.
     */
    public abstract Website getWebsite();

    /*
     * This method returns the email associated with the account.
     */
    @Nullable
    public abstract String getEmail();

    /*
     * This method returns the phone number associated with the account.
     * TODO: Change this to a phone number type.
     */
    @Nullable
    public abstract String getPhoneNumber();

    /*
     * This method returns the password associated with the account.
     */
    @Nullable
    public abstract String getPassword();


    /*
     * This method returns the wallet balance for this account.
     */
    public abstract BigDecimal getWalletBalance();

    public static Builder builder() {
        return new AutoValue_Account.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setWebsite(Website newWebsite);

        public abstract Builder setEmail(String newEmail);

        public abstract Builder setPhoneNumber(String newPhoneNumber);

        public abstract Builder setPassword(String newPassword);

        public abstract Builder setWalletBalance(BigDecimal newWalletBalance);

        public abstract Account build();
    }
}
