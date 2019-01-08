package sample.store.actions;

public class DecreaseAction implements Action {

    protected int mValue;

    public DecreaseAction(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }

}
