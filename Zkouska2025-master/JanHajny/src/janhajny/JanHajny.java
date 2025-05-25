
package janhajny;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author hajnyja1
 */
public class JanHajny {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Vozidlo> zaznam = new ArrayList<>();
        String akce;
        do {
            System.out.println("Zapis vozidel");
            System.out.println("Jakou akci chcete provest?:");
            System.out.println("P - Pridat");
            System.out.println("S - Smazat");
            System.out.println("V - Vypis vozidel");
            System.out.println("SPZ - vyhledani podle SPZ");
            System.out.println("E - Export do CSV souboru");
            System.out.println("K - Konec programu");
            
            akce = scanner.nextLine().toUpperCase();
            switch (akce) {
                case "P":
                    System.out.print("Napis druh vozidla: ");
                    String tDruh = scanner.next();
                    System.out.print("Napis znacku auta: ");
                    String tZnacka = scanner.next();
                    int tRok = VozidlaUtil.safeIntInput(scanner, "Napis rok vyroby auta: ");
                    System.out.print("Napis SPZ auta: ");
                    String tSPZ = scanner.next();


                    Vozidlo myObj = new Vozidlo(tDruh, tZnacka, tRok, tSPZ);
                    System.out.println("Druh: " + myObj.getDruh() + ", Znacka: "
                            + myObj.getZnacka() + ", Rok výroby: " + myObj.getRok() + ", SPZ: " + myObj.getSPZ());

                    zaznam.add(myObj);

                    break;
                case "S":
                    try {
                        System.out.print("Napiš pořadí vozidla, které chceš smazat(začíná od 1)");
                        zaznam.remove(scanner.nextInt() - 1);
                        System.out.println("Vozidlo smazano!");
                    }catch(Exception e){
                        System.out.println("Nastala chyba [" + e + "]");
                    }
                    break;
                case "V":
                    if (zaznam.isEmpty()) {
                        System.out.println("Seznam vozidel je prazdny.");
                    } else {
                        System.out.println("\n--- Vypis vsech vozidel ---");
                        for (int i = 0; i < zaznam.size(); i++) {
                            System.out.println((i + 1) + ". " + zaznam.get(i));
                        }
                    }
                    break;
                case "SPZ":
                    System.out.print("Zadej SPZ vozidla: ");
                    String hledanaSPZ = scanner.nextLine();

                    boolean nalezeno = false;
                    for (Vozidlo v : zaznam) {
                    if (v.getSPZ().equalsIgnoreCase(hledanaSPZ)) {
                         System.out.println("Vozidlo nalezeno: " + v);
                           nalezeno = true;
                        break;
                        }
                    }

                    if (!nalezeno) {
                        System.out.println("Vozidlo se zadanou SPZ nebylo nalezeno.");
                    }
                    break;
                case "E":
                    VozidlaUtil.ulozDoCSV("evidence.csv", zaznam);
                    break;
                    
                
        }
    }while(!Objects.equals(akce,"K"));
        }
}
