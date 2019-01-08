package sample.store;

import org.reactfx.EventSource;
import org.reactfx.EventStream;
import sample.store.actions.Action;
import sample.store.actions.IncreaseAction;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Dispatcher {

    EventSource<Action> mEventSource;

    public Dispatcher(EventSource<Action> eventSource) {
        mEventSource = eventSource;
    }

    public void dispatch(Action action) {
        mEventSource.push(action);
    }

    public <U extends Action> void subscribe(Class clazz, Consumer<? super U> subscriber) {
        mEventSource.filter(a -> clazz.isInstance(a))
                .cast(clazz)
                .subscribe(subscriber);
    }

    public void subscribeAll(Consumer<? super Action> subscriber) {
        mEventSource.subscribe(subscriber);
    }
}
