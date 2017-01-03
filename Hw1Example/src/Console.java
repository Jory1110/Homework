/**
 * Class: Console
 * 
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * 
 * 
 *          This class � This class describes a subclass of Game called Console
 * 
 *          Purpose: � Contains the attributes specific to a type of Game called
 *          Console.
 *
 */
public class Console extends Game
{
    private String platformName;
    private String platformVersion;

    /*
     * Method:toString() Converts the attributes of the class to a text readable
     * format.
     * 
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return super.toString() + " Console [Platform name=" + platformName
                + ", Platform version=" + platformVersion + "]";
    }

    /**
     * Method:Console() Constructor method that accepts values for all the
     * attributes and sets them.
     *
     * @param idNumber
     * @param itemName
     * @param type
     * @param numCopies
     * @param platformVersion
     * @param platformName
     */
    public Console(int idNumber, String itemName, String type, int numCopies,
            String platformName, String platformVersion)
    {
        super(idNumber, itemName, type, numCopies);
        this.platformName = platformName;
        this.platformVersion = platformVersion;

    }

    /**
     * @return the platformName
     */
    public String getPlatformName()
    {
        return platformName;
    }

    /**
     * @return the platformVersion
     */
    public String getPlatformVersion()
    {
        return platformVersion;
    }

}
