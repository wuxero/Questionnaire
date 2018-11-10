-- 创建数据库questionnaire，之后运行该文件。

CREATE TABLE `q_service` (
`id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(50) NOT NULL,
`pwd` varchar(255) NOT NULL,
`online` tinyint(1) NULL DEFAULT 0,
`current_people` integer NULL DEFAULT 0,
PRIMARY KEY (`id`) 
)
COMMENT = '客服
';
CREATE TABLE `q_customer` (
`id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(50) NULL,
`online` tinyint(1) NULL DEFAULT 0,
`headImg` varchar(255) NULL,
PRIMARY KEY (`id`) 
)
COMMENT = '用户';
CREATE TABLE `q_chat_record` (
`id` bigint NOT NULL AUTO_INCREMENT,
`s_id` bigint NOT NULL COMMENT '客服id',
`c_id` bigint NOT NULL COMMENT '用户id',
`content` text NULL COMMENT '内容',
`resource_id` bigint NULL,
`is_coustomer` tinyint(1) NULL DEFAULT 1,
`time` bigint NULL COMMENT '时间',
PRIMARY KEY (`id`) 
)
COMMENT = '聊天记录';
CREATE TABLE `q_resource` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`created_date` bigint(20) NULL DEFAULT NULL,
`modified_date` bigint(20) NULL DEFAULT NULL,
`path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`relative_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`save_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`size` bigint(20) NULL DEFAULT NULL,
`type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`md5value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '图片或者其他文件'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Dynamic;
CREATE TABLE `q_questionnaire` (
`id` bigint NOT NULL AUTO_INCREMENT,
`s_id` bigint NULL,
`type` integer NULL COMMENT '问卷类型',
`title` varchar(255) NULL COMMENT '标题',
`describe` text NULL COMMENT '描述',
`time` bigint NULL,
`status` integer NULL COMMENT '0为未发布，1已发布，2撤回',
`del_flag` tinyint NULL DEFAULT 0,
PRIMARY KEY (`id`) 
)
COMMENT = '问卷';
CREATE TABLE `q_subject` (
`id` bigint NOT NULL,
`q_id` bigint NULL,
`order` integer NULL COMMENT '次序',
`type` integer NULL COMMENT '0单选，1多选',
`tips` varchar(1000) NULL COMMENT '提示',
`is_must` tinyint(1) NULL DEFAULT 0 COMMENT '是否是必答题',
PRIMARY KEY (`id`) 
)
COMMENT = '题目';
CREATE TABLE `q_option` (
`id` bigint NOT NULL AUTO_INCREMENT,
`s_id` bigint NULL COMMENT '对应题目',
`order` integer NULL COMMENT '顺序',
`content` varchar(500) NULL,
`pic_id` bigint NULL,
`tips` text NULL COMMENT '说明',
`score` integer NULL COMMENT '分数',
`scoring` tinyint(1) NULL DEFAULT 0 COMMENT '是否计分',
PRIMARY KEY (`id`) 
)
COMMENT = '选项';
CREATE TABLE `q_answer` (
`id` bigint NOT NULL AUTO_INCREMENT,
`q_id` bigint NULL,
`c_id` bigint NULL,
`time` bigint NULL,
PRIMARY KEY (`id`) 
)
COMMENT = '问卷答案';
CREATE TABLE `q_subject_answer` (
`id` bigint NOT NULL,
`a_id` bigint NULL COMMENT '对应答案id',
`s_id` bigint NULL COMMENT '题目id',
`o_id` bigint NULL COMMENT '选项id',
`content` text NULL COMMENT '内容',
PRIMARY KEY (`id`) 
)
COMMENT = '对应题目的答案';
CREATE TABLE `q_ques_type` (
`id` integer NOT NULL AUTO_INCREMENT,
`type` varchar(100) NULL COMMENT '类型名',
`describe` text NULL COMMENT '描述',
PRIMARY KEY (`id`) 
)
COMMENT = '问卷类型';

ALTER TABLE `q_chat_record` ADD CONSTRAINT `fk_q_chat_record_q_service_1` FOREIGN KEY (`s_id`) REFERENCES `q_service` (`id`);
ALTER TABLE `q_chat_record` ADD CONSTRAINT `fk_q_chat_record_q_customer_1` FOREIGN KEY (`c_id`) REFERENCES `q_customer` (`id`);
ALTER TABLE `q_chat_record` ADD CONSTRAINT `fk_q_chat_record_q_resource_1` FOREIGN KEY (`resource_id`) REFERENCES `q_resource` (`id`);
ALTER TABLE `q_questionnaire` ADD CONSTRAINT `fk_q_questionnaire_q_service_1` FOREIGN KEY (`s_id`) REFERENCES `q_service` (`id`);
ALTER TABLE `q_subject` ADD CONSTRAINT `fk_subject_q_questionnaire_1` FOREIGN KEY (`q_id`) REFERENCES `q_questionnaire` (`id`);
ALTER TABLE `q_option` ADD CONSTRAINT `fk_q_option_q_subject_1` FOREIGN KEY (`s_id`) REFERENCES `q_subject` (`id`);
ALTER TABLE `q_answer` ADD CONSTRAINT `fk_q_answer_q_questionnaire_1` FOREIGN KEY (`q_id`) REFERENCES `q_questionnaire` (`id`);
ALTER TABLE `q_answer` ADD CONSTRAINT `fk_q_answer_q_customer_1` FOREIGN KEY (`c_id`) REFERENCES `q_customer` (`id`);
ALTER TABLE `q_subject_answer` ADD CONSTRAINT `fk_q_subject_answer_q_answer_1` FOREIGN KEY (`a_id`) REFERENCES `q_answer` (`id`);
ALTER TABLE `q_subject_answer` ADD CONSTRAINT `fk_q_subject_answer_q_subject_1` FOREIGN KEY (`s_id`) REFERENCES `q_subject` (`id`);
ALTER TABLE `q_subject_answer` ADD CONSTRAINT `fk_q_subject_answer_q_option_1` FOREIGN KEY (`o_id`) REFERENCES `q_option` (`id`);
ALTER TABLE `q_questionnaire` ADD CONSTRAINT `fk_q_questionnaire_ques_type_1` FOREIGN KEY (`type`) REFERENCES `q_ques_type` (`id`);
ALTER TABLE `q_option

` ADD CONSTRAINT `fk_q_option_q_resource_1` FOREIGN KEY (`pic_id`) REFERENCES `q_resource` (`id`);

