package models.excpetions;

public class InvalidTime extends Exception {
    String exString;

    public InvalidTime(String stime) {
        exString = stime;
    }

    public String getMessage() {
        return exString;
    }

}
