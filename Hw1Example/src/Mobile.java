/**
 * Class: Mobile
 * 
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * 
 * 
 *          This class � This class describes a subclass of Game called Mobile
 * 
 *          Purpose: � Contains the attributes specific to a type of Game called
 *          Mobile.
 *
 */
public class Mobile extends Game
{
    private String deviceType;
    private String version;

    /**
     * Method:Mobile()
     * 
     * Constructor method that accepts values for all the attributes and sets
     * them.
     * 
     * @param idNumber
     * @param itemName
     * @param type
     * @param numCopies
     * @param deviceType
     * @param version
     */
    public Mobile(int idNumber, String itemName, String type, int numCopies,
            String deviceType, String version)
    {
        super(idNumber, itemName, type, numCopies);
        this.deviceType = deviceType;
        this.version = version;
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
        return super.toString() + " Mobile [Device Type=" + deviceType
                + ", Version =" + version + "]";
    }

    /**
     * @return the deviceType
     */
    public String getDeviceType()
    {
        return deviceType;
    }

    /**
     * @return the version
     */
    public String getVersion()
    {
        return version;
    }

}
