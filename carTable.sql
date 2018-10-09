use automotive;
go

if object_id('cars', 'U') is not null
	drop table cars;
go

CREATE TABLE cars
(
	id int identity(1,1) primary key not null,
	makeModel nvarchar(100) not null,
	engineSize decimal(3,1) not null,
	fuelType nvarchar(20) not null,
	Constraint chk_val CHECK (fuelType in ('Gasoline', 'Diesel', 'Propane', 'Other'))
);
go