# Financial Services Application

This repository contains the Financial Services Application, a comprehensive example of integrating Apache CXF with Spring Boot to create a secure, scalable, and efficient web services platform. This project demonstrates the practical use of CXF for both SOAP and REST APIs, implementing a variety of financial calculations and services.

## Course Details

- **Course Name**: Service-oriented Software Engineering (SoSE)
- **Institution**: University of L'Aquila
- **Focus**: This course covers principles of service-oriented architectures, integrating security in web services, and using frameworks like Apache CXF for service implementation.

## Key Features

- **Currency Conversion (SOAP):** Allows users to convert amounts between different currencies using predefined exchange rates. This service uses Apache CXF with WS-Security for secure SOAP message transmissions.

- **Loan Calculation (SOAP):** Provides calculations for loan payments based on input parameters such as principal, interest rate, term, and optional balloon payments. This service utilizes WS-Security for ensuring the confidentiality and integrity of the transactional data.

- **Investment Prediction (REST):** Offers predictions on investment returns based on amount, risk level, investment duration, and other factors. It showcases the integration of RESTful services with Spring Security for authentication and authorization.

## Technologies Used

- **Apache CXF:** Used for creating SOAP and REST web services.
- **Spring Boot:** Simplifies the setup and development of new Spring applications.
- **Spring Security:** Handles authentication and authorization for REST endpoints.
- **Maven:** Manages dependencies and project lifecycle.

## Getting Started

To get a local copy up and running, follow these simple steps:

1. **Clone the repository:**
   ```bash
   git clone adam-bouafia/Securing-SOAP-and-REST-Services-with-Apache-CXF.git

2. **Navigate to the project directory:**   
   ```bash
   cd financial-services-app

3. **Build the project:**   
   ```bash
   mvn clean install

4. **Run the application:**   
   ```bash
   mvn spring-boot:run

5. **Access the services at:**   
   ```bash
   SOAP services: http://localhost:8080/FinancialServices/services/FinancialServices
   REST services: http://localhost:8080/FinancialServices/services/api


## Contributing
Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.
