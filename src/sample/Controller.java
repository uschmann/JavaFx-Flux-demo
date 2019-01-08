package sample;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.reactfx.EventSource;
import sample.store.Dispatcher;
import sample.store.Store;
import sample.store.actions.DecreaseAction;
import sample.store.actions.IncreaseAction;

public class Controller {

    @FXML
    protected Label label;

    protected Dispatcher mDispatcher;
    protected Store mStore;

    public Controller() {
        mDispatcher = new Dispatcher(new EventSource<>());
        mStore = new Store(mDispatcher);
    }

    @FXML
    public void initialize() {
        label.textProperty().bind(mStore.labelText());
    }


    @FXML
    public void increase() {
        mDispatcher.dispatch(new IncreaseAction(1));
    }

    @FXML
    public void decrease() {
        mDispatcher.dispatch(new DecreaseAction(1));
    }

}
