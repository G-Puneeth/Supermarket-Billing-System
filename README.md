# SMBS - Supermarket Billing and Inventory Management System

A comprehensive system for managing store operations, customer data, transactions, and billing. Currently in development with plans to integrate machine learning (for sales predictions) and PowerBI (for analytics dashboards).

## 🛠️ Current Implementation
### Database Schema (MySQL)
- **Admin Users**: Role-based access control (`Admin`/`Manager`)
- **Customers**: Membership tiers (`Regular`, `Gold`, `Platinum`)
- **Products**: Inventory tracking with pricing and discounts
- **Transactions**: Sales records with itemized breakdowns

### Java Component
- Basic billing system shell (to be expanded with GUI/API connectivity)

## 🔧 Setup Instructions
### Prerequisites
- MySQL Server
- Java JDK 8+

### Database Initialization
1. Create the database:
   ```sql
   CREATE DATABASE SMBS;
2. Run all provided .sql files in this order:
   DATABASE_SMBS.sql
   Customers table.sql
   Products table.sql
   Transactions table.sql
   Transaction items.sql
   Admin table.sql  
  
### Java Execution   
javac Billing.java
java Billing

### 🚧 Upcoming Features
Frontend (React/JavaFX) integration
Machine Learning for demand forecasting
PowerBI analytics dashboard
REST API for mobile access

### 📂 Project Structure
smbs-system/
├── Database/
│   ├── Admin table.sql
│   ├── Customers table.sql
│   ├── Products table.sql
│   └── ...other SQL files
├── Java/
│   └── Billing.java (core logic)
└── (Future directories for ML/PowerBI)

### 🔮 Future Integrations
# Sample command for future ML integration (Python)
python demand_forecast.py --data-dir ./sales_history.csv
