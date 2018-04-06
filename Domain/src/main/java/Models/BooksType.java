package Models;

public enum BooksType {
    SCIENCE_FICTION("Science Fiction"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    TRAVEL("Travel"),
    SCIENCE("Science"),
    HISTORY("History"),
    FANTASY("Fantasy");

    private String descritpion;

    BooksType(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getDescritpion() {
        return descritpion;
    }
}
