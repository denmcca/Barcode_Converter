package barcodescanner;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
/**
 *
 * @author ###
 */
public class ChooserPanel extends JPanel
{
    private final JButton postToBar;
    private final JButton barToPost;
    private final Gui gui;
    private final JLabel choicePrompt;
    
    /**
     * Constructor for class.
     * @param guiIn 
     */
    public ChooserPanel(Gui guiIn)
    {
        gui = guiIn;
        
        this.setLayout(new GridLayout(3,0));
        
        choicePrompt = new JLabel("CONVERSION TYPE");
        postToBar = new JButton("Postal Code to Barcode");
        barToPost = new JButton("Barcode to Postal Code");
        
        postToBar.addActionListener(new PostToBarButList());
        barToPost.addActionListener(new BarToPostButList());
        
        choicePrompt.setFont(new Font("Arial", Font.BOLD, 35));
        choicePrompt.setHorizontalAlignment(SwingConstants.CENTER);
        postToBar.setFont(new Font("Arial", Font.PLAIN, 35));
        barToPost.setFont(new Font("Arial", Font.PLAIN, 35));
        
        
        this.setSize(500, 300);
        
        this.add(choicePrompt);
        this.add(postToBar);
        this.add(barToPost);     
    }
    
    /**
     * Listener class for zip to barcode button..
     */
    private class PostToBarButList implements ActionListener
    {
        /**
         * Detects when zip to barcode option is chosen.
         * @return void
         * @param e 
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            gui.postToBarFetch();
        }
    }
    
    /**
     * Listener class for barcode to zip button.
     */
    private class BarToPostButList implements ActionListener
    {
        /**
         * Detects when barcode to zip option is chosen.
         * @return void
         * @param e 
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            gui.barToPostFetch();
        }
    }
}
