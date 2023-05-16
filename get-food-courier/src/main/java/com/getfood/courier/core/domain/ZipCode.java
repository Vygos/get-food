package com.getfood.courier.core.domain;

import com.getfood.courier.core.domain.formatter.BrazilFormatter;
import com.getfood.courier.core.domain.formatter.Country;

public class ZipCode {
    private Country country;
    private String zipCode;

    public ZipCode(String zipCode, String country) {
        this.zipCode = zipCode;
        this.country = Country.getInstance(country);
    }

    public String getFormattedByCountry() {
        switch (this.country) {
            case BRAZIL:
                return new BrazilFormatter(this.zipCode).getFormatted();
            default:
                return this.zipCode;
        }
    }

    public String getZipCode() {
        return this.zipCode;
    }

}
