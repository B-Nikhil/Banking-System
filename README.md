# 🏦 Console-Based Banking Management System

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Status](https://img.shields.io/badge/Status-Complete-success.svg)
![License](https://img.shields.io/badge/License-MIT-blue.svg)

A robust, feature-rich banking management system built with **Core Java**, demonstrating essential Object-Oriented Programming principles and real-world application development skills.

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Technical Highlights](#-technical-highlights)
- [System Requirements](#-system-requirements)
- [Installation & Setup](#-installation--setup)
- [Usage Guide](#-usage-guide)
- [Project Structure](#-project-structure)
- [OOP Concepts Demonstrated](#-oop-concepts-demonstrated)
- [Screenshots](#-screenshots)
- [Future Enhancements](#-future-enhancements)
- [Author](#-author)

---

## 🎯 Overview

This Console-Based Banking System is a comprehensive Java application that simulates real-world banking operations. It provides a complete suite of banking functionalities including account management, transactions, fund transfers, and persistent data storage.

The project showcases strong **Object-Oriented Programming (OOP)** principles, clean code architecture, and practical implementation of Java's core features.

### 🎥 Key Capabilities

- **Multiple Account Types**: Savings and Current accounts with distinct features
- **Transaction Management**: Deposit, withdraw, and transfer operations
- **Interest Calculation**: Automatic interest computation for savings accounts
- **Data Persistence**: File-based storage ensuring data survives application restarts
- **Transaction History**: Complete audit trail for all operations
- **Input Validation**: Robust error handling and validation mechanisms

---

## ✨ Features

### 🔐 Account Management
- **Create Account**: Support for Savings and Current accounts
- **Account Types**:
  - **Savings Account**: 4% annual interest, minimum balance requirement (₹500)
  - **Current Account**: Overdraft facility up to ₹5,000

### 💰 Banking Operations
- **Deposit Money**: Add funds to any account with validation
- **Withdraw Money**: Withdraw with balance and minimum balance checks
- **Transfer Funds**: Secure inter-account money transfers
- **Check Balance**: View current account balance instantly
- **Transaction History**: Complete audit trail of all transactions with timestamps

### 📊 Advanced Features
- **Interest Calculation**: Automatic interest calculation for savings accounts (4% p.a.)
- **Overdraft Management**: Current accounts can go negative up to ₹5,000 limit
- **Data Persistence**: All data automatically saved to file and loaded on startup
- **Input Validation**: Comprehensive error handling and input validation
- **Professional UI**: Clean, formatted console interface with emojis

---

## 🛠 Technical Highlights

This project demonstrates proficiency in:

| Concept | Implementation |
|---------|---------------|
| **OOP Principles** | Encapsulation, Inheritance, Polymorphism, Abstraction |
| **Collections Framework** | HashMap for O(1) account lookups, ArrayList for transaction history |
| **File I/O** | Reading/Writing account data with BufferedReader/PrintWriter |
| **Exception Handling** | Try-catch blocks for robust error management |
| **Design Patterns** | Service Layer pattern for business logic separation |
| **Data Structures** | Lists for transaction history, Maps for efficient account storage |
| **DateTime API** | Modern Java LocalDateTime for accurate timestamps |
| **String Manipulation** | StringBuilder, formatting, and parsing operations |

---

## 💻 System Requirements

### Minimum Requirements
- **Java Version**: JDK 8 or higher
- **Operating System**: Windows, macOS, or Linux
- **RAM**: 2GB minimum
- **Disk Space**: ~10MB

### Recommended
- **Java Version**: JDK 17 or JDK 21 (LTS versions)
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code
- **RAM**: 4GB or higher

---

## 🚀 Installation & Setup

### Method 1: Using Command Line

```bash
# 1. Clone the repository
git clone https://github.com/yourusername/banking-system.git
cd banking-system

# 2. Compile the Java files
javac -d bin src/com/banking/*.java src/com/banking/model/*.java src/com/banking/service/*.java

# 3. Run the application
java -cp bin com.banking.Main
```

### Method 2: Using IDE (IntelliJ IDEA / Eclipse)

1. **Clone or Download** the repository
2. **Open IDE** → Import Project → Select `banking-system` folder
3. **Set Project SDK** to Java 17+ (or Java 8+)
4. **Navigate** to `src/com/banking/Main.java`
5. **Run** the `Main.java` file (Right-click → Run)

### Project Structure Setup

Ensure your folder structure looks like this:

```
banking-system/
├── src/
│   └── com/
│       └── banking/
│           ├── Main.java
│           ├── model/
│           │   ├── Account.java
│           │   ├── SavingsAccount.java
│           │   └── CurrentAccount.java
│           └── service/
│               └── BankService.java
├── data/
│   └── accounts.txt (auto-generated)
├── screenshots/
│   └── (your screenshots)
└── README.md
```

---

## 📖 Usage Guide

### Starting the Application

Run the `Main.java` file. You'll see the welcome screen:

```
╔════════════════════════════════════════════╗
║   WELCOME TO SECURE BANKING SYSTEM         ║
║   Developed by: B. Nikhil                  ║
╚════════════════════════════════════════════╝
```

### Main Menu Options

```
━━━━━━━━━━━━━━━ MAIN MENU ━━━━━━━━━━━━━━━
1. 🆕 Create New Account
2. 💵 Deposit Money
3. 💸 Withdraw Money
4. 🔄 Transfer Funds
5. 💰 Check Balance
6. 📊 View Transaction History
7. 📋 View All Accounts
8. 📈 Calculate Interest (Savings Only)
9. 🚪 Exit
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
```

### Example Operations

#### Creating a New Account
```
Enter choice: 1
Enter Account Holder Name: John Doe
Select Account Type: 1 (Savings)
Enter Initial Deposit: 5000

✅ Account created successfully!
📌 Account Number: ACC1001
```

#### Making a Deposit
```
Enter choice: 2
Enter Account Number: ACC1001
Enter Amount to Deposit: 2000

✅ ₹2000.0 deposited successfully!
Current Balance: ₹7000.0
```

#### Transferring Funds
```
Enter choice: 4
Enter Your Account Number: ACC1001
Enter Recipient Account Number: ACC1002
Enter Amount to Transfer: 1500

✅ ₹1500.0 transferred successfully!
Your Balance: ₹5500.0
```

---

## 📁 Project Structure

```
src/com/banking/
│
├── Main.java                          # Application entry point, UI handling
│   ├── displayMenu()                  # Shows main menu
│   ├── createAccount()                # Account creation flow
│   ├── deposit()                      # Deposit operation
│   ├── withdraw()                     # Withdrawal operation
│   ├── transferFunds()                # Fund transfer logic
│   └── Input validation methods
│
├── model/                             # Domain models
│   ├── Account.java                   # Abstract base class
│   │   ├── deposit()                  # Common deposit logic
│   │   ├── transfer()                 # Transfer between accounts
│   │   └── displayTransactionHistory()
│   │
│   ├── SavingsAccount.java            # Savings account implementation
│   │   ├── withdraw()                 # Override with min balance check
│   │   └── calculateInterest()        # 4% annual interest
│   │
│   └── CurrentAccount.java            # Current account implementation
│       ├── withdraw()                 # Override with overdraft feature
│       └── getAvailableBalance()      # Balance + overdraft limit
│
└── service/                           # Business logic layer
    └── BankService.java               # Banking operations
        ├── createAccount()            # Account creation
        ├── deposit()                  # Deposit service
        ├── withdraw()                 # Withdrawal service
        ├── transfer()                 # Transfer service
        ├── saveAccountsToFile()       # Data persistence
        └── loadAccountsFromFile()     # Load saved data
```

### Key Classes

| Class | Responsibility | Key Features |
|-------|---------------|--------------|
| **Main** | User interface & input handling | Menu display, input validation, user interaction |
| **Account** | Abstract base for all accounts | Common operations, transaction history, polymorphism |
| **SavingsAccount** | Savings account logic | Minimum balance (₹500), 4% interest calculation |
| **CurrentAccount** | Current account logic | Overdraft facility (₹5,000 limit) |
| **BankService** | Business logic coordinator | Account management, file I/O, data persistence |

---

## 🎓 OOP Concepts Demonstrated

### 1. **Encapsulation**
```java
private double balance;  // Private field
private String accountNumber;

public double getBalance() {  // Public getter
    return balance;
}

protected void setBalance(double balance) {  // Protected setter
    this.balance = balance;
}
```
**Benefits**: Data hiding, controlled access, maintains integrity

### 2. **Inheritance**
```java
// Base class
public abstract class Account { ... }

// Derived classes
public class SavingsAccount extends Account { ... }
public class CurrentAccount extends Account { ... }
```
**Benefits**: Code reuse, logical hierarchy, extensibility

### 3. **Polymorphism**
```java
// Method overriding - different behavior in each subclass
@Override
public boolean withdraw(double amount) {
    // SavingsAccount: Check minimum balance
    // CurrentAccount: Allow overdraft
}
```
**Benefits**: Flexible code, runtime behavior selection

### 4. **Abstraction**
```java
public abstract class Account {
    // Abstract method - must be implemented by subclasses
    public abstract boolean withdraw(double amount);
    
    // Concrete method - shared by all subclasses
    public boolean deposit(double amount) { ... }
}
```
**Benefits**: Hides complexity, enforces contract, clear interface

### 5. **Collections Framework**
```java
// HashMap for O(1) account lookup
private Map<String, Account> accounts = new HashMap<>();

// ArrayList for transaction history
private List<String> transactionHistory = new ArrayList<>();
```
**Benefits**: Efficient data storage, fast retrieval, dynamic sizing

---

## 📸 Screenshots

### Main Menu
![Main Menu](screenshots/1_main_menu.png)

### Creating Account
![Create Account](screenshots/2_create_account.png)

### All Accounts View
![All Accounts](screenshots/6_all_accounts.png)

### Transaction History
![Transaction History](screenshots/7_transaction_history.png)

### Interest Calculation
![Interest Calculation](screenshots/8_interest_calculation.png)

### Overdraft Feature (Current Account)
![Overdraft](screenshots/9_overdraft.png)

### Data Persistence
![Data Persistence](screenshots/12_data_persistence.png)

---

## 🔮 Future Enhancements

### Phase 1 - Security & Authentication
- [ ] Add user authentication (PIN/Password)
- [ ] Implement password encryption
- [ ] Add security questions for password recovery

### Phase 2 - Advanced Features
- [ ] Loan management system
- [ ] Fixed deposit functionality
- [ ] Recurring deposit accounts
- [ ] Credit/Debit card management

### Phase 3 - Reporting & Analytics
- [ ] Generate PDF account statements
- [ ] Monthly/Yearly transaction reports
- [ ] Account balance graphs and charts
- [ ] Export data to CSV/Excel

### Phase 4 - Modernization
- [ ] Convert to Spring Boot REST API
- [ ] Add web-based frontend (React/Angular)
- [ ] Database integration (MySQL/PostgreSQL)
- [ ] Mobile app integration
- [ ] SMS/Email notifications
- [ ] Multi-currency support

### Phase 5 - Advanced Banking
- [ ] ATM simulation module
- [ ] Cheque management
- [ ] Standing instructions/Auto-pay
- [ ] Investment tracking
- [ ] Bill payments integration

---

## 🧪 Testing

### Manual Testing Checklist

- [x] Create Savings Account with minimum deposit
- [x] Create Current Account with initial deposit
- [x] Deposit money into existing account
- [x] Withdraw with sufficient balance
- [x] Withdraw with insufficient balance (error handling)
- [x] Transfer between accounts successfully
- [x] Transfer with insufficient funds (error handling)
- [x] Calculate interest on savings account
- [x] Test overdraft on current account
- [x] View all accounts
- [x] View transaction history
- [x] Exit and restart (data persistence)

---

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

### Contribution Guidelines
- Follow Java naming conventions
- Add comments for complex logic
- Update README for new features
- Test thoroughly before submitting

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2024 B. Nikhil

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```

---

## 👨‍💻 Author

**B. Nikhil**  
Computer Science & Engineering Student  
Mahaveer Institute of Science & Technology

- 📧 Email: nikhil.b@example.com
- 💼 LinkedIn: [linkedin.com/in/b-nikhil](https://linkedin.com/in/b-nikhil)
- 🐱 GitHub: [@bnikhil](https://github.com/bnikhil)

---

## 🙏 Acknowledgments

- Inspired by real-world banking systems
- Built as a mini-project for learning Java and OOP concepts
- Special thanks to my mentor and guide for their support

---

## 📚 Learning Resources

This project helped me master:
- ✅ Core Java fundamentals and syntax
- ✅ Object-Oriented Programming principles
- ✅ File handling and data persistence
- ✅ Collections Framework (HashMap, ArrayList)
- ✅ Exception handling and error management
- ✅ Clean code practices and documentation
- ✅ Version control with Git and GitHub

### Recommended Resources
- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Effective Java by Joshua Bloch](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- [Java Collections Framework Guide](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/)

---

## ⭐ Show Your Support

If you found this project helpful or interesting, please consider giving it a ⭐️!

---

## 📞 Support

For questions, suggestions, or issues:
- Open an [Issue](https://github.com/yourusername/banking-system/issues)
- Contact me via [Email](mailto:nikhil.b@example.com)
- Connect on [LinkedIn](https://linkedin.com/in/b-nikhil)

---

**Built with ❤️ using Core Java**

*Last Updated: November 2024*

---

## 📊 Project Statistics

- **Language**: Java
- **Lines of Code**: ~600+
- **Files**: 5 Java classes
- **Development Time**: 2 weeks
- **Version**: 1.0.0
