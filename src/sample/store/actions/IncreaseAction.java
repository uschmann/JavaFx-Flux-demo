package sample.store.actions;

public class IncreaseAction implements Action {

    protected int mValue;

    public IncreaseAction(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }
}
