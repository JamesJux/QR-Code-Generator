package Startup;

import java.io.IOException;

import javax.swing.JOptionPane;

public class QR_Code_Genarator
{
    public static String _chrome;

    public static void main(String[] args)
    {

        _chrome = "\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\"";

        String eingabe = JOptionPane.showInputDialog(null, "Welcher QR-Code soll generiert werden", "QR-Code Generator", JOptionPane.PLAIN_MESSAGE);

        int format = JOptionPane.showOptionDialog(null, "Welches Dateiformat?", "Dateiformat", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] {
                "PNG", "SVG"
        }, "SVG");

        String size = JOptionPane.showInputDialog(null, "Welcher Kantenläge (in Pixel) soll der QR-Code haben", "Pixelgröße", JOptionPane.PLAIN_MESSAGE);

        String formatstring;
        size = size + "x" + size;

        switch (format)
        {
        case 0:
            formatstring = "png";
            break;
        default:
            formatstring = "svg";
        }

        String ausgabe = "https://api.qrserver.com/v1/create-qr-code/?data=" + eingabe
                + "&size=" + size + "&format=" + formatstring + "&charset-source=UTF-8&qzone=2";

        try
        {
            Runtime.getRuntime().exec(_chrome + ausgabe);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
