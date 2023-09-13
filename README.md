
User Story 1: As a customer I want to be able to request a booking at this restaurant.

curl --location 'http://localhost:8080/api/bookings/create' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'customerName=test1' \
--data-urlencode 'tableSize=1' \
--data-urlencode 'date=2023-09-15' \
--data-urlencode 'time=18.30'





User Story 2: As the restaurant owner I want to be able to see all bookings for a particular day.

curl --location 'http://localhost:8080/api/bookings/get?date=2023-09-15'