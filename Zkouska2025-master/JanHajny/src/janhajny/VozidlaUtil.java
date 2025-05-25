package janhajny;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hajnyja1
 */
public class VozidlaUtil {
    
    public static void ulozDoCSV(String nazevSouboru, ArrayList<Vozidlo> seznam) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nazevSouboru))) {
        writer.println("Druh,Znacka,Rok,SPZ");

        for (Vozidlo v : seznam) {
            writer.printf("%s,%s,%d,%s,%n", v.getDruh(), v.getZnacka(), v.getRok(), v.getSPZ());
        }

        System.out.println("Data byla úspěšně uložena do CSV souboru: " + nazevSouboru);
    } catch (IOException e) {
        System.out.println("Chyba při ukládání do CSV: " + e.getMessage());
    }
}

    public static int safeIntInput(Scanner scanner, String vyzva) {
        int vysledek;
        while (true) {
            System.out.println(vyzva);
            if (scanner.hasNextInt()) {
                vysledek = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Zadej prosim platne cele cislo.");
                scanner.nextLine();
            }
        }
        return vysledek;
    }
           
    
}
    


