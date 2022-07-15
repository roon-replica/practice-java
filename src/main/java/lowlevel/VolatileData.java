package lowlevel;

// https://docs.oracle.com/cd/E19683-01/806-5222/codingpractices-1/index.html

// https://www.javatpoint.com/volatile-keyword-in-java

class VolatileData {
    private volatile int counter = 0;  // volatile 안 붙이면 thread safe하지 않음..!

    public int getCounter() {
        return counter;
    }

    public void increaseCounter() {
        counter++;
    }
}