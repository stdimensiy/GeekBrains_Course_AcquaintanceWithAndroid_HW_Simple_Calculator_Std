package ru.geekbrains.acquaintancewithandroid.hw.simplecalculatorstd.domain;

public enum BinaryActions {
    ADD (" + "),
    SUB (" - "),
    MUL (" x "),
    DIV (" / ");

    private final String title;

    BinaryActions(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
