package multithreads.volatile_example;

public class VolatileThread extends Thread {
    private final VolatileData data;

    public VolatileThread(VolatileData data) {
        this.data = data;
    }

    @Override
    public void run() {
        int oldValue = data.getCounter();
        System.out.println("Thread: " + Thread.currentThread().getId() + " old value = " + oldValue);

        data.increaseCounter();

        int newValue = data.getCounter();
        System.out.println("Thread: " + Thread.currentThread().getId() + " new value = " + newValue);
    }
}