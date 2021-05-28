package ru.geekbrains.acquaintancewithandroid.hw.simplecalculatorstd;

public enum UnaryActions {
    NEG("negate(", ")"),
    SQR("sqr(", ")"),
    SRE("\u221A(", ")"),
    REV("1/(", ")");

    private String pref;
    private String suff;

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
