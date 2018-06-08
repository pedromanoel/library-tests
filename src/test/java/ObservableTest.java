import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

import static org.assertj.core.api.Assertions.assertThat;

public class ObservableTest {

    @Test
    public void testObservable() {
        final MyObservable observable = new MyObservable();
        MyObserver observer = new MyObserver();
        observable.addObserver(observer);

        observable.update();

        assertThat(observable.hasChanged()).isTrue();
        assertThat(observer.wasUpdated()).isFalse();

        observable.notifyObservers();

        assertThat(observable.hasChanged()).isFalse();
        assertThat(observer.wasUpdated()).isTrue();

    }

    private static class MyObservable extends Observable {

        public void update() {
            setChanged();
        }
    }

    private static class MyObserver implements Observer {
        private boolean updated = false;

        @Override
        public void update(Observable o, Object arg) {
            this.updated = true;
        }

        public boolean wasUpdated() {
            return updated;
        }
    }
}
