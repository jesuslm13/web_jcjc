drop table bill;

create table bill(
   bill_no varchar2(1000) primary key,
   bill_name varchar2(1000),
   politician_no number,
   proposer varchar2(1000),
   proposer_hj varchar2(10),
   proposer_kind varchar2(1000),
   propose_dt date,
   submit_dt date,
   committee_name varchar2(1000),
   proc_dt date,
   general_result varchar2(1000)
);

insert into bill(bill_no, bill_name, proposer, proposer_kind, propose_dt, submit_dt, committee_name, proc_dt, general_result) values 
('2019397','의사일정 변경동의의 건','나경원', '의원', to_date('2019-03-26','yyyy-mm-dd'), to_date(null,'yyyy-mm-dd'), '본회의', to_date(null,'yyyy-mm-dd'), '철회');

insert into bill(bill_no, bill_name, proposer, proposer_kind, propose_dt, submit_dt, committee_name, proc_dt, general_result) values 
('2019397','의사일정 변경동의의 건','나경원', '의원', '2019-03-26', '', '본회의', null, '철회');

select * from bill;

select * from bill where bill_no='2012060';
select * from bill where proposer='김성태';
select * from bill where proposer='최경환';
select * from bill where proposer='나경원';

select round(avg(count),2) from (
select count(bill_no) as count, politician_no from bill group by politician_no having politician_no not in (0));

select proposer, count(*) as 갯수 from bill group by proposer order by count(*);