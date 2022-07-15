package lowlevel;

class VolatileMain {
    private static final int threadCount = 2;

    public static void main(String[] args) throws InterruptedException {
        VolatileData volatileData = new VolatileData();
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new VolatileThread(volatileData);
        }

        for (int i = 0; i < threadCount; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }

    }
}
