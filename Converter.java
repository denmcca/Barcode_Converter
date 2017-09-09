package barcodescanner;

/**
 * Converts zip code to/from barcode.
 * @author ###
 */
public class Converter 
{
    private String barcodeStr, postalCodeStr;
    
    /**
     * Constructor for class. Converts upon construction.
     * @param strInput 
     */
    public Converter(String strInput)
    {
        if (strInput.length() == 5) {
            postalCodeStr = strInput;
            barcodeStr = "|";
            for (int i = 0; i < 5; i++) { //encoding zipcode by appending to a barcode
                char temp = strInput.charAt(i);
                switch (temp) {
                    case '1':
                        barcodeStr += ":::||";
                        break;
                    case '2':
                        barcodeStr += "::|:|";
                        break;
                    case '3':
                        barcodeStr += "::||:";
                        break;
                    case '4':
                        barcodeStr += ":|::|";
                        break;
                    case '5':
                        barcodeStr += ":|:|:";
                        break;
                    case '6':
                        barcodeStr += ":||::";
                        break;
                    case '7':
                        barcodeStr += "|:::|";
                        break;
                    case '8':
                        barcodeStr += "|::|:";
                        break;
                    case '9':
                        barcodeStr += "|:|::";
                        break;
                    case '0':
                        barcodeStr += "||:::";
                }
            }

            int sum = 0;
            for (int i = 0; i < 5; i++) { //calculating the correction digit
                sum += strInput.charAt(i) - '0';
            }
            int diff = 10 - sum % 10;
            switch (diff) {
                case 1:
                    barcodeStr += ":::||";
                    break;
                case 2:
                    barcodeStr += "::|:|";
                    break;
                case 3:
                    barcodeStr += "::||:";
                    break;
                case 4:
                    barcodeStr += ":|::|";
                    break;
                case 5:
                    barcodeStr += ":|:|:";
                    break;
                case 6:
                    barcodeStr += ":||::";
                    break;
                case 7:
                    barcodeStr += "|:::|";
                    break;
                case 8:
                    barcodeStr += "|::|:";
                    break;
                case 9:
                    barcodeStr += "|:|::";
                    break;
                case 0:
                    barcodeStr += "||:::";
                    break;
            }
            barcodeStr += "|";
            return;
        }

        barcodeStr = strInput;
        postalCodeStr = "";
        
        for (int i = 0; i < 5; i++) { //decoding barcode with 5 substrings
            String temp = strInput.substring(1 + 5 * i, 6 + 5 * i);
            switch (temp) {
                case ":::||":
                    postalCodeStr += 1;
                    break;
                case "::|:|":
                    postalCodeStr += 2;
                    break;
                case "::||:":
                    postalCodeStr += 3;
                    break;
                case ":|::|":
                    postalCodeStr += 4;
                    break;
                case ":|:|:":
                    postalCodeStr += 5;
                    break;
                case ":||::":
                    postalCodeStr += 6;
                    break;
                case "|:::|":
                    postalCodeStr += 7;
                    break;
                case "|::|:":
                    postalCodeStr += 8;
                    break;
                case "|:|::":
                    postalCodeStr += 9;
                    break;
                case "||:::":
                    postalCodeStr += 0;
            }
        }
    }
    
    /**
     * Gets postal code.
     * @return String 
     */
    public String getPostCode()
    {
        return postalCodeStr;
    }
    
    /**
     * Gets barcode.
     * @return String
     */
    public String getBarcode()
    {
        return barcodeStr;
    }
}
