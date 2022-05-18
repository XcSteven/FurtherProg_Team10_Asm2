insert into driver (created_date, license, phone, rating) values (CURRENT_TIMESTAMP ,'DRIVER 1', '01111110', 1);
insert into driver (created_date, license, phone, rating) values (CURRENT_TIMESTAMP ,'DRIVER 2', '02222220', 2);
insert into driver (created_date, license, phone, rating) values (CURRENT_TIMESTAMP ,'DRIVER 3', '0333330', 3);
insert into driver (created_date, license, phone, rating) values (CURRENT_TIMESTAMP ,'DRIVER 4', '04444440', 4);
insert into driver (created_date, license, phone, rating) values (CURRENT_TIMESTAMP ,'DRIVER 5', '05555565', 5);
insert into driver (created_date, license, phone, rating) values (CURRENT_TIMESTAMP ,'DRIVER 6', '666666', 6);
insert into driver (created_date, license, phone, rating) values (CURRENT_TIMESTAMP  ,'DRIVER 7', '777777', 7);

insert into car (created_date, vehicleId, make, model, color, convertible, rating, licensePlate, ratePerKm) values (CURRENT_TIMESTAMP ,'92721902','BMW', 'X1', 'white', false, 3.6, '9272.1902', 5.4);
insert into car (created_date, vehicleId, make, model, color, convertible, rating, licensePlate, ratePerKm) values (CURRENT_TIMESTAMP ,'65416841','Nissan', 'X2', 'black', false, 8.8, '6541.6841', 12);
insert into car (created_date, vehicleId, make, model, color, convertible, rating, licensePlate, ratePerKm) values (CURRENT_TIMESTAMP ,'97655431','Audi', 'X3', 'red', true, 7.5, '9765.5431', 8.3);
insert into car (created_date, vehicleId, make, model, color, convertible, rating, licensePlate, ratePerKm) values (CURRENT_TIMESTAMP ,'97136129','Toyota', 'X4', 'white', false, 5.2, '9713.6129', 11);
insert into car (created_date, vehicleId, make, model, color, convertible, rating, licensePlate, ratePerKm) values (CURRENT_TIMESTAMP ,'21354657','Toyota', 'X5', 'black', true, 9, '2135.4657', 10.7);
insert into car (created_date, vehicleId, make, model, color, convertible, rating, licensePlate, ratePerKm) values (CURRENT_TIMESTAMP ,'54685542','Audi', 'X6', 'white', false, 8.6, '5468.5542', 9.8);
insert into car (created_date, vehicleId, make, model, color, convertible, rating, licensePlate, ratePerKm) values (CURRENT_TIMESTAMP ,'36876388','BMW', 'X7', 'black', true, 7.4, '3687.6388', 15);
insert into car (created_date, vehicleId, make, model, color, convertible, rating, licensePlate, ratePerKm) values (CURRENT_TIMESTAMP ,'41324687','Lamborghini', 'X8', 'blue', false, 6.5, '4132.4687', 32.6);
insert into car (created_date, vehicleId, make, model, color, convertible, rating, licensePlate, ratePerKm) values (CURRENT_TIMESTAMP ,'31525526','Vinfast', 'X9', 'white', false, 8.3, '3152.5526', 6);

insert into customer (created_date, name, address, phone) values (CURRENT_TIMESTAMP, 'Andy The First', '1 Street, Ward, City', '01111111111');
insert into customer (created_date, name, address, phone) values (CURRENT_TIMESTAMP, 'Daniel The Second', '2 Street, Ward, City', '0222222222');
insert into customer (created_date, name, address, phone) values (CURRENT_TIMESTAMP, 'Anna The Third', '3 Street, Ward, City', '03333333333');
insert into customer (created_date, name, address, phone) values (CURRENT_TIMESTAMP, 'John The Forth', '4 Street, Ward, City', '0444444444');
insert into customer (created_date, name, address, phone) values (CURRENT_TIMESTAMP, 'Wayne The Fifth', '5 Street, Ward, City', '05555555555');


insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('05 12 2022', 'dd MM YYYY'), 'D1', 'D3', '1PM', '1:30PM', 5, '2');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('12 11 2022', 'dd MM YYYY'), 'D2', 'D2', '1AM', '2:30AM', 1, '3');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('13 10 2022', 'dd MM YYYY'), 'D3', 'D3', '3PM', '6PM', 1.2, '2');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('16 09 2022', 'dd MM YYYY'), 'D4', 'D4', '5AM', '5:30AM', 0.3, '2');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('18 08 2022', 'dd MM YYYY'), 'D5', 'D3', '8AM', '8:30AM', 1.6, '4');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('12 07 2022', 'dd MM YYYY'), 'D6', 'D4', '4PM', '5PM', 1.8, '5');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('22 06 2022', 'dd MM YYYY'), 'D7', 'D3', '2AM', '2:30AM', 1.4, '4');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('15 05 2022', 'dd MM YYYY'), 'D8', 'D6', '8AM', '8:30AM', 1.2, '3');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('17 04 2022', 'dd MM YYYY'), 'D9', 'D3', '3AM', '4AM', 1.1, '4');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('25 03 2022', 'dd MM YYYY'), 'D4', 'D3', '1PM', '1:30PM', 2.4, '5');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('28 02 2022', 'dd MM YYYY'), 'D8', 'D6', '3AM', '4AM', 4.8, '4');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('29 01 2022', 'dd MM YYYY'), 'D3', 'D9', '7AM', '8AM', 5.6, '1');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('15 02 2022', 'dd MM YYYY'), 'D1', 'D3', '4PM', '4:30PM', 4, '1');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('11 03 2022', 'dd MM YYYY'), 'D5', 'D7', '9AM', '10AM', 2, '1');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('06 04 2022', 'dd MM YYYY'), 'D7', 'D9', '3AM', '5:30AM', 1, '3');
insert into booking (created_date, startLocation, endLocation, startTime, endTime, distance, customer_id) values (to_timestamp('02 05 2022', 'dd MM YYYY'), 'D2', 'D7', '1PM', '5PM', 3.4, '2');



















