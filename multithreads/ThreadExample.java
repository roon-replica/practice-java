class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        int x = 120;
        Result result = new Result();

        for (int i = 0; i < 10000; i++) {
            Thread t1 = new Thread(() -> result.left += 1);
            Thread t2 = new Thread(() -> result.right += 1);
            t1.start();
            t2.start();

            //join이 thread 끝날 때까지 기다려주니까 정상적인 result값이 출력됨
            t1.join();
            t2.join();
        }

        System.out.println(result);
    }

    private static class Result {
        private int left, right;

        public String toString() {
            return left + " " + right;
        }
    }
}