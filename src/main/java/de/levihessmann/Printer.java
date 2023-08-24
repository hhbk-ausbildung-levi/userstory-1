package de.levihessmann;

import javax.swing.*;
import java.time.LocalDate;

public class Printer {
    private static int amount = 0;

    private final int id;
    private final String serialNumber;
    private final String model;
    private final String manufacturer;

    private String status;
    private int manufacturerWarranty;
    private LocalDate shipmentDate;
    private String technology;
    private boolean color;
    private String maximumPaperFormat;
    private int maximumPaperCapacity;
    private int restCapacity;
    private int capacityOfInk;

    public Printer(String serialNumber, String model, String manufacturer, int manufacturerWarranty, LocalDate shipmentDate, String technology, boolean color, String maximumPaperFormat) {
        this.id = amount++;
        this.serialNumber = serialNumber;
        this.model = model;
        this.manufacturer = manufacturer;
        this.status = "ok";
        this.manufacturerWarranty = manufacturerWarranty;
        this.shipmentDate = shipmentDate;
        this.technology = technology;
        this.color = color;
        this.maximumPaperFormat = maximumPaperFormat;
        this.maximumPaperCapacity = 200;
        this.restCapacity = 200;
        this.capacityOfInk = 200;
    }

    public static int getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getManufacturerWarranty() {
        return manufacturerWarranty;
    }

    public void setManufacturerWarranty(int manufacturerWarranty) {
        this.manufacturerWarranty = manufacturerWarranty;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDate shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public String getMaximumPaperFormat() {
        return maximumPaperFormat;
    }

    public void setMaximumPaperFormat(String maximumPaperFormat) {
        this.maximumPaperFormat = maximumPaperFormat;
    }

    public int getMaximumPaperCapacity() {
        return maximumPaperCapacity;
    }

    public void setMaximumPaperCapacity(int maximumPaperCapacity) {
        this.maximumPaperCapacity = maximumPaperCapacity;
    }

    public int getRestCapacity() {
        return restCapacity;
    }

    public void setRestCapacity(int restCapacity) {
        this.restCapacity = restCapacity;
    }

    public int getCapacityOfInk() {
        return capacityOfInk;
    }

    public void setCapacityOfInk(int capacityOfInk) {
        this.capacityOfInk = capacityOfInk;
    }

    public void changeInk(int capacity) {
        if (capacity <= 0) {
            JOptionPane.showInputDialog("Capacity must be greater than 0!");
        }

        this.capacityOfInk = capacity;
        this.restCapacity = capacity;
    }

    public LocalDate calculateWarranty() {
        return this.shipmentDate.plusYears(this.manufacturerWarranty);
    }

    public void print(int pages) {
        if (pages <= 0) {
            JOptionPane.showInputDialog("Pages must be greater than 0!");
        }

        if (pages > this.restCapacity) {
            JOptionPane.showInputDialog("Not enough paper!");
        }

        this.restCapacity -= pages;
    }

    @Override
    public String toString() {
        return id + ";" + serialNumber + ";" + model + ";" + manufacturer
                + ";" + status + ";" + manufacturerWarranty + ";"
                + shipmentDate + ";" + technology + ";" + color + ";" + maximumPaperFormat
                + ";" + maximumPaperCapacity + ";" + restCapacity + ";" + capacityOfInk;
    }
}
