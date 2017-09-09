package barcodescanner;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Controller class for Gui driven application.
 * @author ###
 */
public class Gui extends JFrame
{
    private JPanel mainPanel;
    private ChooserPanel choosePanel;
    private JPanel postCodeInPanel;
    private BarToPostPanel barToPostPanel;
    private PostToBarPanel postToBarPanel;
    private JPanel resultPanel;
    private Converter converter;
    public Font titleFont, inputFont, butFont, errorFont;
    
    /**
     * Entry point. Starts application GUI.
     */
    public void start()
    {
        //Fonts
        titleFont = new Font("Arial", Font.BOLD, 35);
        inputFont = new Font("Arial", Font.ITALIC, 35);
        butFont = new Font("Arial", Font.PLAIN, 35);
        errorFont = new Font("Arial", Font.ITALIC, 15);
        
        //Panels
        mainPanel = new JPanel();
        choosePanel = new ChooserPanel(this);
        resultPanel = new JPanel();
        
        this.setSize(500, 300);
        this.setTitle("Barcode Converter");
//        this.setLayout(new GridLayout(1,0));
        mainPanel.setLayout(new GridLayout(1,0));
//        mainPanel.add(choosePanel);
        mainPanel.add(choosePanel);
        this.add(mainPanel);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    /**
     * Resets application after initial run.
     */
    public void restart()
    {
        this.setVisible(false);
        
        mainPanel.remove(resultPanel);
        mainPanel.add(choosePanel);    
        
        this.setVisible(true);
    }
    
    /**
     * Calls zip to barcode GUI panel.
     */
    public void postToBarFetch()
    {
        this.setVisible(false);
        
        mainPanel.removeAll();
        postToBarPanel = new PostToBarPanel(this);
        mainPanel.add(postToBarPanel);
        
        this.setVisible(true);
    }
    
    /**
     * Calls barcode to zip GUI panel.
     */
    public void barToPostFetch()
    {
        this.setVisible(false);
        
        mainPanel.removeAll();
        barToPostPanel = new BarToPostPanel(this);
        mainPanel.add(barToPostPanel);
        
        this.setVisible(true);
    }
    
    /**
     * Calls GUI result panel.
     */
    public void resultFetch()
    {
        this.setVisible(false);
        
        mainPanel.removeAll();
        resultPanel = new ResultPanel(this);
        mainPanel.add(resultPanel);
        
        this.setVisible(true);
    }
    
    /**
     * Sends user inputted string to Converter class for conversion.
     * @param inputStr 
     */
    public void toConverter(String inputStr)
    {
        converter = new Converter(inputStr);
        this.resultFetch();
    }
    
    public Converter getConv()
    {
        return converter;
    }
    
    /**
     * Checks for validity of user input.
     * @param inputStr
     * @return boolean
     */
    public boolean inputCheck(String inputStr)
    {
        if (inputStr.length() < 6)
        {
            if (inputStr.length() < 5)
            {              
                return false;
            }
                        
            for (int i = 0; i < inputStr.length(); i++)
            {
                if (inputStr.charAt(i) < '0')
                {
                    return false;
                }
                if (inputStr.charAt(i) > '9')
                {
                    return false;
                }
            }
            
            return true;
        }
        
        if (inputStr.length() != 32)
        {
            return false;
        }
        
        for (int i = 0; i < inputStr.length(); i++)
        {
            if (inputStr.charAt(i) != '|' && inputStr.charAt(i) != ':')
            {
                return false;
            }
        }
        
        return true;
    }

}
