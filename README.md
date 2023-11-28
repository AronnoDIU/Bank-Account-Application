# Bank Account Application

This is a simple Java application that simulates the operations of a bank. It allows the creation of new bank accounts (either Savings or Checking), and performs various transactions such as deposit, withdrawal, and transfer. It also
calculates compound interest for the accounts. The application reads a CSV file to get the details of new account holders.

## Table of Contents

- [Description](#description)
- [Features](#features)
- [How to Run](#how-to-run)
- [Files](#files)
- [Note](#note)
- [Author Info](#author-info)
- [License](#license)

## Description

This is a simple Java application that simulates the operations of a bank. It allows the creation of new bank accounts (either Savings or Checking), and performs various transactions such as deposit, withdrawal, and transfer. It also
calculates compound interest for the accounts.

## Features

- Create new Savings or Checking accounts
- Deposit money into an account
- Withdraw money from an account
- Transfer money between accounts
- Compound interest calculation

## How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA 2023.2.5
3. Run the `BankAccount.java` file

## Files

- `BankAccount.java`: The main class that handles the creation of accounts and transactions.
- `CSV.java`: A utility class for reading CSV files.
- `InterestBaseRate.java`: An interface that provides the base interest rate.
- `Account.java`: An abstract class that provides common functionality for the accounts.
- `Checking.java`: A subclass of the `Account` class that represents a Checking account.
- `Savings.java`: A subclass of the `Account` class that represents a Savings account.

## Note

The application reads a CSV file to get the details of new account holders. The file should be in the following format:

    ```
    first name, last name, social security number, account type, initial deposit
    ```

## Author Info

- GitHub - [Yeasir Arafat Aronno](https://github.com/AronnoDIU)

## License

This project is licensed under the MIT License.

``` text
Copyright (c) 2023 Yeasir Arafat Aronno
```