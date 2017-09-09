package barcodescanner;

/**
 * Main class for BarcodeScanner application
 * @author ###
 */
public class BarcodeScanner 
{
    private static Gui gui;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        gui = new Gui();
        gui.start();
    }
    
}
