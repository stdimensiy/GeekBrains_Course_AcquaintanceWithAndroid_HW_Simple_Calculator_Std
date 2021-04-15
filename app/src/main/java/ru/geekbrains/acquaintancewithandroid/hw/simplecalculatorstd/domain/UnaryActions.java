package ru.geekbrains.acquaintancewithandroid.hw.simplecalculatorstd.domain;

public enum UnaryActions {
    NEG("negate(", ")"),
    SQR("sqr(", ")"),
    SRE("\u221A(", ")"),
    REV("1/(", ")");

    private final String pref;
    private final String suff;

    UnaryActions(String preff, String suff) {
        this.pref = preff;
        this.suff = suff;
    }

    public String getPref() {
        return pref;
    }

    public String getSuff() {
        return suff;
    }
}
