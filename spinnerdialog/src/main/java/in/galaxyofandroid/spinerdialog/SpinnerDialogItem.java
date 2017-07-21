package in.galaxyofandroid.spinerdialog;

public class SpinnerDialogItem {

    private final String id;
    private final String value;

    public SpinnerDialogItem(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
