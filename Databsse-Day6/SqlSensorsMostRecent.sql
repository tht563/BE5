drop table plays;
drop table reservations;
create table plays(
	id integer not null, 
    title varchar(40) not null,
    writer varchar(40) not null,
    unique(id)
);

create table reservations(
	id integer not null,
    play_id integer not null,
    number_of_tickets integer not null,
    theater varchar(40) not null,
    unique(id)
);

insert into plays(id, title, writer)
values
(109,'Queens and Kings of Madagascar','Paul Sat'),
(123, 'Merlin', 'Lee Roy'),
(142,'Key of the tea','Max Rogers'),
(144,'ROMEance Comedy','Bohring Ashell'),
(145,'Nameless','Note Null');

insert into reservations (id, play_id, number_of_tickets, theater)
values
(13,109,12,'Mc Rayleigh Theater'),
(24,109,34,'Mc Rayleigh Theater'),
(37,145,84,'Mc Rayleigh Theater'),
(49,145,45,'Mc Rayleigh Theater'),
(51,145,41,'Mc Rayleigh Theater'),
(68,123,3,'Mc Rayleigh Theater'),
(83,142,46,'Mc Rayleigh Theater');

drop table plays;
drop table reservations;
create table plays(
	id integer not null, 
    title varchar(40) not null,
    writer varchar(40) not null,
    unique(id)
);

create table reservations(
	id integer not null,
    play_id integer not null,
    number_of_tickets integer not null,
    theater varchar(40) not null,
    unique(id)
);

insert into plays(id, title, writer)
values
(34,'The opera of the phantom','Lero Gastonx'),
(35,'The legend of the cake','Oscar Glad'),
(36,'Stone Swords','Arthur King');

insert into reservations (id, play_id, number_of_tickets, theater)
values
(10,36,13,'Arthur King Theater'),
(30,35,20,'The Legend Theater'),
(31,36,21,'The Legend Theater'),
(32,35,23,'The Legend Theater'),
(33,36,19,'The Legend Theater'),
(40,34,29,'The Jupiter Assembly Theater'),
(41,34,19,'The Jupiter Assembly Theater'),
(42,34,6,'The Jupiter Assembly Theater');

select plays.id, plays.title, sum(
case
	when reservations.number_of_tickets is not null then reservations.number_of_tickets
    else 0
end
) as reserved_tickets
from plays
left join reservations
on plays.id = reservations.play_id
group by plays.id
order by reserved_tickets desc, reservations.play_id asc;
