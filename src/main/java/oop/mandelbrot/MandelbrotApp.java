package oop.mandelbrot;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Die Klasse MandelbrotApp ist die Hauptklasse der Mandelbrot-Anwendung. 
 * Sie implementiert das Runnable-Interface, um die Anwendung im Swing-Event-Dispatch-Thread 
 * auszuführen.
 * 
 * @author Aleksandar Travanov
 * @version 1.0
 */
public class MandelbrotApp implements Runnable {
    
    /**
     * Die main-Methode, die die Anwendung startet.
     * @param args Die Befehlszeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new MandelbrotApp());
    }

    /**
     * Führt die Mandelbrot-Anwendung im Swing-Event-Dispatch-Thread aus.
     */
    @Override
    public void run() {
        // Erzeugt ein MandelbrotFrame-Objekt mit den angegebenen Parametern
        MandelbrotFrame frame = new MandelbrotFrame(532, -2, 2, 100);
        // Setzt den Titel des Frames
        frame.setTitle("Mandelbrot Menge");
        // Setzt das Schließen-Verhalten des Frames
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Macht den Frame sichtbar
        frame.setVisible(true);
    }
}
