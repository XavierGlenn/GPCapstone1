package com.pluralsight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filename = "transactions.csv";

        // Read transactions from CSV
        List<Transactions> transactions = TransactionLogic.readTransactionsInCSV(filename);

        // Display transactions
        System.out.println("Transactions from CSV:");
        TransactionLogic.displayTransactions(transactions);

        // Sort and display transactions by date
        System.out.println("\nSorted Transactions by Date:");
        TransactionLogic.sortTransactionsByDate(transactions);
        TransactionLogic.displayTransactions(transactions);
    }
}