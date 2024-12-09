create table mabi_board_member(
	id char(20) primary key,
    pw char(20) not null,
    point int default 0,
    check_time datetime default CURRENT_TIMESTAMP,
    check_log char(10) default 'n'
);
select * from mabi_board_member;

-- 이벤트 종료 구문 변경을 위해 DELIMITER 변경
DELIMITER //
-- 이벤트 생성: 'reset_check_log'라는 이름의 이벤트를 정의
CREATE EVENT reset_check_log
ON SCHEDULE EVERY 1 day -- 매일 한 번 실행
STARTS CURRENT_TIMESTAMP -- 이벤트 시작 시간 설정
DO
BEGIN
    -- check_time이 현재 날짜보다 이전인 모든 행의 check_log 값을 'n'으로 변경
    UPDATE mabi_board_member
    SET check_log = 'n'
    WHERE DATE(check_time) < CURRENT_TIMESTAMP;
END//
-- DELIMITER를 원래 상태로 복구
DELIMITER ;

-- 사용중인 이벤트 스케줄러 확인
SELECT * FROM INFORMATION_SCHEMA.EVENTS;
-- 특정 이벤트 삭제
DROP EVENT IF EXISTS reset_check_log;

-- 현재 이벤트 스케줄러 상태 확인
SHOW VARIABLES LIKE 'event_scheduler';  
-- 이벤트 스케줄러 활성화 명령
SET GLOBAL event_scheduler = ON;

create table mabi_board(
	m_no int primary key auto_increment,
    m_title char(50) not null default '',
    m_id char(50) not null default '',
    m_text varchar(200) not null default '',
    m_category char(50) not null default '',
    m_hits int default 0,
    m_reply_ori int not null default 0,
    m_reply_id char(50) not null default '',
    m_reply_text varchar(100) not null default ''
);
select * from mabi_board;
SELECT * from mabi_board where m_hits > 2 order by m_hits desc limit 10;

create table mabi_character_list(
	character_name char(20) not null,
    class_name char(20) not null,
    level int not null,
    offensive_power char(20) not null,
    magic_power char(20) not null,
    additional_damage char(20) not null,
    critical char(20) not null,
    balance char(20) not null,
    unrestricting_Attacks char(20) not null,
    id char(20) not null,
    deployment int not null default 0 
);
select * from mabi_character_list;
drop table mabi_board_member;
