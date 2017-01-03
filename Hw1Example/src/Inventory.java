import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: Inventory
 * 
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * 
 * 
 *          This class � This class describes Inventory used to contain the Game
 *          item Inventory. It also contains the main method which starts the
 *          program.
 * 
 *          Purpose: � Methods and attributes needed to create a Inventory of
 *          Game class items. Print them, read them from a file,search for a
 *          particular id and add a new item.
 *
 */
public class Inventory
{

    // actual Inventory data
    private ArrayList<Game> InventoryItems = new ArrayList<Game>();

    /**
     * Method:printInventoryItems()
     * 
     * This method prints the Inventory items contained in the InventoryItems
     * Array list. It relies on the toString method of the various Game types to
     * print the items in a user friendly format.
     * 
     * 
     */
    public void printInventoryItems()
    {
        for (int i = 0; i < InventoryItems.size(); i++)
        {
            Game temp = InventoryItems.get(i);
            System.out.println(temp);
        }

    }

    /**
     * Method:searchById()
     * 
     * This method looks at each item in the InventoryItems array list and if
     * its idNumber attribute matches the input parameter id, that item is
     * returned to the caller. It returns null if item is not found.
     * 
     * @param id
     * 
     * @return Game
     * 
     */
    public Game searchById(int id)
    {
        Game item = null;
        for (Game temp : InventoryItems)
        {
            if (temp.getIdNumber() == id)
            {
                item = temp;
            }

        }
        return item;
    }

    /**
     * @return the inventoryItems
     */
    public ArrayList<Game> getInventoryItems()
    {
        return InventoryItems;
    }

    /**
     * Method:addItem()
     * 
     * This method adds the parameter m to the InventoryItems array list
     * 
     * @param m
     * 
     */
    public void addItem(Game m)
    {
        InventoryItems.add(m);
    }

    /**
     * Method:removeItem()
     * 
     * This method removes the item with id from the array list
     * 
     * @param m
     * 
     */
    public void removeItem(int id)
    {
        Game g = this.searchById(id);
        if (g != null)
        {
            InventoryItems.remove(g);
        }
    }

    /**
     * 
     * Method:main()
     * 
     * This method is the starting point of the program. It contains the initial
     * reading of items from the text file Game.txt and a menu for allowing user
     * to choose various tasks.
     * 
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        // create Inventory by reading in from text file named media.txt
        Inventory myInventory = new Inventory();

        // open text file
        File gameFile = new File("media.txt");
        // open a Scanner to read data from File
        Scanner gameReader = null;
        try
        {
            gameReader = new Scanner(gameFile);
        } catch (FileNotFoundException e)
        {

            System.out.println("No Inventory Game found- Inventory is empty");

        }

        // read one person at a time
        while (gameReader != null && gameReader.hasNext())
        {

            String category = gameReader.nextLine();
            String name = gameReader.nextLine();
            String idString = gameReader.nextLine();
            int id = Integer.parseInt(idString);
            String copiesString = gameReader.nextLine();
            int numCopies = Integer.parseInt(copiesString);

            if (category.equalsIgnoreCase("pc"))
            {
                String minMemoryString = gameReader.nextLine();
                int mem = Integer.parseInt(minMemoryString);
                String minDiskString = gameReader.nextLine();
                int disk = Integer.parseInt(minDiskString);
                PC tp = new PC(id, name, category, numCopies, mem, disk);
                myInventory.addItem(tp);

            } else if (category.equalsIgnoreCase("console"))
            {
                String consoleName = gameReader.nextLine();
                String version = gameReader.nextLine();

                Console tp = new Console(id, name, category, numCopies,
                        consoleName, version);
                myInventory.addItem(tp);

            } else if (category.equalsIgnoreCase("mobile"))
            {
                String mobileName = gameReader.nextLine();
                String version = gameReader.nextLine();
                Mobile tp = new Mobile(id, name, category, numCopies,
                        mobileName, version);
                myInventory.addItem(tp);
            } else
            {
                System.out.println("Unknown Game type " + category);
            }

        }

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the Inventory");
        boolean done = false;
        while (!done)
        {
            System.out.println("Would you like to :");
            System.out.println("  1. View contents of Inventory");
            System.out.println("  2. Search for an item");
            System.out.println("  3. Remove an item");
            System.out.println("  4.  Exit");
            int userInput = keyboard.nextInt();
            if (userInput == 1)
            {
                myInventory.printInventoryItems();
            } else if (userInput == 2)
            {
                System.out.println("Please enter item number");
                int id = keyboard.nextInt();
                Game item = myInventory.searchById(id);
                if (item != null)
                {
                    System.out.println(item);
                } else
                {
                    System.out.println("Sorry- item not found");
                }
            } else if (userInput == 3)
            {
                System.out.println("Please enter item number");
                int id2 = keyboard.nextInt();
                myInventory.removeItem(id2);
            } else
            {
                done = true;
                // write out contents of inventory back to original file
                PrintWriter out = null;
                // open file for writing
                try
                {
                    out = new PrintWriter(new File("media.txt"));
                } catch (FileNotFoundException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // write contents of each inventory item to file
                for (Game g : myInventory.getInventoryItems())
                {
                    // first write the attributes common to all
                    out.println(g.getType());
                    out.println(g.getItemName());
                    out.println(g.getIdNumber());
                    out.println(g.getNumCopies());

                    if (g.getType().equalsIgnoreCase("pc"))
                    {
                        // cast to appropriate subclass
                        PC p = (PC) g;
                        out.println(p.getMinMemory());
                        out.println(p.getMinDiskSpace());

                    } else if (g.getType().equalsIgnoreCase("console"))
                    {
                        // cast to appropriate subclass
                        Console c = (Console) g;
                        // write attributes specific to console
                        out.println(c.getPlatformName());
                        out.println(c.getPlatformVersion());

                    } else if (g.getType().equalsIgnoreCase("mobile"))
                    {
                        Mobile m = (Mobile) g;
                        out.println(m.getDeviceType());
                        out.println(m.getVersion());

                    } else
                    {
                        System.out.println("Unknown Game type " + g.getType());
                    }

                }
                out.close();
                

            }

        }

    }

}
