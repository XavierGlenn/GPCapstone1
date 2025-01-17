package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class reportsLogic {

    static Scanner reader = new Scanner(System.in);
    static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void displayReports() throws FileNotFoundException {
        String reportOptions;
        do {
            System.out.println("Welcome to your reports. Please select one of the following options: " + "\n1 - Month to Date" + "\n2 - Previous Month" + "\n3 - Year to Date" + "\n4 - Previous Year" + "\n5 - Search by Vendor" + "\n0 - Back");

            reportOptions = reader.nextLine();

            switch (reportOptions) {
                case "1":
                    displayMonthToDate();
                    break;
                case "2":
                    displayPreviousMonth();
                    break;
                case "3":
                    displayYearToDate();
                    break;
                case "4":
                    displayPreviousYear();
                    break;
                case "5":
                    searchVendor();
                    break;
                case "0":
                    System.out.println("Exiting Reports...");
                    break;
                default:
                    System.out.println("That is not a valid selection. Please try again.");
            }
        } while (!reportOptions.equals("0"));

        // Close Scanner after usage
        reader.close();
    }

    public static void searchVendor() {
        System.out.println("Please enter the vendor here:");
        String vendorSearch = reader.nextLine();

        try (BufferedReader bufReader = new BufferedReader(new FileReader("transactions.csv"))) {
            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] splittingFields = input.split("\\|");
                String vendor = splittingFields[3];

                if (vendor.equalsIgnoreCase(vendorSearch)) {
                    System.out.println(input);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void displayMonthToDate() {
        try (BufferedReader bufReader = new BufferedReader(new FileReader("transactions.csv"))) {
            String input;
            LocalDate now = LocalDate.now();

            while ((input = bufReader.readLine()) != null) {
                String[] splittingFields = input.split("\\|");
                String splitDate = splittingFields[0];
                LocalDate date = LocalDate.parse(splitDate, df);

                if (date.getMonth() == now.getMonth() && date.getYear() == now.getYear()) {
                    System.out.println(input);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void displayPreviousMonth() {
        try (BufferedReader bufReader = new BufferedReader(new FileReader("transactions.csv"))) {
            String input;
            LocalDate previousMonth = LocalDate.now().minusMonths(1);

            while ((input = bufReader.readLine()) != null) {
                String[] splittingFields = input.split("\\|");
                String splitDate = splittingFields[0];
                LocalDate date = LocalDate.parse(splitDate, df);

                if (date.getMonth() == previousMonth.getMonth() && date.getYear() == previousMonth.getYear()) {
                    System.out.println(input);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void displayYearToDate() {
        try (BufferedReader bufReader = new BufferedReader(new FileReader("transactions.csv"))) {
            String input;
            LocalDate now = LocalDate.now();

            while ((input = bufReader.readLine()) != null) {
                String[] splittingFields = input.split("\\|");
                String splitDate = splittingFields[0];
                LocalDate date = LocalDate.parse(splitDate, df);

                if (date.getYear() == now.getYear()) {
                    System.out.println(input);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void displayPreviousYear() {
        try (BufferedReader bufReader = new BufferedReader(new FileReader("transactions.csv"))) {
            String input;
            LocalDate previousYear = LocalDate.now().minusYears(1);

            while ((input = bufReader.readLine()) != null) {
                String[] splittingFields = input.split("\\|");
                String splitDate = splittingFields[0];
                LocalDate date = LocalDate.parse(splitDate, df);

                if (date.getYear() == previousYear.getYear()) {
                    System.out.println(input);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}