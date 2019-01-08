package sample.store;

import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import sample.Controller;
import sample.store.actions.DecreaseAction;
import sample.store.actions.IncreaseAction;

public class Store {

    private ReadOnlyIntegerWrapper mCounter = new ReadOnlyIntegerWrapper();
    private ReadOnlyStringWrapper mLabelText = new ReadOnlyStringWrapper();

    public Store(Dispatcher dispatcher) {
        // Subscribe to actions
        dispatcher.subscribe(IncreaseAction.class, this::increase);
        dispatcher.subscribe(DecreaseAction.class, this::decrease);

        // Init properties
        mCounter.set(0);
        mLabelText.set("Counter: " + mCounter.get());

        // Update dependent values
        mCounter.addListener((observableValue, oldValue, newValue) -> {
            Store.this.mLabelText.set("Counter: " + newValue);
        });
    }

    /********************************************
     * Properties
     ********************************************/

    public ReadOnlyIntegerWrapper counter() {
        return mCounter;
    }

    public ReadOnlyStringWrapper labelText() {
        return mLabelText;
    }

    /********************************************
     * Mutations
     ********************************************/

    private void increase(IncreaseAction action) {
        mCounter.set(mCounter.getValue() + action.getValue());
    }

    private void decrease(DecreaseAction action) {
        mCounter.set(mCounter.getValue() - action.getValue());
    }

}
