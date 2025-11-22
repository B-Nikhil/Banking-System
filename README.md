\# 🏦 Console-Based Banking Management System



!\[Java](https://img.shields.io/badge/Java-17+-orange.svg)

!\[Status](https://img.shields.io/badge/Status-Complete-success.svg)

!\[License](https://img.shields.io/badge/License-MIT-blue.svg)



A robust, feature-rich banking management system built with \*\*Core Java\*\*, demonstrating essential Object-Oriented Programming principles and real-world application development skills.



---



\## 📋 Table of Contents



\- \[Overview](#-overview)

\- \[Features](#-features)

\- \[Technical Highlights](#-technical-highlights)

\- \[System Requirements](#-system-requirements)

\- \[Installation \& Setup](#-installation--setup)

\- \[Usage Guide](#-usage-guide)

\- \[Project Structure](#-project-structure)

\- \[OOP Concepts Demonstrated](#-oop-concepts-demonstrated)

\- \[Screenshots](#-screenshots)

\- \[Future Enhancements](#-future-enhancements)

\- \[Author](#-author)



---



\## 🎯 Overview



This Console-Based Banking System is a comprehensive Java application that simulates real-world banking operations. It provides a complete suite of banking functionalities including account management, transactions, fund transfers, and persistent data storage.



The project showcases strong \*\*Object-Oriented Programming (OOP)\*\* principles, clean code architecture, and practical implementation of Java's core features.



---



\## ✨ Features



\### 🔐 Account Management

\- \*\*Create Account\*\*: Support for Savings and Current accounts

\- \*\*Account Types\*\*:

&nbsp; - \*\*Savings Account\*\*: 4% annual interest, minimum balance requirement (₹500)

&nbsp; - \*\*Current Account\*\*: Overdraft facility up to ₹5,000



\### 💰 Banking Operations

\- \*\*Deposit Money\*\*: Add funds to any account

\- \*\*Withdraw Money\*\*: Withdraw with balance validation

\- \*\*Transfer Funds\*\*: Transfer money between accounts

\- \*\*Check Balance\*\*: View current account balance

\- \*\*Transaction History\*\*: Complete audit trail of all transactions



\### 📊 Advanced Features

\- \*\*Interest Calculation\*\*: Automatic interest calculation for savings accounts

\- \*\*Overdraft Management\*\*: Current accounts can go negative up to limit

\- \*\*Data Persistence\*\*: All data saved to file and loaded on startup

\- \*\*Input Validation\*\*: Robust error handling and validation

\- \*\*Professional UI\*\*: Clean, formatted console interface



---



\## 🛠 Technical Highlights



This project demonstrates proficiency in:



| Concept | Implementation |

|---------|---------------|

| \*\*OOP Principles\*\* | Encapsulation, Inheritance, Polymorphism, Abstraction |

| \*\*Collections\*\* | HashMap for efficient account storage and retrieval |

| \*\*File I/O\*\* | Reading/Writing account data to persistent storage |

| \*\*Exception Handling\*\* | Try-catch blocks for robust error management |

| \*\*Design Patterns\*\* | Service Layer pattern for business logic separation |

| \*\*Data Structures\*\* | Lists for transaction history, Maps for account lookup |

| \*\*DateTime API\*\* | Modern Java time handling for timestamps |



---



\## 💻 System Requirements



\- \*\*Java Version\*\*: JDK 8 or higher (Recommended: JDK 17+)

\- \*\*Operating System\*\*: Windows, macOS, or Linux

\- \*\*IDE (Optional)\*\*: IntelliJ IDEA, Eclipse, VS Code, or any text editor

\- \*\*Disk Space\*\*: ~5MB



---



\## 🚀 Installation \& Setup



\### Method 1: Using Command Line



```bash

\# 1. Clone the repository

git clone https://github.com/yourusername/banking-system.git

cd banking-system



\# 2. Compile the Java files

javac -d bin src/com/banking/\*.java src/com/banking/model/\*.java src/com/banking/service/\*.java



\# 3. Run the application

java -cp bin com.banking.Main

```



\### Method 2: Using IDE (IntelliJ IDEA / Eclipse)



1\. \*\*Open IDE\*\* → Import Project → Select `banking-system` folder

2\. \*\*Set Project SDK\*\* to Java 17+ (or Java 8+)

3\. \*\*Run\*\* the `Main.java` file



\### Project Structure Setup



Ensure your folder structure looks like this:



```

BankingSystem/

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

└── README.md

```



---



\## 📖 Usage Guide



\### Starting the Application



Run the `Main.java` file. You'll see the welcome screen:



```

╔════════════════════════════════════════════╗

║   WELCOME TO SECURE BANKING SYSTEM         ║

║   Developed by: B. Nikhil                  ║

╚════════════════════════════════════════════╝

```



\### Main Menu Options



```

━━━━━━━━━━━━━━━ MAIN MENU ━━━━━━━━━━━━━━━

1\. 🆕 Create New Account

2\. 💵 Deposit Money

3\. 💸 Withdraw Money

4\. 🔄 Transfer Funds

5\. 💰 Check Balance

6\. 📊 View Transaction History

7\. 📋 View All Accounts

8\. 📈 Calculate Interest (Savings Only)

9\. 🚪 Exit

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

```



\### Example Workflow



\#### 1️⃣ Create a New Account

```

Enter choice: 1

Enter Account Holder Name: John Doe

Select Account Type:

1\. Savings Account (Interest: 4% per annum)

2\. Current Account (No interest, Overdraft allowed)

Enter choice (1 or 2): 1

Enter Initial Deposit (Min ₹500): 5000



✅ Account created successfully!

📌 Account Number: ACC1001

📌 Account Holder: John Doe

📌 Account Type: SAVINGS

📌 Initial Balance: ₹5000.0

```



\#### 2️⃣ Deposit Money

```

Enter choice: 2

Enter Account Number: ACC1001

Enter Amount to Deposit: ₹2000



✅ ₹2000.0 deposited successfully!

Current Balance: ₹7000.0

```



\#### 3️⃣ Transfer Funds

```

Enter choice: 4

Enter Your Account Number: ACC1001

Enter Recipient Account Number: ACC1002

Enter Amount to Transfer: ₹1500



✅ ₹1500.0 transferred successfully!

Your Balance: ₹5500.0

```



---



\## 📁 Project Structure



```

src/com/banking/

│

├── Main.java                          # Application entry point, UI handling

│

├── model/                             # Domain models

│   ├── Account.java                   # Abstract base class for all accounts

│   ├── SavingsAccount.java            # Savings account with interest

│   └── CurrentAccount.java            # Current account with overdraft

│

└── service/                           # Business logic layer

&nbsp;   └── BankService.java               # Banking operations and data management

```



\### Key Classes



| Class | Purpose | Key Methods |

|-------|---------|-------------|

| \*\*Main\*\* | Entry point, user interface | `displayMenu()`, `createAccount()`, `deposit()` |

| \*\*Account\*\* | Abstract base class | `deposit()`, `withdraw()`, `transfer()` |

| \*\*SavingsAccount\*\* | Savings account implementation | `withdraw()`, `calculateInterest()` |

| \*\*CurrentAccount\*\* | Current account implementation | `withdraw()`, `getAvailableBalance()` |

| \*\*BankService\*\* | Business logic \& operations | `createAccount()`, `transfer()`, `saveAccountsToFile()` |



---



\## 🎓 OOP Concepts Demonstrated



\### 1. \*\*Encapsulation\*\*

```java

private double balance;  // Private fields

public double getBalance() { return balance; }  // Public getters

```



\### 2. \*\*Inheritance\*\*

```java

public class SavingsAccount extends Account { ... }

public class CurrentAccount extends Account { ... }

```



\### 3. \*\*Polymorphism\*\*

```java

@Override

public boolean withdraw(double amount) {

&nbsp;   // Different implementation in each subclass

}

```



\### 4. \*\*Abstraction\*\*

```java

public abstract class Account {

&nbsp;   public abstract boolean withdraw(double amount);

}

```



\### 5. \*\*Collections Framework\*\*

```java

private Map<String, Account> accounts = new HashMap<>();

private List<String> transactionHistory = new ArrayList<>();

```



---



\## 📸 Screenshots



\### Main Menu

```

━━━━━━━━━━━━━━━ MAIN MENU ━━━━━━━━━━━━━━━

1\. 🆕 Create New Account

2\. 💵 Deposit Money

3\. 💸 Withdraw Money

4\. 🔄 Transfer Funds

...

```



\### Account Information Display

```

┌─────────────────────────────────────────┐

│         ACCOUNT INFORMATION             │

├─────────────────────────────────────────┤

│ Account Number  : ACC1001               │

│ Holder Name     : John Doe              │

│ Account Type    : SAVINGS               │

│ Balance         : ₹5000.00              │

│ Created Date    : 2024-01-15 10:30      │

└─────────────────────────────────────────┘

```



\### All Accounts View

```

╔════════════════════════════════════════════════════════════════════╗

║                        ALL BANK ACCOUNTS                           ║

╠════════════════════════════════════════════════════════════════════╣

║ A/C Number   ║ Holder Name          ║ Type       ║ Balance      ║

╠════════════════════════════════════════════════════════════════════╣

║ ACC1001      ║ John Doe             ║ SAVINGS    ║ ₹5000.00     ║

║ ACC1002      ║ Jane Smith           ║ CURRENT    ║ ₹7500.00     ║

╚════════════════════════════════════════════════════════════════════╝

```



---



\## 🔮 Future Enhancements



\- \[ ] Add user authentication (PIN/Password)

\- \[ ] Implement loan management system

\- \[ ] Add fixed deposit functionality

\- \[ ] Generate PDF account statements

\- \[ ] Multi-currency support

\- \[ ] SMS/Email notifications

\- \[ ] ATM simulation module

\- \[ ] Convert to Spring Boot REST API

\- \[ ] Add web-based frontend (React/Angular)

\- \[ ] Database integration (MySQL/PostgreSQL)



---



\## 🤝 Contributing



Contributions are welcome! Feel free to:

1\. Fork the repository

2\. Create a feature branch (`git checkout -b feature/NewFeature`)

3\. Commit your changes (`git commit -m 'Add NewFeature'`)

4\. Push to the branch (`git push origin feature/NewFeature`)

5\. Open a Pull Request



---



\## 📄 License



This project is licensed under the MIT License - feel free to use it for learning and development purposes.



---



\## 👨‍💻 Author



\*\*B. Nikhil\*\*  

Computer Science \& Engineering Student  

Mahaveer Institute of Science \& Technology



\- 📧 Email: nikhil.b@example.com

\- 💼 LinkedIn: \[linkedin.com/in/b-nikhil](https://linkedin.com/in/b-nikhil)

\- 🐱 GitHub: \[@bnikhil](https://github.com/bnikhil)



---



\## ⭐ Show Your Support



If you found this project helpful, please give it a ⭐️!



---



\## 📚 Learning Resources



This project helped me learn:

\- Core Java fundamentals

\- Object-Oriented Programming principles

\- File handling and data persistence

\- Collections Framework

\- Exception handling

\- Clean code practices



---



\*\*Built with ❤️ using Core Java\*\*



\*Last Updated: November 2024\*

