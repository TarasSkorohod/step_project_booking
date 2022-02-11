package main.java.objects;

public enum Airports {
    ZHULIANY("Жуляны");

    private final String firstname;

    Airports(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }
}
