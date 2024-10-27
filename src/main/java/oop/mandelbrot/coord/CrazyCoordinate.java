package oop.mandelbrot.coord;
/**
 * Die {@code CrazyCoordinate} Klasse implementiert die arithemtischen Operationen mit denen Koordinaten addiert und multipliziert werden können.
 * Zudem wurde eine methode zum berechnen des Skalar Werts einer Koordinate implementiert.
 * 
 * @author Noè Di Mattia
 * @version 1.0
 */
public class CrazyCoordinate {
	private double x;
	private double y;
	
	/**
	 * Konstruktor für ein CrazyCoordinate Objekt.
	 * @param x X-Achse einer CrazyCoordinate
	 * @param y Y-Achse einer CrazyCoordinate
	 */
	public CrazyCoordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Methode um zwei CrazyCoordinate Objekte zu addieren. Eine neues CrazyCoordinate Objekt wird dadurch erstellt.
	 * @param other deklariert neue CrazyCoordinate
	 * @return
	 */
	public CrazyCoordinate add(CrazyCoordinate other) {
		return new CrazyCoordinate(this.x + other.x, this.y + other.y);
	}
	
	/**
	 * Methode um zwei CrazyCoordinate Objekte zu multiplizieren.
	 * @param other deklariert neue CrazyCoordinate
	 * @return
	 */
	public CrazyCoordinate mul(CrazyCoordinate other) {
		return new CrazyCoordinate(this.x * other.x - this.y * other.y, this.x * other.y + this.y * other.x);
	}
	
	/**
	 * Methode um den Skalar Wert einer CrazyCoordinate zu berechnen.
	 * @return
	 */
	public double scalar() {
		return this.x * this.x + this.y * this.y;
	}
	
	/**
	 * Getter Methode für X Koordinate.
	 * @return
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Getter Methode für Y Koordinate.
	 * @return
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * toString Methode für Ausgabe im Terminal.
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}