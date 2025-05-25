# GP Management System

A Java Swing-based GUI application designed to assist General Practitioners (GPs) with managing patient visit details, prescriptions, and appointment bookings. Built as a university group project with a focus on modular design, user interface interaction, and robust testing.

---

## Features

- **Secure Login System - for GPs with credential validation
- **Enter & Edit Visit Details** including prescriptions
- **View Past Visit Information** using booking IDs
- **Book Appointment Slots** by month and year
- **Main Menu Navigation** to easily traverse between pages
- **Persistent Database Integration** for visit data and user accounts

---

## 🧪 Testing

This project includes a comprehensive suite of **JUnit test classes** to ensure core functionality and security across multiple modules:

- `loginFrameTest.java`: Validates login credential scenarios
- `ViewVisitDetailsFrameTest.java`: Tests booking ID inputs
- `EditVisitDetailsFrameTest.java`: Tests update logic and form validation
- `EnterVisitDetailsAndPrescriptionsTest.java`: Confirms dialog and confirmation functionality
- `bookingFrameTest.java`: Tests search logic by date
- `menuFrameTest.java`: Checks logout and redirection flow

---

## 👨‍💻 My Role

As the primary test engineer and contributor:

- ✅ I developed all **JUnit test classes** to ensure form validation, security, and database interactions functioned correctly.
- ✅ I built two full GUI modules from scratch:
  - `ViewVisitDetailsFrame.java`
  - `EditVisitDetailsFrame.java`
- ✅ I contributed to **cross-page integration**, ensuring seamless flow between pages.
- ✅ I updated the **database structure** where needed to support visit/prescription data handling.

---

## 🛠️ Tech Stack

- **Language**: Java (JDK 8+)
- **GUI**: Swing
- **Database**: MySQL (via `DBManager`)
- **Testing**: JUnit 4
- **Version Control**: Git & GitHub
