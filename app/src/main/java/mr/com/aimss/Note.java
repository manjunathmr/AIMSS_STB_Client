package mr.com.aimss;

/**
 * Created by MR on 2/9/2015.
 */
public class Note {

    private long id;

    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return note;
    }
}
