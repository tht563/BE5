### HomeWork SQL:
1. Show film name ONLY which has screening
```SQL
SELECT film.name
FROM screening JOIN film ON screening.film_id = film.id;
```
2. Show Room name with all seat row and seat column of "Room 2"
```SQL
SELECT room.name, seat.row, seat.number
FROM seat JOIN screening ON seat.room_id = room_id
WHERE room.name = 'Room 2';
```
3. Show all Screening Infomation including film name, room name, time of film "Tom&Jerry"
```SQL
SELECT room.name, film.name, screening.start_time

```
5. Show what seat that customer "Dung Nguyen" booked
6. How many film that showed in 24/5/2022
7. What is the maximum length and minumum length of all film
8. How many seat of Room 7
9. Total seat are booked of film "Tom&Jerry"
