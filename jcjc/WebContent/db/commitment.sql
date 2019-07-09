drop table commitment;

drop sequence seq_commitment;

create table commitment(
	commitment_no number primary key,
	politician_no number not null,
	commitment_proposal_date date not null,
	commitment_title varchar2(100) not null,
	commitment_content clob not null,
	commitment_fulfillment varchar2(100) not null,
	constraint commitment_no_const foreign key (politician_no) references politician(politician_no) on delete cascade
);

create sequence seq_commitment
increment by 1
start with 1
nocycle
nocache;

insert into commitment values(
seq_commitment.nextval, 0, '2019-01-01', 
'토요일에 나와서 코딩하는중',
'1. 오늘 나온사람 : 나래, 성민, 진영<br>
2. 지금 시간은 오후 2시 7분<br>
3. 이렇게 줄바꿈 해도 제대로 들어갈까?', '이행'
);

insert into commitment values(
seq_commitment.nextval, 0, '2019-02-02', 
'그래서 점심 뭐먹?',
'~ 나래 먹고싶은 것 ~<br>
1. 감자탕<br>
2. 일본식 카레<br>
3. 명란버터구이<br>
4. 닭갈비', '진행'
);

insert into commitment values(
seq_commitment.nextval, 0, '2019-03-03', 
'ADsP SQLD 발표날짜', 
'발표 진짜 너무 늦게하는거 아니냐 한달이나 걸리네<br>
* ADsP : 2019년 4월 9일<br>
* SQLD : 2019년 4월 16일', '미이행'
);

insert into commitment values(
seq_commitment.nextval, 0, '2001-01-01',
'야 너두 에이작스 할 수 있어', '하루에 십분씩 에이작스<br>너두 할 수 있어', '진행');

insert into commitment values(
seq_commitment.nextval, 0, '2002-02-02',
'공주 알밤막걸리', '고구마 통통 막걸리', '이행');

insert into commitment values(
seq_commitment.nextval, 0, '2003-03-03',
'시작이 반이다 + 가만히 있으면 중간이라도 간다', '시작하고 가만히 있으면 된다', '미이행');





insert into commitment values(
seq_commitment.nextval, 9770084, '2019-04-04',
'첫번째 테스트 제목', '첫번째 테스트 내용', '진행');

insert into commitment values(
seq_commitment.nextval, 9770084, '2019-05-05',
'두번째 테스트 제목', '두번째 테스트 내용', '진행');

insert into commitment values(
seq_commitment.nextval, 9770084, '2019-06-06',
'세번째 테스트 제목', '세번째 테스트 내용', '미이행');



insert into commitment values(
seq_commitment.nextval, 9770090, '2019-04-04',
'첫번째 테스트 제목', '첫번째 테스트 내용', '진행');

insert into commitment values(
seq_commitment.nextval, 9770090, '2019-05-05',
'두번째 테스트 제목', '두번째 테스트 내용', '진행');

insert into commitment values(
seq_commitment.nextval, 9770090, '2019-06-06',
'세번째 테스트 제목', '세번째 테스트 내용', '미이행');


insert into commitment values(
seq_commitment.nextval, 9770138, '2019-04-04',
'첫번째 테스트 제목', '첫번째 테스트 내용', '진행');

insert into commitment values(
seq_commitment.nextval, 9770138, '2019-05-05',
'두번째 테스트 제목', '두번째 테스트 내용', '이행');

insert into commitment values(
seq_commitment.nextval, 9770138, '2019-06-06',
'세번째 테스트 제목', '세번째 테스트 내용', '미이행');


select * from commitment order by commitment_no;

delete from commitment where commitment_no = 1;

update commitment set 
commitment_title = '999999', commitment_content = '999999', commitment_fulfillment = '진행' 
where commitment_no = 999;
