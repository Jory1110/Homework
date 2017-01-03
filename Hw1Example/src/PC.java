/**
 * Class: PC
 * 
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * 
 * 
 *          This class � This class describes a subclass of Game called PC
 * 
 *          Purpose: � Contains the attributes specific to a type of Game called
 *          PC.
 *
 */
public class PC extends Game
{
    private int minMemory;
    private int minDiskSpace;

    /**
     * Method:PC()
     * 
     * Constructor method that accepts values for all the attributes and sets
     * them.
     * 
     * @param idNumber
     * @param itemName
     * @param type
     * @param numCopies
     * @param minMemory
     * @param minDiskSpace
     */
    public PC(int idNumber, String itemName, String type, int numCopies,
            int minMemory, int minDiskSpace)
    {
        super(idNumber, itemName, type, numCopies);
        this.minMemory = minMemory;
        this.minDiskSpace = minDiskSpace;
    }

    /*
     * Method:toString() Converts the attributes of the class to a text readable
     * format.
     * 
     * 
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return super.toString() + " PC [minimum memory =" + minMemory
                + ", minimum Disk Space =" + minDiskSpace + "]";
    }

    /**
     * @return the minMemory
     */
    public int getMinMemory()
    {
        return minMemory;
    }

    /**
     * @return the minDiskSpace
     */
    public int getMinDiskSpace()
    {
        return minDiskSpace;
    }

}
