import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ConsumerProducerThreads
{
    private static DataSource buffer = new DataSource();

    public static void main(String[] args)
    {
        // Create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();
    }

    // A task for adding an int to the buffer
    private static class ProducerTask implements Runnable
    {
        public void run()
        {
            try
            {
                int i = 1;
                while (i < 21)
                {
                    System.out.println("Producer writes " + i);
                    buffer.write(i++); // Add a value to the buffer
                    // Put the thread into sleep
                    Thread.sleep((int) (Math.random() * 100));
                }
            } catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    // A task for reading and deleting an int from the buffer
    private static class ConsumerTask implements Runnable
    {
        public void run()
        {
            try
            {
            	int i = 1;
                while (i < 21)
                {
                    System.out.println("\t\t\tConsumer reads " + buffer.read());
                    // Put the thread into sleep
                    i++;
                    Thread.sleep((int) (Math.random() * 100));
                }
            } catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    
}
