/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package janhajny;

/**
 *
 * @author hajnyja1
 */
public class Vozidlo {
	private String druh;
	private String znacka;
	private int rok;
	private String SPZ;
	
	public Vozidlo(String druh, String znacka, int rok, String SPZ) {
		this.druh = druh;
		this.znacka = znacka;
		this.rok = rok;
		this.SPZ = SPZ;
        }
        public String getDruh() {
		return druh;
	}
	public String getZnacka() {
		return znacka;
	}
	public int getRok() {
		return rok;
	}
	public String getSPZ() {
		return SPZ;
        }      
        @Override
	public String toString() {
	    return String.format("%s Druh | %s Znacka | %d Rok | %s SPZ ",
	            this.getDruh(), this.getZnacka(), this.getRok(), this.getSPZ());
	}
}

