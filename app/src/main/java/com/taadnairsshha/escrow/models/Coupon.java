package com.taadnairsshha.escrow.models;

import android.icu.math.BigDecimal;

import com.google.auto.value.AutoValue;
import com.taadnairsshha.escrow.enums.CouponType;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.util.List;

/**
 * Created by adarsh on 12/26/16.
 */
/*
 * This class implements a coupon object.
 */
@AutoValue
public abstract class Coupon {
    /* This method returns the type of coupon. */
    public abstract CouponType getCouponType();

    /* This method returns the coupon code for the coupon. */
    public abstract String getCouponCode();

    /*
     * This method returns the website for which the coupon is.
     */
    public abstract Website getWebsite();


    /* This method returns the list of accounts the coupons is applicable to. */
    public abstract List<Account> getAccounts();

    /* This method gets the expiry date for the coupon. */
    public abstract LocalDate getExpiryDate();

    /* This method gets the maximum discount for the coupon. */
    public abstract BigDecimal getMaximumDiscount();

    /* This method returns the maximum cashback for the coupon. */
    public abstract BigDecimal getMaximumCashback();

    /* This method returns the discount percentage for the coupon. */
    public abstract BigDecimal getDiscountPercentage();

    /* This method returns the cashback percentage for the coupon. */
    public abstract BigDecimal getCashbackPercentage();

    /* This method returns the minimum purchase amount for the coupon to be applied. */
    public abstract BigDecimal getMinimumPurchaseAmount();


    public static Builder builder() {
        return new AutoValue_Coupon.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setCouponType(CouponType newCouponType);

        public abstract Builder setCouponCode(String newCouponCode);

        public abstract Builder setWebsite(Website newWebsite);

        public abstract Builder setAccounts(List<Account> newAccounts);

        public abstract Builder setExpiryDate(LocalDate newExpiryDate);

        public abstract Builder setMaximumDiscount(BigDecimal newMaximumDiscount);

        public abstract Builder setMaximumCashback(BigDecimal newMaximumCashback);

        public abstract Builder setDiscountPercentage(BigDecimal newDiscountPercentage);

        public abstract Builder setCashbackPercentage(BigDecimal newCashbackPercentage);

        public abstract Builder setMinimumPurchaseAmount(BigDecimal newMinimumPurchaseAmount);

        public abstract Coupon build();
    }
}
