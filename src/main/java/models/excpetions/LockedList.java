package models.excpetions;

public class LockedList extends Exception {

    public LockedList() {
        super("try to attempt to access a completed list");
    }
}
