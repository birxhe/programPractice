package Lock;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class InspectableLock extends ReentrantLock {

    public InspectableLock(boolean fair) {
        super(fair);
    }

    protected List<Thread> getQueuedThreads() {
        return (List<Thread>) super.getQueuedThreads();
    }
}
