package com.pluralsight;

import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Collectors;

    public class reportsLogic {

        //Month-to-date
        public static List<transaction> generateMonthtoDateReport(List<transaction> transactions) {
            LocalDate today = LocalDate.now();
            LocalDate startOfMonth = today.withDayOfMonth(1);
            return generateReportByDateRange(transactions, startOfMonth, today);
        }

        //Year-to-date
        public static List<transaction> generateMonthtoDateReport(List<transaction> transactions) {
            LocalDate today = LocalDate.now();
            LocalDate startOfYear = today.withDayOfYear(1);
            return generateReportByDateRange(transactions, startOfYear, today);


            //And now to bring it all together in one document... hopefully.
            public static void displayReport(List <transaction> filteredTransactions);
            if (filteredTransactions.isEmpty()) {
                System.out.println("No transactions found for the specified range.");
            } else {
                for (Transaction transaction : filteredTransactions) {
                    System.out.println(transaction);

                    //Vendor searching now. Fancy.
                    class TransactionSearch {

                        public static List<Transaction> generateReportByVendor(List<Transaction> transactions, String vendorName) {
                            return transactions.stream()
                                    .filter(t -> t.getVendor().equalsIgnoreCase(vendorName))
                                    .collect(Collectors.toList());

                            //Back to more familiar waters.
                            public static void searchAndDisplayByVendor(List <transaction> transactions) {
                                Scanner scanner = new Scanner(System.in);
                                System.out.println("Enter the vendor's name to start your search: ");
                                vendorName = scanner.nextLine();

                                //Oh how I've missed the if/else statements.
                                List<Transaction> matchingTransactions = generateReportByVendor(transactions, vendorName);
                                if (matchingTransactions.isEmpty()) {
                                    System.out.println("No transactions found for the vendor: " + vendorName + "were found. Please try again.");
                                } else {
                                    System.out.println("Transactions for vendor: " + vendorName);
                                    for (Transaction transaction : matchingTransactions) {
                                        System.out.println(transaction);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }