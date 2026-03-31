public class JOBRunnable {

    public static void main(String[] args) {

        // Runnable task (background job)
        Runnable bgTask = () -> {
            System.out.println("Background task started...");
            try {
                Thread.sleep(2000); // simulate long-running job
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Background task completed!");
        };

        Thread workerThread = new Thread(bgTask);
        workerThread.start();   // runs asynchronously

        System.out.println("Main thread continues executing...");
    }
}
