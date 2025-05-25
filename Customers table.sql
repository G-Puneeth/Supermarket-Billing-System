USE smbs;
CREATE TABLE Customers (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Phone VARCHAR(15) UNIQUE,
    Address TEXT,
    MembershipStatus ENUM('Regular', 'Gold', 'Platinum') DEFAULT 'Regular',
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
