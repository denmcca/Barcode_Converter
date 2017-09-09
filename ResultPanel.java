package barcodescanner;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Sets up result GUI panel.
 * @author ###
 */
public class ResultPanel extends JPanel
{
    private final JLabel titleLabel;
    private final JLabel resultLabelZip;
    private final JLabel resultLabelBar;
    private final JButton doneBut;
    private final Gui gui;
    
    /**
     * Constructor for class. Sets up panel.
     * @param guiIn 
     */
    public ResultPanel(Gui guiIn)
    {
        gui = guiIn;
        
        titleLabel = new JLabel("Postal Code and Barcode");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 35));

        if (gui.getConv().getPostCode().length() < 5)
            resultLabelZip = new JLabel("Barcode Error");
        else
            resultLabelZip = new JLabel(gui.getConv().getPostCode());
        resultLabelZip.setFont(new Font("Arial", Font.PLAIN, 35));
        resultLabelZip.setHorizontalAlignment(SwingConstants.CENTER);
        
        resultLabelBar = new JLabel(gui.getConv().getBarcode());
        resultLabelBar.setFont(new Font("Arial", Font.PLAIN, 35));
        resultLabelBar.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabelBar.setVerticalAlignment(SwingConstants.TOP);
        
        doneBut = new JButton("Done");
        doneBut.setFont(new Font("Arial", Font.PLAIN, 35));
        
        doneBut.addActionListener(new DoneButList());
        
        this.setLayout(new GridLayout(4,0));
        
        this.add(titleLabel);
        this.add(resultLabelZip);
        this.add(resultLabelBar);
        this.add(doneBut);
    }
    
    /**
     * Listener class for done button.
     */
    private class DoneButList implements ActionListener
    {
        /**
         * Detects when done button is pressed. Initiates restart process.
         * @return void
         * @param e 
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            gui.restart();
        }
    }
}
