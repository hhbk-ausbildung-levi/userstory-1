package de.levihessmann;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer("123456789", "OfficeJet 3831", "HP", 2, LocalDate.now(), "Tintenstrahl", true, "A4");
        System.out.println(printer.toString());

        printer.changeInk(69);
        System.out.println(printer.toString());

        printer.print(10);
        System.out.println(printer.toString());

        System.out.println(printer.calculateWarranty());
    }
}