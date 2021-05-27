/*
 Navicat Premium Data Transfer

 Source Server         : PostgreSQL
 Source Server Type    : PostgreSQL
 Source Server Version : 100017
 Source Host           : localhost:5432
 Source Catalog        : spring_boot
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 100017
 File Encoding         : 65001

 Date: 27/05/2021 18:42:16
*/


-- ----------------------------
-- Sequence structure for hibernate_sequence
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."hibernate_sequence";
CREATE SEQUENCE "public"."hibernate_sequence" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."auth_user";
CREATE TABLE "public"."auth_user" (
  "id" int8 NOT NULL,
  "account" varchar(32) COLLATE "pg_catalog"."default",
  "name" varchar(32) COLLATE "pg_catalog"."default",
  "pwd" varchar(64) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO "public"."auth_user" VALUES (2, '4', '任我行', '123456');
INSERT INTO "public"."auth_user" VALUES (4, '43', '令狐冲', '123456');
INSERT INTO "public"."auth_user" VALUES (1, 'fengqy', '风清扬', '123456');
INSERT INTO "public"."auth_user" VALUES (3, 'bubai', '东方不败', '123456');
INSERT INTO "public"."auth_user" VALUES (5, 'wentian', '向问天', '123456');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS "public"."company";
CREATE TABLE "public"."company" (
  "id" int4 NOT NULL,
  "company_name" varchar(255) COLLATE "pg_catalog"."default",
  "employees_number" int4
)
;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO "public"."company" VALUES (0, 'baidu', 1000);
INSERT INTO "public"."company" VALUES (1, 'alibaba', 200);
INSERT INTO "public"."company" VALUES (2, 'tengxun', 3000);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS "public"."employee";
CREATE TABLE "public"."employee" (
  "id" int4 NOT NULL,
  "age" int4 NOT NULL,
  "company_id" int4 NOT NULL,
  "gender" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "salary" int4 NOT NULL
)
;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO "public"."employee" VALUES (0, 20, 0, 'male', 'xiaoming', 6000);
INSERT INTO "public"."employee" VALUES (1, 19, 1, 'female', 'xiaohong', 7000);
INSERT INTO "public"."employee" VALUES (2, 19, 2, 'male', 'xiaozhi', 8000);
INSERT INTO "public"."employee" VALUES (3, 19, 1, 'male', 'xiaogang', 6000);
INSERT INTO "public"."employee" VALUES (4, 19, 0, 'female', 'xiaoxia', 4000);

-- ----------------------------
-- Table structure for sal_emp
-- ----------------------------
DROP TABLE IF EXISTS "public"."sal_emp";
CREATE TABLE "public"."sal_emp" (
  "name" text COLLATE "pg_catalog"."default",
  "pay_by_quarter" int4[],
  "schedule" text[][] COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of sal_emp
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS "public"."student";
CREATE TABLE "public"."student" (
  "s_id" int4 NOT NULL,
  "s_age" int4 NOT NULL,
  "s_name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for test_labor
-- ----------------------------
DROP TABLE IF EXISTS "public"."test_labor";
CREATE TABLE "public"."test_labor" (
  "id" int8 NOT NULL,
  "age" int4,
  "birthday" timestamp(6),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "sex" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of test_labor
-- ----------------------------
INSERT INTO "public"."test_labor" VALUES (4, NULL, '2021-05-27 16:58:12.944', '马六', '2');
INSERT INTO "public"."test_labor" VALUES (6, NULL, '2021-05-27 17:05:07.2', '王五', '2');
INSERT INTO "public"."test_labor" VALUES (1, NULL, '2021-05-27 17:05:07.2', '王五', '2');

-- ----------------------------
-- Table structure for test_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."test_role";
CREATE TABLE "public"."test_role" (
  "id" int8 NOT NULL,
  "rolename" varchar(255) COLLATE "pg_catalog"."default",
  "sid" int8
)
;

-- ----------------------------
-- Records of test_role
-- ----------------------------

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."hibernate_sequence"', 7, true);

-- ----------------------------
-- Primary Key structure for table auth_user
-- ----------------------------
ALTER TABLE "public"."auth_user" ADD CONSTRAINT "auth_user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table company
-- ----------------------------
ALTER TABLE "public"."company" ADD CONSTRAINT "company_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table employee
-- ----------------------------
ALTER TABLE "public"."employee" ADD CONSTRAINT "employee_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table student
-- ----------------------------
ALTER TABLE "public"."student" ADD CONSTRAINT "student_pkey" PRIMARY KEY ("s_id");

-- ----------------------------
-- Primary Key structure for table test_labor
-- ----------------------------
ALTER TABLE "public"."test_labor" ADD CONSTRAINT "test_labor_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table test_role
-- ----------------------------
ALTER TABLE "public"."test_role" ADD CONSTRAINT "test_role_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table test_role
-- ----------------------------
ALTER TABLE "public"."test_role" ADD CONSTRAINT "fkasrx5utlm5vl3yggn1bldu2f" FOREIGN KEY ("sid") REFERENCES "public"."test_labor" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
