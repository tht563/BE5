### HomeWork SQL:
1. Show film name ONLY which has screening
```SQL
SELECT film.name
FROM screening
JOIN film ON screening.film_id = film.id;
```
2. Show Room name with all seat row and seat column of "Room 2"
```SQL
SELECT room.name, seat.row, seat.number
FROM seat
JOIN screening ON seat.room_id = room_id
WHERE room.name = 'Room 2';
```
3. Show all Screening Infomation including film name, room name, time of film "Tom&Jerry"
```SQL
SELECT room.name, film.name, screening.start_time
FROM film
JOIN screening ON film.id = screening.film_id
JOIN room ON screening.room_id = room.id
```
4. Show what seat that customer "Dung Nguyen" booked
```SQL
SELECT room.name, seat.row, seat.number
FROM customer
JOIN booking ON customer.id = booking.customer_id
JOIN reserved_seat ON booking.id = reserved_seat.booking_id
JOIN seat ON reserved_seat.seat_id = seat.id
JOIN room ON seat.room_id = room.id
WHERE first_name = 'Nguyen' AND last_name = 'Dung';
```
5. How many film that showed in 24/5/2022
```SQL
SELECT COUNT(DISTINCT(film.id))
FROM film
JOIN screening ON film.id = screening.film_id
WHERE (screening.start_time>='00:00:00 24/5/2022') and (screening.start_time<='23:59:59 24/5/2022');
```
6. What is the maximum length and minimum length of all film
```SQL
SELECT MAX(length_min) as the_maximum_length, MIN(length_min) as the_minimum_length
FROM film;
```
7. How many seat of Room 7
```SQL
SELECT no_seats
FROM room
WHERE name = 'Room 7';
```
8. Total seat are booked of film "Tom&Jerry"
```SQL
SELECT COUNT(reserved_seat.seat_id)
FROM reserved_seat
JOIN seat ON reserved_seat.seat_id = seat.id
JOIN room ON seat.room_id = room.id
JOIN screening ON room.id = screening.room_id
JOIN film ON screening.film_id = film.id
WHERE film.name = 'Tom&Jerry';
```
