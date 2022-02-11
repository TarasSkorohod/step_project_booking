package main.java.objects;

public enum Gender {
    UNKNOWN("-", "-");

    private final String firstname;
    private final String prefix;

    public String getFirstname() {
        return firstname;
    }

    public String getPrefix() {
        return prefix;
    }

    Gender(String firstname) {
        this.firstname = firstname;
        this.prefix = getPrefix();
    }

    Gender(String firstname, String prefix) {
        this.firstname = firstname;
        this.prefix = prefix;
    }


}
