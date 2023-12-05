DROP TABLE buses;
DROP TABLE passengers;
CREATE TABLE buses(
	id integer primary key,
    origin varchar(40) not null,
    destination varchar(40) not null,
    time varchar(40) not null,
    unique (origin, destination, time)
);

CREATE TABLE passengers(
	id integer primary key,
    origin varchar(40) not null,
    destination varchar(40) not null,
    time varchar(40) not null
);

INSERT INTO buses(id, origin, destination, time)
VALUES
(10,'Warsaw','Berlin','10:55'),
(20,'Berlin','Paris','06:20'),
(21,'Berlin','Paris','14:00'),
(22,'Berlin','Paris','21:40'),
(30,'Paris','Madrid','13:30');

INSERT INTO passengers(id, origin, destination,time) 
VALUES
(1,'Paris','Madrid','13:30'),
(2,'Paris','Madrid','13:31'),
(10,'Warsaw','Paris','10:00'),
(11,'Warsaw','Berlin','22:31'),
(40,'Berlin','Paris','06:15'),
(41,'Berlin','Paris','06:50'),
(42,'Berlin','Paris','07:12'),
(43,'Berlin','Paris','12:03'),
(44,'Berlin','Paris','20:00');

WITH info (id, time_diff) AS
(SELECT passengers.id AS id,  MAX(passengers.time - buses.time) AS time_diff
FROM buses JOIN passengers
ON buses.origin = passengers.origin AND buses.destination = passengers.destination AND buses.time>=passengers.time
GROUP BY passengers.id)

SELECT buses.id, 
SUM(CASE
	WHEN passengers.time-buses.time = time_diff THEN 1
    ELSE 0
END) AS passengers_on_bus
FROM buses 
LEFT JOIN passengers ON buses.origin = passengers.origin 
LEFT JOIN info ON passengers.id = info.id AND (passengers.time-buses.time = info.time_diff OR info.time_diff IS NULL)
GROUP BY buses.id
ORDER BY buses.id;

DROP TABLE passengers;
DROP TABLE buses;
CREATE TABLE buses(
	id integer primary key,
    origin varchar(40) not null,
    destination varchar(40) not null,
    time varchar(40) not null,
    unique (origin, destination, time)
);

CREATE TABLE passengers(
	id integer primary key,
    origin varchar(40) not null,
    destination varchar(40) not null,
    time varchar(40) not null
);

INSERT INTO buses(id, origin, destination, time)
VALUES
(100,'Munich','Rome','13:00'),
(200,'Munich','Rome','15:30'),
(300,'Munich','Rome','20:00');


INSERT INTO passengers(id, origin, destination,time) 
VALUES
(1,'Munich','Rome','10:01'),
(2,'Munich','Rome','11:30'),
(3,'Munich','Rome','11:30'),
(4,'Munich','Rome','12:03'),
(5,'Munich','Rome','13:00');

WITH info (id, time_diff) AS
(SELECT passengers.id AS id,  MAX(passengers.time - buses.time) AS time_diff
FROM buses JOIN passengers
ON buses.origin = passengers.origin AND buses.destination = passengers.destination AND buses.time>=passengers.time
GROUP BY passengers.id)

SELECT buses.id, 
SUM(CASE
	WHEN passengers.time-buses.time = time_diff THEN 1
    ELSE 0
END) AS passengers_on_bus
FROM buses 
LEFT JOIN passengers ON buses.origin = passengers.origin 
LEFT JOIN info ON passengers.id = info.id AND (passengers.time-buses.time = info.time_diff OR info.time_diff IS NULL)
GROUP BY buses.id
ORDER BY buses.id;




