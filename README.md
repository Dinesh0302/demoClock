# demoClock
# Speaking Clock

The Speaking Clock project is a simple application that converts the current time into words. 
It allows users to input the time in a 24-hour clock format and receive the corresponding time in words.

## Technologies Used

- Java 17
- Spring Boot
- Maven
- OpenAPI - Swagger



Open a web browser and go to [http://localhost:8080]

- `GET /convert`: Converts the Current time in a 24-hour clock format to words.
  - Request Parameter:
    - `time`: The time to convert (e.g., "20:26").
  - Example: `GET /convert
  -  It's twenty-one twenty-six minutes

- `GET /giventime`: Converts the Current time in a 24-hour clock format to words and Return Midday or Midnight
  - Request Parameter:
    - `time`: The time to give (e.g., "09:26").
  - Example: `GET /givenTime?time=09:33
  -  Midday ( response)



## Authors
- Dinesh Suvarna
- dineshsuvarna0302@gmail.com
