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

        try
        {
            String ausgabe;
            switch (eingabe.toLowerCase())
            {
            case "website":
                ausgabe = "https://api.qrserver.com/v1/create-qr-code/?data=https://sites.google.com/view/rudolf-laun-haus&size=100x100&format=svg&charset-source=UTF-8&qzone=2";
                break;
            case "rlhwhatsapp":
                ausgabe = "UncompledMethode: Die Methode wurde nur Teilweise oder noch garnicht implementiert.";
                break;
            default:
                ausgabe = "https://api.qrserver.com/v1/create-qr-code/?data=" + eingabe
                        + "&size=100x100&format=svg&charset-source=UTF-8&qzone=2";
            }
            Runtime.getRuntime().exec(_chrome + ausgabe);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
