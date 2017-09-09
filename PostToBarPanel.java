package barcodescanner;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Sets up postal code input panel.
 * @author ###
 */
public class PostToBarPanel extends JPanel
{
    private final JTextField textField;
    private final JLabel instructLabel;
    private final JLabel errorLabel;
    private final JButton convertBut;
    private final Gui gui;
    
    /**
     * Constructor for class.
     * @param guiIn 
     */
    public PostToBarPanel(Gui guiIn)
    {
        textField = new JTextField(5);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Arial", Font.ITALIC, 35));
        
        convertBut = new JButton("Convert to barcode");
        convertBut.setFont(new Font("Arial", Font.PLAIN, 35));
        
        gui = guiIn;
        
        convertBut.addActionListener(new ConvertButList());
        
        this.setLayout(new GridLayout(4,0));
        
        instructLabel = new JLabel("Enter 5 Digit Postal Code");
        instructLabel.setFont(new Font("Arial", Font.BOLD, 35));
        instructLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        errorLabel = new JLabel();
        errorLabel.setFont(gui.errorFont);
        errorLabel.setForeground(Color.RED);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        this.add(instructLabel);
        this.add(textField);
        this.add(convertBut);
        this.add(errorLabel);
    }
    
    /**
     * Redirects string input to Gui class
     * @param stringOut 
     */
    public void passString(String stringOut)
    {
        gui.toConverter(stringOut);
    }
    
    /**
     * Listening class for convert button
     */
    private class ConvertButList implements ActionListener
    {
        /**
         * Receives action event from convert button. If input text is valid
         * sends input to passString function.
         * @return void
         * @param e 
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            
            if (gui.inputCheck(textField.getText()))
            {
                passString(textField.getText());
                errorLabel.setText("");
            }
            
            errorLabel.setText("Error: must enter 5 digit numerical");            
        }
    }
}
