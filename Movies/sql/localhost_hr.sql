create table m_manager(
	id varchar2(20) primary key,
	password varchar2(20) not null
);

insert into m_manager values('sys', 'abc123');

create table m_member(
	id varchar2(20) primary key,
	password varchar2(20) not null,
	name varchar2(20)
);

create table m_movies(
	no number(5),
	title varchar2(100) not null,
	seatno number(3) default 100 check (seatno <= 100)
	primary key(no, title)
);

create sequence seq_m_movies_no nocache;

create table m_ticket(
    no number(5) primary key,
    id varchar2(20),
    title varchar2(100),
    seat_cnt number(3) default 1,
    foreign key(id) references m_members(id)
);

create sequence seq_m_ticket_no nocache;