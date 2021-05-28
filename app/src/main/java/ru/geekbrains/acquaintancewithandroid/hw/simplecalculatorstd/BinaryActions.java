package ru.geekbrains.acquaintancewithandroid.hw.simplecalculatorstd;

public enum BinaryActions {
    ADD (" + "),
    SUB (" - "),
    MUL (" x "),
    DIV (" / ");

    private String title;

    BinaryActions(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
