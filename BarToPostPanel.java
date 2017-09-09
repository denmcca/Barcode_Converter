/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcodescanner;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Sets up barcode to zipcode GUI panel.
 * @author ###
 */
public class BarToPostPanel extends JPanel
{
    private final JTextField textField;
    private final JButton convertBut;
    private final Gui gui;
    private final JLabel instructLabel;
    private final JLabel errorLabel;
    
    /**
     * Constructor for class.
     * @param guiIn 
     */
    public BarToPostPanel(Gui guiIn)
    {
        gui = guiIn;
        
        this.setLayout(new GridLayout(4,0));
        
        textField = new JTextField();
        textField.setFont(gui.inputFont);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        
        convertBut = new JButton("Convert to postal code");
        convertBut.setFont(gui.butFont);        
        convertBut.addActionListener(new ConvertButList());
        
        instructLabel = new JLabel("Enter 32 Digit Barcode");
        instructLabel.setFont(gui.titleFont);
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
     * Passes user inputted string to Gui class.
     * return void
     * @param stringOut 
     */
    public void passString(String stringOut)
    {
        gui.toConverter(stringOut);
    }
    
    /**
     * Listener class for convert button.
     */
    private class ConvertButList implements ActionListener
    {
        /**
         * Passes string from user to passString function.
         * return void
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
            
            errorLabel.setText("Error: invalid 32 digit barcode; "
                    + "use \':\' and \'|\'.");                        
        }        
    }
}
