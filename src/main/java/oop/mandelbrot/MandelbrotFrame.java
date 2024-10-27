package oop.mandelbrot;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import oop.mandelbrot.coord.CrazyCoordinate;

/**
 * Die Klasse MandelbrotFrame erzeugt ein JFrame-Fenster, 
 * das ein Bild des Mandelbrot-Fraktals darstellt.
 * 
 * @author Aleksandar Travanov
 * @version 1.0
 */
@SuppressWarnings("serial")
public class MandelbrotFrame extends JFrame {
    /**
     * Konstruiert ein neues MandelbrotFrame-Objekt mit der angegebenen Bildgröße, 
     * Bereich und Anzahl von Iterationen.
     * 
     * @param sizeImg Die Größe des Bildes (Breite und Höhe)
     * @param from Der Startwert des Bereichs für Real- und Imaginärteile
     * @param to Der Endwert des Bereichs für Real- und Imaginärteile
     * @param nofIterations Die Anzahl von Iterationen für die Mandelbrotberechnung
     */
    public MandelbrotFrame(int sizeImg, double from, double to, int nofIterations) {
        BufferedImage image = createMandelbrotImg(sizeImg, from, to, nofIterations);
        add(new JLabel(new ImageIcon(image)));
        pack();
    }

    /**
     * Erzeugt ein BufferedImage, das das Mandelbrot-Fraktal darstellt. 
     * Dabei wird für jeden Punkt im Bildbereich die Mandelbrot-Funktion iterativ berechnet, 
     * um festzustellen, ob der Punkt zur Mandelbrot-Menge gehört oder nicht.
     * 
     * @param sizeImg         Die Größe des Bildes (Breite und Höhe)
     * @param from            Der Startwert des Bereichs für Real- und Imaginärteile
     * @param to              Der Endwert des Bereichs für Real- und Imaginärteile
     * @param nofIterations   Die Anzahl von Iterationen für die Mandelbrotberechnung
     * @return                Das erzeugte BufferedImage, das das Mandelbrot-Fraktal darstellt
     */
    private BufferedImage createMandelbrotImg(int sizeImg, double from, double to, int nofIterations) {
        double size = to - from;
        BufferedImage image = new BufferedImage(sizeImg, sizeImg, BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = image.getRaster();
        int[] blackPixel = { 0, 0, 0 };
        for (int i = 0; i < sizeImg; i++) {
            for (int j = 0; j < sizeImg; j++) {
                double x = from + (i * size) / sizeImg;
                double y = from + (j * size) / sizeImg;
                CrazyCoordinate z = new CrazyCoordinate(0.0, 0.0);
                CrazyCoordinate c = new CrazyCoordinate(x, y);
                int counter = 0;
                do {
                    counter++;
                    z = z.mul(z).add(c);
                } while ((counter < nofIterations) && z.scalar() <= (to - from));

                if (counter == nofIterations) {
                    raster.setPixel(i, j, blackPixel);
                } else if (counter < nofIterations / 10) {
                	int[] bluePixel = { 0, 0, (counter*300)%255 };
                    raster.setPixel(i, j, bluePixel);
                } else {
                	int[] redPixel = {255,0,0 };
                	raster.setPixel(i, j, redPixel);
                }
            }
        }
        return image;
    }
}
