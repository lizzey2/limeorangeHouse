create database if not exists orangehouse;

use orangehouse;

CREATE TABLE `member` (
  `userid` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `userpwd` varchar(100) NOT NULL,
  `email` varchar(100),
  `address` varchar(200),
  `joindate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userid`),
  UNIQUE KEY (`userid`)
);

CREATE TABLE `board` (
  `no` int NOT NULL AUTO_INCREMENT,
  `writer` varchar(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`),
  CONSTRAINT `board_to_member_fk` FOREIGN KEY (`writer`) REFERENCES `member` (`userid`)
); 

CREATE TABLE `notice` (
  `no` int NOT NULL AUTO_INCREMENT,
  `writer` varchar(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`)
); 
insert into notice(writer,title,content)
values('관리자','공지사항입니다','내용'),
	('관리자','공지사항항항항','내용'),
    ('매니저','공지리리리라랄','내용');
    
insert into board(writer, title, content) 
values('123', '아파트?', '이사할까욥'), 
      ('ssafy', '언해피하우스', '해피해지고싶어요'),
      ('123', '라임오렌지', '나는 라임이 더 좋아');
      
insert into member(userid, username, userpwd, email, address) 
values('ssafy', '싸피', 'ssafy','lizzey2@naver.com','서울시 동대문구');
values('123', '일이삼', '123','123@12.com','일이삼이네집');
values('admin', '관리자', 'admin','admin@naver.com','관리자네집');
values('manager', '매니저', 'manager','manager@naver.com','네집');

commit;
