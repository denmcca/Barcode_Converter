/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
