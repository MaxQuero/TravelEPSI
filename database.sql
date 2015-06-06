drop database if exists TravelEPSI;

create database if not exists TravelEPSI;
use TravelEPSI;

create table if not exists users  (
  id integer AUTO_INCREMENT PRIMARY KEY,
  login varchar(25) NOT NULL,
  password varchar(50) NOT NULL,
  firstname varchar(20) NOT NULL,
  lastname varchar(20) NOT NULL,
  birthday date,
  mail varchar(70) NOT NULL,
  phone varchar(10)
);

create table if not exists packages (
  id integer AUTO_INCREMENT PRIMARY KEY,
  wording text NOT NULL
);

create table if not exists quotes (
  id integer AUTO_INCREMENT PRIMARY KEY,
  total_price_ht decimal,
  package_id integer,
  user_id integer,

  constraint foreign key(package_id) references packages(id) on delete cascade on update cascade,
  constraint foreign key(user_id) references users(id) on delete cascade on update cascade
);

create table if not exists services (
  id integer AUTO_INCREMENT PRIMARY KEY,
  wording text NOT NULL
);

create table if not exists periods (
  id integer AUTO_INCREMENT PRIMARY KEY,
  startDT date NOT NULL,
  endDT date NOT NULL
);

create table if not exists orders (
  id integer AUTO_INCREMENT PRIMARY KEY,
  package_id integer,
  service_id integer,
  nb_total_place integer NOT NULL,
  nb_remaining_place integer NOT NULL,
  price integer NOT NULL,
  period_id integer,

  constraint foreign key(period_id) references periods(id) on delete cascade on update cascade
);

create table if not exists histories (
  id integer AUTO_INCREMENT PRIMARY KEY,
  service_id integer,
  period_id integer,

  constraint foreign key(service_id) references services(id) on delete cascade on update cascade,
  constraint foreign key(period_id) references periods(id) on delete cascade on update cascade
);

create table if not exists options (
  id integer AUTO_INCREMENT PRIMARY KEY,
  wording varchar(50) NOT NULL
);

create table if not exists value_options (
  id integer AUTO_INCREMENT PRIMARY KEY,
  service_id integer,
  option_id integer,
  wording varchar(50) NOT NULL,
  price_min decimal,
  price_max decimal,
  price_advise decimal,

  constraint foreign key(service_id) references services(id) on delete cascade on update cascade,
  constraint foreign key(option_id) references options(id) on delete cascade on update cascade
);

create table if not exists type_options (
  id integer AUTO_INCREMENT PRIMARY KEY,
  wording varchar(50) NOT NULL
);

create table if not exists value_type_options (
  id integer AUTO_INCREMENT PRIMARY KEY,
  option_id integer,
  type_option_id integer,

  constraint foreign key(option_id) references options(id) on delete cascade on update cascade,
  constraint foreign key(type_option_id) references type_options(id) on delete cascade on update cascade
);

create table if not exists type_services (
  id integer AUTO_INCREMENT PRIMARY KEY,
  wording varchar(50) NOT NULL
);

create table if not exists type_places (
  id integer AUTO_INCREMENT PRIMARY KEY,
  wording varchar(50) NOT NULL
);

create table if not exists towns (
  id integer AUTO_INCREMENT PRIMARY KEY,
  name varchar(50) NOT NULL,
  CP integer,
  country varchar(25) NOT NULL,
  DP varchar(50)
);

create table if not exists places (
  id integer AUTO_INCREMENT PRIMARY KEY,
  town_id integer,

  constraint foreign key(town_id) references towns(id) on delete cascade on update cascade
);

create table if not exists contents_service (
  id integer AUTO_INCREMENT PRIMARY KEY,
  type_service_id integer,
  service_id integer,

  constraint foreign key(type_service_id) references type_services(id) on delete cascade on update cascade,
  constraint foreign key(service_id) references services(id) on delete cascade on update cascade
);
