import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */

/**
 * @author cjohns25
 *
 */
public class DataSource
{
    
    private ArrayList<Integer> theData;
    private int amountOfData;
    private ReentrantLock lock;
    Condition con;
    
    
    public DataSource()
    {
        theData = new ArrayList<Integer>();
        amountOfData = 0;
        lock = new ReentrantLock();
        con = lock.newCondition();
    }
    
    
    public void write(int i)
    {
    	lock.lock();
        theData.add(i);
        amountOfData++;
        con.signalAll();
        lock.unlock();
        
        
    }
    
    
    public int read()
    {
    	lock.lock();
        if (amountOfData > 0)
        {
        	
            int returnValue = theData.get(0);
            theData.remove(0);
            amountOfData --;
            lock.unlock();
            return returnValue;
            
        }
        else if(amountOfData <= 0)
        {
        	
        	try {
				con.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            int returnValue = theData.get(0);
            theData.remove(0);
            amountOfData --;
            lock.unlock();
            return returnValue;
        }
        else
        {
        	return 0;
        }
        
    }
    

}
