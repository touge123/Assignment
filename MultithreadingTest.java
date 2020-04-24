import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.LinkedList;
import java.util.Queue;

public class MultithreadingTest {

    private static String name;

    public static void main(String[] args) {

        ThreadWorker worker = new ThreadWorker("Worker");
        for (int i = 0; i < 100; i++) {
            Order order = new Order(i, "NEW");
            worker.addToQueue(order);
        }

    }
}

class Order {
    private int number;
    private String state;

    public Order(int number, String state) {
        this.number = number;
        this.state = state;
    }

    public void setState(String newState) {
        this.state = newState;
    }
}

class ThreadWorker implements Runnable {

    private final String threadName;
    private Queue workQueue;   //Does this have to volatile??

    /**
     * Class constructor.
     *
     * @param threadName Name of the thread for identifying.
     *
     */
    public ThreadWorker(String threadName) {
        this.threadName = threadName;
        this.workQueue = new LinkedList();
        System.out.println(String.format("Thread %s started!", threadName));
    }

    /**
     * Adds items to the queue.
     *
     * @param object Object to be added to the queue.
     */
    public synchronized void addToQueue(Order object) {
        workQueue.add(object); //Does it have to be syncronized void
    }

    @Override
    public void run() {
        while (true) {
            if (!workQueue.isEmpty()) {
                System.out.println("Queue size: " + workQueue.size());
                Order order = (Order) workQueue.peek();
                //Process order
                Thread.sleep(10);
                order.setState("FULFILLED");
                System.out.println(order + " :FULFILLED");
                workQueue.remove();
            }
        }
    }
}