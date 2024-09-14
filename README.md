# API Automation for FanCode City

## Overview
This framework automates the scenario to check if users from FanCode city have completed more than 50% of their TODO tasks.

## Project Structure
- `/api`: Contains classes for making API calls to the users and todos endpoints.
- `/models`: POJO classes for deserializing API responses.
- `/utils`: Helper methods like geographic coordinate checks.
- `/tests`: Test classes to validate the required scenario.

## How to Run
1. Clone the repository.
2. Ensure Java, Maven, and TestNG are installed or ensure the dependency get downloaded.
3. Run `mvn clean test` to execute the tests.
4. View the results in the `/test-output` folder.