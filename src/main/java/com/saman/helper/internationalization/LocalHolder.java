package com.saman.helper.internationalization;

import java.util.Locale;

public enum LocalHolder {

    IRAN("FA", "IR"),
    USA("en", "US");

    Locale local;

    LocalHolder(String lang, String country) {
        this.local = new Locale(lang, country);
    }

    public Locale getLocal() {
        return local;
    }
}
