package com.getfood.courier.core.domain.formatter;

import com.getfood.courier.core.domain.formatter.ZipCodeFormatter;

public class BrazilFormatter implements ZipCodeFormatter {

    private static final Integer ZIP_CODE_SIZE = 8;

    private StringBuilder zipCode;

    public BrazilFormatter(String zipCode) {
        this.zipCode = new StringBuilder(zipCode);
    }

    @Override
    public String getFormatted() {
        if (this.zipCode.length() != ZIP_CODE_SIZE) {
           throw new IllegalArgumentException("Zip code size is small than default: " + ZIP_CODE_SIZE);
        }

        return this.zipCode.insert(5, "-").toString();
    }
}
