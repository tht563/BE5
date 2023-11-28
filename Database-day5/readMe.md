1. Show film which dont have any screening
```SQL
SELECT film.name
FROM film JOIN screening ON film.id = screening.film_id
WHERE screening.is IS NULL;
```
2. Who book more than 1 seat in 1 booking
```SQL
SELECT DISTINCT customer.first_name. DISTINCT customer.last_name
FROM reserved_seat
JOIN booking ON booking.id = reserved_seat.booking_id
JOIN customer ON customer.id = booking.customer_id
GROUP BY reserved_seat.booking_id
HAVING COUNT(reserved_seat.eat_id)>1;
```
3. Show room show more than 2 film in one day
```SQL
SELECT DISTINCT room.name
FROM screening
JOIN room on room.id = screening.room_id
GROUP BY screening.room_id, date(screening.start_time)
HAVING COUNT(screening.film_id)>2;
```
4. Which room show the least film
``` SQL
SELECT room.name
FROM screening
JOIN room ON screening.room_id = room.id
GROUP BY screening.room_id
HAVING COUNT(screening.film_id) = (SELECT MIN(film_count)
                                    FROM
                                        (SELECT count(screening.film_id) AS film_count
                                          FROM screening
                                          GROUP BY screening.room_id
                                        ) as sub_table
                                    );
```
5. What film don't have booking
```SQL
SELECT film.name
FROM film
JOIN screening ON film.id = screening.film_id
LEFT JOIN booking On booking.id = screening.id
WHERE booking.id IS NULL;
```
6. WHAT film have show the biggest number of room?
```SQL
SELECT film.name
FROM film
JOIN screening ON screening.film_id = film.id
GROUP BY screening.film_id
HAVING COUNT(screening.film_id) = (SELECT MAX (film_count)
                                   FROM
                                        (SELECT count(screening.film_id) AS film_count
                                          FROM screening
                                          GROUP BY screening.film_id
                                          ) as sub_table
                                  );
```
7. Show number of film  that show in every day of week and order descending
```SQL
select date(start_time) as date, count(distinct film_id) as total_film
from screening
group by date
order by date asc, total_film desc;
```
8. Show total length of each film that showed in 28/5/2022
SELECT film.name, SUM(film.length_min), DATE(screening.start_time) as date_start
FROM film
JOIN screening ON screening.film_id = film.id
GROUP BY screening.film_id, date_start
HAVING date_start = '2022-5-28';
9. What film has showing time above and below average show time of all film
```SQL
SELECT name
FROM film
WHERE length_min > (SELECT AVG(length_min)
					          FROM film
                    JOIN screening ON film.id = screening.film_id);
SELECT name
FROM film
WHERE length_min < (SELECT AVG(length_min)
					          FROM film
                    JOIN screening ON film.id = screening.film_id);
```
10. What room have least number of seat?
```SQL
SELECT room.name
FROM room
WHERE room.no_seats = (SELECT MAX(room.no_seats) from room);
```
11. What room have number of seat bigger than average number of seat of all rooms
