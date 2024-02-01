set IDENTITY_INSERT REGIONS on;
insert into REGIONS (REGION_ID, NAME)
values (1, 'Източна Европа');
insert into REGIONS (REGION_ID, NAME)
values (2, 'Америка');
insert into REGIONS (REGION_ID, NAME)
values (3, 'Азия');
insert into REGIONS (REGION_ID, NAME)
values (4, 'Среден изток и Африка');
insert into REGIONS (REGION_ID, NAME)
values (5, 'Западна Европа');
insert into REGIONS (REGION_ID, NAME)
values (6, 'Северен полюс');
set IDENTITY_INSERT REGIONS off;

--------------------------------------------
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('RO', 'Румъния', 1);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('BG', 'България', 1);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('SC', 'Сърбия', 1);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('BE', 'Белгия', 5);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('AR', 'Аржентина', 2);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('AU', 'Австралия', NULL);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('BR', 'Бразилия', 2);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('GR', 'Гърция', null);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('CA', 'Канада', 2);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('CH', 'Швейцария', 5);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('CN', 'Китай', 3);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('DE', 'Германия', 5);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('DK', 'Дания', 5);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('EG', 'Египет', 4);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('FR', 'Франция', 5);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('HK', 'Хонгконг', 3);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('IL', 'Израел', 4);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('IN', 'Индия', 3);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('IT', 'Италия', 5);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('JP', 'Япония', 3);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('KW', 'Кувейт', 4);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('MX', 'Мексико', 2);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('NG', 'Нигерия', 4);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('NL', 'Холандия', 5);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('SG', 'Сингапур', 3);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('UK', 'Великобритания', 5);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('US', 'Съединени американски щати', 2);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('ZM', 'Замбия', 4);
insert into COUNTRIES (COUNTRY_ID, NAME, REGION_ID)
values ('ZW', 'Зимбабве', 4);

-----------------------------------------------
INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(10, 'Администрация', NULL, 'BG', 'Пловдив', 'Пловдив', 'бул. България 100', '4000'); 

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(20, 'Маркетинг', NULL, 'BG', 'София', 'София', 'бул. Черни връх 50', '1000')

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(30, 'Покупки', NULL, 'BG', 'Варна', 'Варна', 'бул. Васил Левски 10', '9000')

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(40, 'Човешки ресурси', NULL, 'BE', 'Gent', 'Gent', 'Lange Violettestraat 77-283', '9000')

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(50, 'Доставки', NULL, 'BG', 'Пловдив', 'Пловдив', 'бул. Васил Априлов 19', '4000')

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(60, 'ИТ', NULL, 'UK', 'London', NULL, 'Evershold St 101', 'NW1 1DG')

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(70, 'Връзки с обществеността', NULL, 'BG', 'София', 'София', 'бул. Черни връх 15', '1000')

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(80, 'Продажби', NULL, 'IT', 'Milan', 'Milan', 'Viale Premuda, 47', '20129')

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(90, 'Мениджмънт', NULL, 'BG', 'Пловдив', 'Пловдив', 'бул. България 100', '4000')

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(100, 'Финанси', NULL, 'BG', 'София', 'София', 'бул. България 15', NULL)

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(110, 'Счетоводство', NULL, 'BG', 'София', 'София', 'бул. Черни връх 50', '1000')

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(120, 'Логистика', NULL, 'BG', 'София', 'София', 'бул. България 15', NULL)

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(130, 'Обслужване на клиенти', NULL, 'BG', 'Пловдив', 'Пловдив', 'бул. Васил Априлов 19', '4000')

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(140, 'Обществени поръчки', NULL, 'BG', 'Варна', 'Варна', 'бул. Васил Левски 10', '9000')

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,NAME,MANAGER_ID,COUNTRY_ID,CITY,STATE,ADDRESS,POSTAL_CODE)
VALUES(150, 'ИТ Поддръжка', NULL, 'US', 'Southlake', 'Texas', '2012 Jabberwocky Rd', '26192')

-------------------------------------------------
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('AD_PRES', 'Президент', 25000, 50500); 
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('AD_VP', 'Административен вицепрезидент', 17000, 34200);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('AD_ASST', 'Административен асистент', 4000, 9200);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('FI_MGR', 'Финансов мениджър', 10000, 18000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('FI_ACCOUNT', 'Счетоводител', 7200, 12000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('AC_MGR', 'Главен счетоводител', 10200, 17000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('SA_MAN', 'Мениджър продажби', 15000, 22000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('SA_REP', 'Търговски представител', 9000, 17000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('PU_MAN', 'Мениджър покупки', 9000, 16000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('ST_MAN', 'Стоков мениджър', 7500, 13500);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('ST_CLERK', 'Отговорник склад', 6000, 12000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('SH_CLERK', 'Доставчик', 4500, 7500);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('IT_PROG', 'Програмист', 14000, 23000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('IT_SUPP', 'Системен администратор', 12000, 20000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('MK_MAN', 'Маркетинг мениджър', 9000, 15000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('MK_REP', 'Маркетинг консултант', 5000, 9000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('HR_REP', 'Специалист човешки ресурси', 6000, 9000);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('PR_REP', 'Специалист връзки с обществеността', 4500, 10500);
insert into JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
values ('CEO', 'Главен изпълнителен директор', null, null);

---------------------------------------------------
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (100, 'Иван', 'Иванов', 'iivanov@trade_company.com', '0887234561', convert(date, '17-06-2011', 105), 'AD_PRES', 27000, null, 90);  
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (101, 'Петя', 'Василева', 'petya@trade_company.com', '0899234563', convert(date, '21-09-2015', 105), 'AD_VP', 18000, 100, 90);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (102, 'Димитър', 'Господинов', 'dimitar@trade_company.com', '0877234718', convert(date, '13-01-2012', 105), 'AD_VP', 19000, 100, 90);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (103, 'Александър', 'Петров', 'ap@trade_company.com', '0878908876', convert(date, '03-01-2010', 105), 'IT_PROG', 12000, 102, 60);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (104, 'Боряна', 'Иванова', 'bo@trade_company.com', '0879543212', convert(date, '21-05-2010', 105), 'IT_PROG', 12000, 103, 60);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (105, 'Димо', 'Тодоров', 'dimo@trade_company.com', '0899765434', convert(date, '25-06-2005', 105), 'IT_PROG', 7800, 103, 60);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (106, 'Васил', 'Петров', 'vpetrov@trade_company.com', '0898765434', convert(date, '05-02-2008', 105), 'IT_PROG', 8800, 103, 60);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (107, 'Диана', 'Лазарова', 'dianal@trade_company.com', '0899776566', convert(date, '07-02-2009', 105), 'IT_PROG', 7200, 103, 60);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (108, 'Нина', 'Георгиева', 'ninageorgieva@trade_company.com', '0876543242', convert(date, '17-08-2015', 105), 'FI_MGR', 12000, 101, 100);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (109, 'Даниел', 'Филипов', 'filipovdaniel@trade_company.com', '0888345676', convert(date, '16-08-2014', 105), 'FI_ACCOUNT', 10000, 108, 100);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (110, 'Георги', 'Георгиев', 'georgig@trade_company.com', '0878643728', convert(date, '28-09-2017', 105), 'FI_ACCOUNT', 9200, 108, 100);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (111, 'Ивана', 'Иванова', 'ivana@trade_company.com', '0877665533', convert(date, '30-09-2014', 105), 'FI_ACCOUNT', 9700, 108, 100);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (112, 'Христо', 'Христов', 'hristov@trade_company.com', '0899775543', convert(date, '07-03-2008', 105), 'FI_ACCOUNT', 11300, 108, 100);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (113, 'Любо', 'Попов', 'lpopov@trade_company.com', '0887662289', convert(date, '07-12-2009', 105), 'FI_ACCOUNT', 8900, 108, 100);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (114, 'Димитър', 'Петров', 'petrovdimitar@trade_company.com', '0889330202', convert(date, '07-12-2016', 105), 'PU_MAN', 11000, 100, 30);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (115, 'Александър', 'Кръстев', 'akrastev@trade_company.com', '0877653525', convert(date, '18-05-2018', 105), 'SA_REP', 6100, 114, 30);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (116, 'Стефан', 'Бойдев', 'boydev@trade_company.com', '0876352717', convert(date, '24-12-2015', 105), 'SA_REP', 4700, 114, 30);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (117, 'София', 'Тодорова', 'stodorova@trade_company.com', '0899372891', convert(date, '24-07-2013', 105), 'SA_REP', 4000, 114, 30);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (118, 'Георги', 'Христов', 'georgihristov@trade_company.com', '0893994400', convert(date, '15-11-2010', 105), 'SA_REP', 6600, 114, 30);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (119, 'Кирил', 'Кръстев', 'kirilk@trade_company.com', '0888372910', convert(date, '12-08-2010', 105), 'SA_REP', 8200, 114, 30);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (120, 'Момчил', 'Димитров', 'momchildimitrov@trade_company.com', '0877463727', convert(date, '28-07-2009', 105), 'ST_MAN', 10000, 103, 70);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (121, 'Антон', 'Филипов', 'antonfilipov@trade_company.com', '0876594300', convert(date, '12-04-2015', 105), 'ST_MAN', 9200, 100, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (122, 'Петър', 'Костов', 'pkostov@trade_company.com', '0899493020', convert(date, '01-05-2018', 105), 'ST_MAN', 9900, 108, 30);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (123, 'Стоил', 'Вълков', 'svalkov@trade_company.com', '0899403020', convert(date, '10-01-2019', 105), 'ST_MAN', 8900, 101, 110);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (124, 'Коста', 'Митев', 'kmitev@trade_company.com', '0887371999', convert(date, '16-09-2009', 105), 'ST_MAN', 9800, 100, 40);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (125, 'Юлия', 'Ненова', 'jnenova@trade_company.com', '0885392010', convert(date, '16-07-2010', 105), 'ST_CLERK', 3400, 110, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (126, 'Ирена', 'Мишева', 'misheva@trade_company.com', '0877621627', convert(date, '28-10-1998', 105), 'ST_CLERK', 3400, 120, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (127, 'Дерек', 'Лесов', 'dereklesov@trade_company.com', '0887382001', convert(date, '13-01-2016', 105), 'ST_CLERK', 5400, 121, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (128, 'Стефан', 'Мавров', 'stmavrov@trade_company.com', '0888392000', convert(date, '08-03-2010', 105), 'ST_CLERK', 3300, 120, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (129, 'Лора', 'Георгиева', 'lorageorgieva@trade_company.com', '0899393020', convert(date, '20-08-2017', 105), 'ST_CLERK', 5300, 121, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (130, 'Мирослав', 'Антонов', 'miroantonov@trade_company.com', '0877382010', convert(date, '30-10-2009', 105), 'ST_CLERK', 4800, 121, 70);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (131, 'Даниел', 'Марков', 'markovdaniel@trade_company.com', '0877300020', convert(date, '19-02-2012', 105), 'ST_CLERK', 3500, 122, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (132, 'Тодор', 'Огнянов', 'todorog@trade_company.com', '0895402010', convert(date, '10-04-2018', 105), 'ST_CLERK', 3100, 121, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (133, 'Димитър', 'Матев', 'dmatev@trade_company.com', '0899403020', convert(date, '14-02-2019', 105), 'ST_CLERK', 5400, 122, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (134, 'Михаил', 'Руменов', 'mrumenov@trade_company.com', '0886362810', convert(date, '26-08-2008', 105), 'ST_CLERK', 3900, 122, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (135, 'Калоян', 'Георгиев', 'kgeorgiev@trade_company.com', '0877381010', convert(date, '12-12-2016', 105), 'ST_CLERK', 4400, 122, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (136, 'Христина', 'Филипова', 'hphilipova@trade_company.com', '0898392011', convert(date, '06-02-2018', 105), 'ST_CLERK', 2500, 122, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (137, 'Румен', 'Линдов', 'lindov@trade_company.com', '0877391033', convert(date, '14-09-2015', 105), 'ST_CLERK', 5600, 124, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (138, 'Стефан', 'Стилев', 'sstilev@trade_company.com', '0889392299', convert(date, '26-10-2018', 105), 'ST_CLERK', 4100, 123, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (139, 'Диана', 'Стефанова', 'dstef@trade_company.com', '0888339920', convert(date, '12-02-2012', 105), 'ST_CLERK', 3700, 123, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (140, 'Делян', 'Петров', 'dpetrov@trade_company.com', '0899392299', convert(date, '06-04-2019', 105), 'ST_CLERK', 3500, 123, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (141, 'Теодора', 'Русева', 'truseva@trade_company.com', '0889229391', convert(date, '17-11-2011', 105), 'ST_CLERK', 3400, 124, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (142, 'Катрин', 'Донева', 'kdoneva@trade_company.com', '0888229313', convert(date, '23-01-2010', 105), 'ST_CLERK', 3400, 124, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (143, 'Росен', 'Митрев', 'rmitrev@trade_company.com', '0896291192', convert(date, '15-03-2016', 105), 'ST_CLERK', 2900, 124, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (144, 'Петър', 'Петров', 'ppetrov@trade_company.com', '0883201102', convert(date, '19-07-2017', 105), 'ST_CLERK', 4300, 124, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (145, 'Димитър', 'Русев', 'drusevv@trade_company.com', '0877228811', convert(date, '01-11-2016', 105), 'SA_MAN', 15000, 100, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (146, 'Катя', 'Петрова', 'kpetrova@trade_company.com', '0888221199', convert(date, '05-01-2008', 105), 'SA_MAN', 12500, 100, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (147, 'Александър', 'Емилов', 'aemilov@trade_company.com', '0899332156', convert(date, '10-04-2017', 105), 'SA_MAN', 11300, 100, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (148, 'Георги', 'Гелов', 'ggelov@trade_company.com', '08773999110', convert(date, '15-10-2014', 105), 'SA_MAN', 10000, 100, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (149, 'Елена', 'Златкова', 'ezlotkey@trade_company.com', '0876440120', convert(date, '29-01-2019', 105), 'SA_MAN', 9500, 100, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (150, 'Петър', 'Тодоров', 'petertod@trade_company.com', '0899332013', convert(date, '30-01-2017', 105), 'SA_REP', 19000, 144, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (151, 'Добромир', 'Борисов', 'dborisov@trade_company.com', '0887332919', convert(date, '27-03-2016', 105), 'SA_REP', 8900, 145, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (152, 'Петър', 'Христов', 'petarhristov@trade_company.com', '0877338219', convert(date, '22-08-2015', 105), 'SA_REP', 9300, 145, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (153, 'Кристиан', 'Огнянов', 'kognyanov@trade_company.com', '08993382913', convert(date, '29-03-2019', 105), 'SA_REP', 8300, 145, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (154, 'Нина', 'Костова', 'nikostova@trade_company.com', '0879372815', convert(date, '09-11-2008', 105), 'SA_REP', 7800, 146, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (155, 'Огнян', 'Тодоров', 'otodorov@trade_company.com', '0885372273', convert(date, '24-11-2008', 105), 'SA_REP', 7900, 145, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (156, 'Жана', 'Костова', 'jkostova@trade_company.com', '0877337271', convert(date, '31-01-2009', 105), 'SA_REP', 11000, 146, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (157, 'Петър', 'Савов', 'psavov@trade_company.com', '08993832818', convert(date, '04-03-2006', 105), 'SA_REP', 9900, 146, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (158, 'Александър', 'Михов', 'alexmihov@trade_company.com', '0878372271', convert(date, '13-08-2018', 105), 'SA_REP', 9100, 146, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (159, 'Любо', 'Иванов', 'livanov@trade_company.com', '0888332819', convert(date, '10-04-2017', 105), 'SA_REP', 8300, 146, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (160, 'Лили', 'Донева', 'lilidoneva@trade_company.com', '0898372818', convert(date, '15-12-2017', 105), 'SA_REP', 8800, 146, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (161, 'Сара', 'Иванова', 'savanova@trade_company.com', '0887663528', convert(date, '03-11-2018', 105), 'SA_REP', 7800, 146, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (162, 'Катя', 'Вълева', 'valevakatia@trade_company.com', '0877364758', convert(date, '11-11-2010', 105), 'SA_REP', 10900, 148, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (163, 'Даниела', 'Горанова', 'dgoranova@trade_company.com', '0899382939', convert(date, '19-03-2009', 105), 'SA_REP', 9600, 147, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (164, 'Матея', 'Маврова', 'mmavrova@trade_company.com', '0877462616', convert(date, '24-01-2007', 105), 'SA_REP', 7500, 147, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (165, 'Добри', 'Лесов', 'dlesov@trade_company.com', '0877382819', convert(date, '23-02-2019', 105), 'SA_REP', 8800, 147, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (166, 'Стефан', 'Александров', 'salex@trade_company.com', '0889382818', convert(date, '24-03-2019', 105), 'SA_REP', 6900, 147, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (167, 'Антон', 'Петров', 'antonpe@trade_company.com', '0899392918', convert(date, '21-04-2010', 105), 'SA_REP', 6600, 147, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (168, 'Люба', 'Огнянова', 'lognyanova@trade_company.com', '0885382216', convert(date, '11-03-2017', 105), 'SA_REP', 11500, 148, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (169, 'Христо', 'Лозев', 'hlozev@trade_company.com', '0877382877', convert(date, '23-03-2007', 105), 'SA_REP', 11000, 148, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (170, 'Тодор', 'Филипов', 'tfil@trade_company.com', '0899382917', convert(date, '24-01-2018', 105), 'SA_REP', 9900, 148, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (171, 'Станимир', 'Стефанов', 'sstefan@trade_company.com', '0897665538', convert(date, '23-02-2019', 105), 'SA_REP', 7600, 148, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (172, 'Елена', 'Гатева', 'egateva@trade_company.com', '0877377288', convert(date, '24-03-2019', 105), 'SA_REP', 7600, 148, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (173, 'Сара', 'Кирилова', 'sarakirilova@trade_company.com', '0877446882', convert(date, '21-04-2016', 105), 'SA_REP', 6900, 148, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (174, 'Елен', 'Антонова', 'elenant@trade_company.com', '0876555447', convert(date, '14-05-2016', 105), 'SA_REP', 11600, 149, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (175, 'Алина', 'Христова', 'alihristova@trade_company.com', '0888773188', convert(date, '19-03-2018', 105), 'SA_REP', 8900, 149, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (176, 'Даниел', 'Трифонов', 'dtrif@trade_company.com', '0899665338', convert(date, '24-03-2014', 105), 'SA_REP', 8800, 149, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (177, 'Жана', 'Лилова', 'jlilova@trade_company.com', '0876330997', convert(date, '23-04-2016', 105), 'SA_REP', 8600, 149, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (178, 'Карина', 'Георгиева', 'kgeorg@trade_company.com', '0877663682', convert(date, '24-05-2018', 105), 'SA_REP', 7100, 149, null);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (179, 'Петър', 'Чипев', 'petarchipev@trade_company.com', '0886637199', convert(date, '04-01-2010', 105), 'SA_REP', 6300, 149, 80);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (180, 'Цветелина', 'Тодорова', 'ctodorova@trade_company.com', '0877665499', convert(date, '24-01-2008', 105), 'SH_CLERK', 4200, 120, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (181, 'Жоро', 'Филев', 'jfilev@trade_company.com', '0899382288', convert(date, '23-02-1998', 105), 'SH_CLERK', 4100, 120, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (182, 'Мартина', 'Свиленова', 'msvilenova@trade_company.com', '650.507.9878', convert(date, '21-06-2007', 105), 'SH_CLERK', 2300, 120, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (183, 'Женя', 'Геоггиева', 'jegeorgieva@trade_company.com', '08774646226', convert(date, '03-02-2008', 105), 'SH_CLERK', 4800, 120, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (184, 'Надя', 'Соколова', 'nadsokolova@trade_company.com', '0899377388', convert(date, '27-01-2010', 105), 'SH_CLERK', 5200, 122, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (185, 'Александра', 'Бонева', 'abon@trade_company.com', '650.509.2876', convert(date, '20-02-2019', 105), 'SH_CLERK', 5100, 121, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (186, 'Юлия', 'Демирева', 'jdemireva@trade_company.com', '0884299229', convert(date, '24-06-2014', 105), 'SH_CLERK', 4400, 121, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (187, 'Антон', 'Канев', 'antonkanev@trade_company.com', '0882339109', convert(date, '09-02-2016', 105), 'SH_CLERK', 3900, 121, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (188, 'Калоян', 'Лесов', 'kelso@trade_company.com', '0898667423', convert(date, '14-07-2017', 105), 'SH_CLERK', 4800, 122, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (189, 'Малина', 'Добромирова', 'malinadob@trade_company.com', '08777381837', convert(date, '14-08-2017', 105), 'SH_CLERK', 3900, 122, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (190, 'Михаил', 'Гатев', 'mgatev@trade_company.com', '0877464297', convert(date, '11-07-2018', 105), 'SH_CLERK', 3900, 122, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (191, 'Тихомир', 'Маринов', 'tmarinov@trade_company.com', '0877335108', convert(date, '19-12-2018', 105), 'SH_CLERK', 2300, 122, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (192, 'Силвия', 'Костова', 'skostova@trade_company.com', '0877362098', convert(date, '04-02-2018', 105), 'SH_CLERK', 5000, 123, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (193, 'Боряна', 'Димитрова', 'borianadim@trade_company.com', '0888391736', convert(date, '03-03-2014', 105), 'SH_CLERK', 4900, 123, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (194, 'Димитър', 'Маринов', 'dimitarmarinov@trade_company.com', '0877291073', convert(date, '01-07-2018', 105), 'SH_CLERK', 4200, 123, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (195, 'Виолета', 'Донева', 'violetado@trade_company.com', '0877338198', convert(date, '17-03-2019', 105), 'SH_CLERK', 3800, 124, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (196, 'Александра', 'Видева', 'alexvideva@trade_company.com', '0896361846', convert(date, '24-04-2017', 105), 'SH_CLERK', 4100, 125, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (197, 'Кирил', 'Филипов', 'kirilfil@trade_company.com', '0877364591', convert(date, '23-05-2009', 105), 'SH_CLERK', 3400, 124, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (198, 'Димо', 'Петров', 'dimopetrov@trade_company.com', '0876462819', convert(date, '21-06-2015', 105), 'SH_CLERK', 2800, 124, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (199, 'Даяна', 'Костова', 'dakostova@trade_company.com', '0876491088', convert(date, '13-01-2014', 105), 'SH_CLERK', 3600, 125, 50);
insert into EMPLOYEES(EMPLOYEE_ID, FNAME, LNAME, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID)
values (200, 'Гергана', 'Вълкова', 'gvalkova@trade_company.com', '0886444888', convert(date, '17-09-2010', 105), 'FI_ACCOUNT', 15400, 101, 110);

---------------------------------------------------

insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (101, 'BG', 'Калоян', 'Генев', 'бул. България 100, Пловдив', 'kaloyangenev@gmail.com', 'M');  
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (102, 'BG', 'Христо', 'Петров', 'бул. Черни връх 10, София', 'hristopetrov@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (103, 'BG', 'Марина', 'Тодорова', 'бул. Васил Левски 19, Варна', 'marinatod@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (104, 'BG', 'Петър', 'Георгиев', 'ул. Светлина 18, Стара Загора', 'georgievp@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (105, 'BG', 'Марин', 'Георгиев', 'ул. Съединение 45, Варца', 'maringeorgiev@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (106, 'BG', 'Мартин', 'Христов', 'ул. Гледка 12, Бургас', 'mhristov@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (107, 'BG', 'Момчил', 'Костов', 'бул. Марица 10, Пловдив', 'momchilkostov@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (108, 'BG', 'Младен', 'Господинов', 'ул. Свобода 10, Пловдив', 'mladengosp@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (109, 'BG', 'Калоян', 'Кирилов', 'бул. Васил Априлов 19, Пловдив', 'kaloyank@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (110, 'BG', 'Кирил', 'Костов', 'бул. Копривщица 10, Пловдив', 'kirilkostov@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (111, 'BG', 'Ивайла', 'Петрова', 'бул. Съединение 100, Пловдив', 'ivapetrova@gmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (112, 'BG', 'Георги', 'Георгиев', 'бул. България 10, София', 'ggeorgiev@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (113, 'BG', 'Даниел', 'Костов', ' бул. Витоша 14, София', 'daniel.kostov@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (114, 'BG', 'Даяна', 'Димова', 'ул. Илинден 14, Варна', 'dianne.dimova@gmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (115, 'BG', 'Георги', 'Димитров', 'ул. Иван Вазов 13, Стара Загора', 'g.dimitrov@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (116, 'BG', 'Даниел', 'Петров', 'ул. Свобода 13, Стара Загора', 'dani.petkov@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (117, 'BG', 'Александър', 'Миланов', 'бул. Черни връх 15, София', 'alex.milanov@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (118, 'BG', 'Гергана', 'Костова', 'ул. Македония 10, Хасково', 'gergana.kostova@gmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (119, 'BG', 'Иван', 'Иванов', 'бул. Джеймс Баучер 48, София', 'iivanov@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (120, 'BG', 'Катя', 'Георгиева', 'ул. Царевец 18, Пловдив', 'katia.georgieva@gmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (121, 'BG', 'Александър', 'Стафанов', 'ул. Рая 10, Пловдив', 'alexanderst@gmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (122, 'BG', 'Ангел', 'Ангел Николов', 'ул. Светлина 10, Хасково', 'angelnik@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (123, 'BG', 'Elizabeth', 'Brown', 'MI - 48103, 8110 Jackson Rd, Ann Arbor', 'elizabeth.brown@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (124, 'BG', 'Илия',  'Балтов', 'ул. Врачанска 14, Пловдив', 'baltoviliya@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (125, 'BG', 'Илия',  'Бояджиев', 'бул. Черни връх 10, София', 'iliyaboyadjiev@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (126, 'BG', 'Иван',  'Луков', 'бул. Васил Априлов 100, Пловдив', 'ivanlukov@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (127, 'BG', 'Ради', 'Колев', 'ул. Македония 12', 'radikolev@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (128, 'BG', 'Райна', 'Драганова', 'ул. Кокиче 17, Стара Загора', 'raynadrag@yahoo.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (129, 'BG', 'Симеон', 'Петров', 'бул. България 70, Бургас', 'simeonpetrov@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (130, 'BG', 'София', 'Атанасова', 'ул. Славянска 45, Видин', 'atanasovasof@yahoo.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (131, 'BG', 'Борис', 'Григоров', 'бул. Цар Освободител 15, София', 'boris.gr@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (132, 'BG', 'Спас', 'Ганев', 'ул. Люляк 80, Свищов', 'spasganev@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (133, 'BG', 'Кристин', 'Младенова', 'ул. София 50, Пловдив', 'kristin.m@yahoo.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (134, 'BG', 'Илия',  'Стоянов', 'бул. Черни връх 55, София', 'stoyanovil@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (135, 'BG', 'Иван', 'Лазаров', 'ул. Гледка 48, Карлово', 'ivanlazarov@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (136, 'BG', 'Иван',  'Михайлов', 'ул. Цар Асен 13, Пловдив', 'mihaylovivan@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (137, 'BG', 'Лазар', 'Апостолов', 'бул. Илинден 30, Видин', 'lazar.apostolov@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (138, 'BG', 'Васил', 'Танев', ' бул. Копривщица 39, Пловдив', 'vasil.tanev@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (139, 'BG', 'Марко', 'Иванов', 'бул. България 48, София', 'marko.ivanov@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (140, 'BG', 'Иван', 'Русев' , 'ул. София 45, Пловдив', 'ivan.rusev@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (141, 'BG', 'Иван', 'Кавалджиев', 'ул. Светлина 16, Габрово', 'ivan. kav@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (142, 'BG', 'Михаил', 'Маджаров', 'бул. Васил Априлов 49, Пловдив', 'mihail.madjarovs@yahoo.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (143, 'BG', 'Надежда', 'Балтова', 'бул. Марица 18, Пловдив', 'nadejda.baltova@yahoo.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (144, 'BG', 'Силвия', 'Петрова', 'ул. Ком 33, Хасково', 'silviya.petrova@yahoo.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (145, 'BG', 'Марио', 'Павлов', 'ул. Иван Вазов 45, Плевен', 'mario.pavlov@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (146, 'BG', 'Елена', 'Филипова', 'бул. Съединение 49, Стара Загора', 'elia.fil@hotmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (147, 'BG', 'Ирина', 'Костадинова', 'ул. Вишня 45, Плевен', 'irina.kostadin@hotmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (148, 'BG', 'Георги', 'Стефанов', 'бул. Марица 48, Пловдив', 'georgi.stefanov@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (149, 'BG', 'Марин', 'Ратов', 'ул. Светлина 55, Враца', 'marin.ratov@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (150, 'BG', 'Гергана', 'Петрова', 'ул. Севастопол 44, Русе', 'petrova.gergana@hotmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (151, 'BG', 'Никола', 'Михов', 'бул. България 33, София', 'nikola.mihov@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (152, 'BG', 'Димитър', 'Петров', 'ул. Кокиче 13, Видин', 'dimitar.petrov@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (153, 'BG', 'Никола', 'Гоцев', 'бул. Царевец 45, Пловдив', 'nikola.gocev@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (154, 'BG', 'Филип', 'Димитров', 'ул. Дрян 49, София', 'filip.dimitrov@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (155, 'BG', 'Илия', 'Кънчев', 'ул. Извор 44, Варна', 'ilia.kanchev@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (156, 'BG', 'Ангел', 'Илиев', 'бул. Цар Освободител 42, Пловдив', 'angel.iliev@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (157, 'BG', 'Стоян', 'Събев', 'ул. Славянска 33, Габрово', 'stoyan.sabev@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (158, 'BG', 'Стефка', 'Драганова', 'ул. София 19, Пловдив', 'stefka.dr@hotmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (159, 'BG', 'Елена', 'Димитрова', 'ул. Свобода 44, Плевен', 'elena.dimitrova@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (160, 'BG', 'Антон', 'Петров', 'ул. Победа 30, Пловдив', 'anton.petrov@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (161, 'BG', 'Силвия', 'Виденова', 'ул. Славей 15, Плевен', 's.vedenova@hotmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (162, 'BG', 'Никола', 'Иванов', 'бул. Васил Левски 33, Плодвид', 'nikola.iv@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (163, 'BG', 'Николай', 'Димитров', 'ул. Славянска 3, Видин', 'nikolai.dimitrov@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (164, 'BG', 'Калоян', 'Канев', 'ул. Победа 1, София', 'kaloyan.k@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (165, 'BG', 'Мария', 'Иванова', 'ул. Рая 30, Габрово', 'maria.ivanova@hotmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (166, 'BG', 'Катя', 'Александрова', 'ул. Ком 3, Пловдив', 'katia.alex@hotmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (167, 'BG', 'Георги', 'Стефанов', 'бул. Васил Левски 90, Пловдив', 'georgi.stefanov@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (168, 'BG', 'Христина', 'Вълкова', 'бул. Раковски 30, Плевен', 'hristina.vlk@hotmail.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (169, 'BG', 'Динко', 'Петров', 'ул. Севастопол 39, София', 'dinko.pet@hotmail.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (170, 'BG', 'Христо', 'Динев', 'бул. Данаил Николаев, София', 'hristo.dinev@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (171, 'US', 'Хема', 'Пауъл', '55905, ул. 1-ва 200, Рочестър', 'hema.powell@icloud.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (172, 'US', 'Хари', 'Сингър', '55802, ул. Мейн 20 , Дулут', 'harry.singer@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (173, 'US', 'Катлин', 'Уолкън', '55403, ул. Уилоу 200, Минеаполис', 'kathleen.walken@icloud.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (174, 'US', 'Блейк', 'Зайнър', '13211, бул. Бреуертън 2720, Ню Джърси', 'blake.seignier@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (175, 'US', 'Клод', 'Пауъл', '13219, ул. Юниън 2134 , Албани', 'claude.powell@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (176, 'US', 'Фей', 'Глен', '14305, ул. Мейн 1522, Ниагарски водопади', 'faye.glenn@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (177, 'US', 'Герхард', 'Зайнър', '12203, Пайн Аве 49, Албани', 'gerhard.seignier@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (178, 'US', 'Грейс', 'Белуши', '12534,ул. Юнион 726, Хъдсън', 'grace.belushi@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (179, 'US', 'Лорен', 'Форест', '12210, ул. Ларк 137, Албани', 'lauren.forrest@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (180, 'US', 'Маурин', 'Кейдж', '12601, ул. Фълтън 33, Покипси', 'maurin.cage@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (181, 'DE', 'Хал', 'Олин', '81243, ул. Валпургис 69, Мюнхен', 'hal.olin@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (182, 'DE', 'Хана', 'Кант', '81696, ул. Сендингер Тор 4, Мюнхен', 'annah.kanth@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (183, 'DE', 'Хана', 'Филд', '81999, ул. Тересиен 15, Мюнхен', 'hannah.field@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (184, 'IT', 'Маргет', 'Полини', '361196, ул. Френци 6903, Рим', 'margret.po@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (185, 'CA', 'Хари', 'Тайлър', '91261, ул. Айронуиид 1822 , Торонто', 'harry.taylor@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (186, 'IT', 'Маргит', 'Гарнър', '361197, ул. Луминоза 162, Флоренция', 'margrit.garner@icloud.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (187, 'IT', 'Мария', 'Вардън', '361198, ул. Ноториоза 1932, Флоренция', 'maria.warden@icloud.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (188, 'IT', 'Марло', 'Ландис', '361199, ул. Ноториоза 1941, Флоренция', 'marilou.landis@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (189, 'IT', 'Кеир', 'Гарсия', '361229, ул. Долороса 69, Теларо', 'keir.george@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (190, 'IT', 'Марло', 'Лотън', '361201, ул. Ноториоса 1943, Флоренция', 'marlon.laughton@icloud.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (191, 'BE', 'Мег', 'Сен', 'Ашвил', 'meg.sen@icloud.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (192, 'IT', 'Маргатер', 'Паул', '361196, ул. Френци 6903, Рим', 'margret.powell@icloud.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (193, 'CA', 'Хари', 'Тейлър', '91261, ул. Айронуиид 1822, Торонто', 'harry.taylor@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (194, 'IT', 'Маргит', 'Гарнър', '361197, ул. Луминоза 162, Флоренция', 'margrit.garner@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (195, 'IT', 'Мария', 'Варс', '361198, ул. Ноториоза 1932 Rd, Флоренция', 'maria.warden@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (196, 'IT', 'Марло', 'Ландис', '361199, ул. Ноториоза 1941, Флоренция', 'marilou.landis@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (197, 'IT', 'Кеир', 'Джордж', '361229, ул. Долороса 69, Теларо', 'keir.george@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (198, 'IT', 'Марлон', 'Лотън', '361201, ул. Ноториоза 1943, Флоренция', 'marlon.laughton@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (199, 'IT', 'Кей', 'Шандар', '361231, ул. Лумоноза 162, Теларо', 'keir.chandar@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (200, 'IT', 'Кейт', 'Уивър', '361228, ул. Флоренция 231, Теларо', 'keit.weaver@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (201, 'IT', 'Марлон', 'Клептън', '361202, ул. Ноториоза 1949, Флоренция', 'marlon.clapton@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (202, 'FR', 'Лоренс', 'Сейнър', 'Париж', 'laurence.seignier@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (203, 'IT', 'Кели', 'Куинлан', '361230, ул. Френци 6903, Теларо', 'kelly.quinlan@outlook.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (204, 'IT', 'Рик', 'Ромеро', '361213, ул. Дисено 194, Милано', 'rick.romero@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (205, 'IT', 'Рик', 'Лион', '361214, ул. Дела Капетели 52, Сан Марино', 'rick.lyon@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (206, 'IT', 'Маргау', 'Кридж', '361194, ул. Флорентина 231, Рим', 'margaux.krige@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (207, 'IT', 'Марино', 'Капшо', '361195, ул. Долороса 69, Рим', 'margaux.capshaw@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (208, 'IT', 'Кевин', 'Гудмън', '361234, ул. Ноториоза 1942, Вентимиле', 'kevin.goodman@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (209, 'IT', 'Кевин', 'Клевер', '361235, ул. Ноториоза 1943, Вентимиле', 'kevin.cleveland@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (210, 'IT', 'Кевин', 'Уилдър', '361183, ул. Канале гранде 2, Рим', 'kevin.wilder@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (211, 'IT', 'Кифър', 'Рейнолдс', '361184, Площад Качиатори 23, Рим', 'kiefer.reynolds@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (212, 'IT', 'Клаус', 'Йонг', '361223,ул. Дисеньо 194, Сан Джимиано', 'klaus.young@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (213, 'IT', 'Мария', 'Ръсел', '361221, Площад Свизера, Сан Джимиано', 'maria.russell@outlook.com', 'F');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (214, 'IT', 'Клаус', 'Маклейн', '361227, ул. Дело Кроче 93, Теларо', 'klaus.macLaine@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (215, 'IT', 'Крис', 'Харис', '361217, ул. Дело Кроче 93, Сан Джимиано', 'kris.harris@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (216, 'IT', 'Крис', 'Къртис', '361222, ул. Руела Спирити, Сан Джимиано', 'kris.curtis@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (217, 'IT', 'Крис', 'Дениро', '361224, ул. Капетели 52, Сан Джимиано', 'kris.deniro@outlook.com', 'M');
insert into CUSTOMERS (CUSTOMER_ID, COUNTRY_ID, FNAME, LNAME, ADDRESS, EMAIL, GENDER)
values (218, 'IT', 'Кристин', 'Севидж', '361226, ул. Капетели 5, Теларо', 'kristin.savage@outlook.com', 'M');


-------------------------------------------------
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3091, 'Мобилен телефон GSM NOKIA 105 DUAL SIM BLACK', 'Nokia 105 със своя извит, ергономичен корпус и релефна клавиатура за по-лесно набиране и писане, Nokia 105 ви дава усещането за солиден, качествен телефон, който пасва в дланта на ръката ви.', 48);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1787, 'Смартфон Huawei P Smart (2019)', 'Смартфон Huawei P Smart (2019), Dual SIM, 64GB, 4G, Midnight Black.', 450);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2439, 'Смартфон Samsung Galaxy S10e', 'Смартфон Samsung Galaxy S10e, Dual SIM, 128GB, 6GB RAM, 4G, Black.', 1400);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1788, 'Смартфон Samsung Galaxy J4 Plus (2018)', 'Смартфон Samsung Galaxy J4 Plus (2018), Dual Sim, 32 GB, 4G, Black.', 1000);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2375, 'Смартфон Apple iPhone XS', 'Смартфон Apple iPhone XS, 64 GB, Silver.', 1800);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2411, 'Смартфон Samsung Galaxy S10+', 'Смартфон Samsung Galaxy S10+, Dual SIM, 1TB, 12GB RAM, 4G, Ceramic White.', 3200);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1769, 'Предпазен калъф Just Must Uvo', 'Предпазен калъф Just Must Uvo за Huawei P30 Pro, Черен.', 48);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2049, 'Предпазен калъф Huawei Flip Cover', 'Предпазен калъф Huawei Flip Cover за P Smart 2019, Blue.', 25);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2751, 'Предпазен калъф Samsung Clear View', 'Предпазен калъф Samsung Clear View Standing за Galaxy Note 9, Black.', 86);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3112, 'Калъф Forcell Armor', 'Удароустойчив Калъф Forcell Armor за Huawei P Smart 2019 , Черен.', 47);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2752, 'Anti Shock гръб', 'Anti Shock гръб Carbon за IPhone 5/5S/SE, Черен', 9);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2293, 'Tellur Tempered Glass 3D', 'Защитно фолио Tellur Tempered Glass 3D за Samsung Galaxy S9, Black.', 15.50);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3114, 'Защитно фолио Tellur, Tempered Glass 3D', 'Защитно фолио Tellur, Tempered Glass 3D за iPhone XS, iPhone X, Черно.', 30);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3129, '5D Стъклен протектор Full Face Cover', '5D Стъклен протектор Full Face Cover Premium Tempered Glass за Huawei Mate 20 Lite, Черен.', 56);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3133, 'Tempered Glass за Huawei Y5', 'Стъклен скрийн протектор, Tempered Glass за Huawei Y5 2018.', 7);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2308, 'Протектор Premium Tempered Glass за Huawei', 'Стъклен Протектор Premium Tempered Glass за Huawei P20 Lite, transparent.', 18);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2496, 'Зарядно устройство за автомобил', 'Зарядно устройство за автомобил dual USB A+ Charger, 2.1A.', 9);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2497, 'Безжично зарядно устройство Samsung Wireless Charger', 'Безжично зарядно устройство Samsung Wireless Charger Duo Pad, Включено зарядно устройство, Black.', 159);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3106, 'Зарядно устройство за автомобил Huawei', 'Зарядно устройство за автомобил Huawei AP38 Fast Charge с кабел type C.', 48);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2289, 'Безжично зарядно устройство A+, K2', NULL, 18);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3110, 'Зарядно устройство за кола Belkin', 'Зарядно устройство за кола Belkin MIXIT UP Metallic, Черно.', 28);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3108, 'Батерия Samsung за Galaxy S5, 2800mAh', NULL, 18);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2058, 'Батерия Samsung за Galaxy S4 Mini', 'Батерия Samsung за Galaxy S4 Mini I9195, 1900mAh, Черна.', 23);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2761, 'Батерия Apple оригинална батерия за iPhone 5 1440 mAh', NULL, 27);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3117, 'Батерия Samsung EB-B600BEBECWW', 'Батерия Samsung EB-B600BEBECWW, 2600mAh за Galaxy S4 i9500/i9505.', 11);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2056, 'Батерия Huawei HB3742А0EZC+ за Huawei P8 Lite', NULL, 38);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2211, 'Слушалки bluetooth Jabra Elite Active 65t', 'Слушалки bluetooth Jabra Elite Active 65t, In-Ear, Black.', 344);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2944, 'Слушалка bluetooth Plantronics Explorer 55', NULL, 33);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1742, 'Безжични слушалки I7s PLUS', 'Безжични слушалки I7s PLUS с кутия за зареждане 950 mAH, Mic, Multipoint, Бели.', 15);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2402, 'Слушалка Bluetooth Plantronics Explorer 500', NULL, 107);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2403, 'Безжични слушалки AirPods', 'Безжични слушалки AirPods TWS i9s 2019 + PowerBank, 3D звук, Бял.', 47);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1761, 'Безжични bluetooth слушалки In-ear, Mic, Multipoint', NULL, 18);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2381, 'Блутут слушалки JBL T450BT', NULL, 99);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2424, 'Кабел за данни E-Boda CML 110', NULL, 10);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1781, 'Кабел MHL към HDMI адаптер за Samsung', NULL, 17);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2264, 'Кабел A+ lightning, MFI за iPhone', NULL, 9);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2260, 'Кабел ADATA Lightning MFI за iPhone', NULL, 33);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2266, 'Micro usb кабел ALIEN', NULL, 1.50);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3077, 'Кабел Earldom Type-C', NULL, 11);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2259, 'Външна батерия A+, 10 000 mAh', 'Външна батерия A+, 10 000 mAh, 2 USB порта, Black.', 32);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2261, 'Външна батерия Asus ZenPower', NULL, 64);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3082, 'Външна батерия Trust', NULL, 21);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2270, 'Външна батерия Xiaomi', 'Външна батерия Xiaomi, 20800 mAh, NDY-02-AD, с USB изход за мобилни телефони и таблети.', 26);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2268, 'Слушалки bluetooth Samsung Galaxy Buds', NULL, 300);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3083, 'Играчка Smart E-Boda Puppy Go', NULL, 400);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2374, 'Молив 3D E-Boda', NULL, 95);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1740, 'Слушалки Apple AirPods', NULL, 434);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2409, 'Детски смарт часовник Xblitz', NULL, 110);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2262, 'Видеокамера Samsung Gear 360', NULL, 500);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2522, 'Камера Insta 360 Nano', NULL, 124);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2278, 'Таблет Huawei MediaPad T3 7', 'Таблет Huawei MediaPad T3 7, 7", Quad Core 1.3 GHz, 1GB RAM, 16GB, Space Gray', 355);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2418, 'Таблет Huawei Mediapad M5', 'Таблет Huawei Mediapad M5, Octa Core 1.8 GHz, 10.8", 4 GB RAM, 64 GB, 4G, Space Gray', 861);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2419, 'Apple iPad 6', 'Apple iPad 6, 9.7", 32GB, Wi-Fi, Gold', 672);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3097, 'Apple iPad 6', 'Apple iPad 6, 9.7", 32GB, Wi-Fi, Silver', 673);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3099, 'Таблет Lenovo Tab 4 Essential TB-7304I', 'Таблет Lenovo Tab 4 Essential TB-7304I, Quad Core 1.3 GHz, 7", 1 GB RAM, 16 GB, 3G, Black', 144);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2380, 'аблет Allview Viva H701', 'аблет Allview Viva H701, 7", Quad Core 1Ghz, 1GB RAM, 8GB, 4G, IPS, White', 126);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2408, 'Таблет Mediatek KT107', 'Таблет Mediatek KT107 четири-ядрен процесор (1,3Ghz) 10.1", 1280х800 IPS, 1GB RAM, 16GB,3G, GPS, Wi-Fi, Bluetooth, Marshmallow 6.0 ,Бял', 144);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2457, 'Таблет Samsung Galaxy Tab E T561', 'Таблет Samsung Galaxy Tab E T561 c процесор Quad-Core™ 1.3 GHz, 9.6", 1.5GB RAM, 8GB, Wi-Fi, 3G, Bluetooth v4.0, Black', 345);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2373, 'Таблет HUAWEI MediaPad T3', 'Таблет HUAWEI MediaPad T3 8.0", сив с процесор 4x Cortex-A53 (1.4 GHz), 8.0", 2 GB, 16 GB, Android 7.0 Nougat, Сив', 256);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1734, 'Таблет Xiaomi mi Pad 4', 'Таблет Xiaomi mi Pad 4 ,3GB RAM 32 GB ROM ,black WI-FI', 206);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1737, 'Таблет Samsung Tab3 T113', 'Таблет Samsung Tab3 T113 Lite Value Edition c процесор Quad-Core™ 1.3 GHz, 7", 1GB RAM, 8GB, Wi-Fi, Bluetooth 4.0, Android 4.4.2 KitKat, Cream White', 198);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1745, 'Таблет Lenovo Tab Yoga 3 YT3-X50M', 'Таблет Lenovo Tab Yoga 3 YT3-X50M, 10.1'', Quad-Core 1.3 GHz, 2GB RAM, 16GB, 4G, IPS, Slate Black', 349);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2982, 'Таблет Samsung Galaxy Tab E T560', 'Таблет Samsung Galaxy Tab E T560 с процесор Quad-Core™ 1.3 GHz, 9.6", 1.5GB RAM, 8GB, Wi-Fi, Bluetooth v4.0, White', 444);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3277, 'Таблет Lenovo Thinkpad 8''', 'Таблет Lenovo Thinkpad 8'' Atom Z3770 /2GB/128GB SSD/3G модул/IPS', 436);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2976, 'Таблет Lenovo Tab M10 TB-X605L', 'Таблет Lenovo Tab M10 TB-X605L, Octa-Core 1.8GHz, 10.1", 3GB RAM, 32GB, 4G, Polar White', 352);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3204, 'Apple iPad 6, 9.7"', 'Apple iPad 6, 9.7", 128GB, Wi-Fi, Silver', 826);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2638, 'Таблет Samsung Galaxy Tab S3 T820', 'Таблет Samsung Galaxy Tab S3 T820, 9.7", Quad-Core 2.15 GHz, 4GB RAM, 32GB, Silver', 637);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3020, 'Таблет Xiaomi mi Pad 4', 'Комплект Таблет Xiaomi mi Pad 4 4GB RAM 64 GB ROM black WI-FI+калъф+протектор', 449);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1948, 'Калъф Trust за таблети 7-8' , NULL, 38);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3003, 'Калъф за таблет Huawei MediaPad M5', NULL, 39);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2999, 'Предпазен калъф Huawei Flip Cover за MediaPad T5', NULL, 29);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3000, 'Калъф IV за таблет Huawei MediaPad T5', NULL, 49);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3001, 'Стъклен протектор ОЕМ за Apple iPad Pro 12.9', NULL, 16);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3004, 'Стъклен протектор ОЕМ за Apple iPad Mini 4', NULL, 18);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3391, 'Стъклен протектор ОЕМ за Asus ZenPad 10 Z300C', NULL, 15);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3124, 'Стъклен протектор ОЕМ за Huawei Mediapad M2 10', NULL, 14);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1738, 'Скрийн протектор LENOVO YOGA TABLET 2 10.1', NULL, 6);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2377, 'Кабел за данни Apple Lightning', NULL, 97);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2299, 'Кабел OTG A+, USB-MicroUSB', NULL, 6);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3123, 'Кабел за зареждане Microsoft за Surface Go', NULL, 81);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1748, 'Адаптер Microsoft Surface JTY-00004', NULL, 43);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2387, 'Wi-Fi адаптер Diamond 360000N', NULL, 83);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2370, 'даптер за четец на карти Apple USB Type C', NULL, 97);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1726, 'Адаптер Microsoft Surface JVZ-00004', NULL, 99);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2359, 'Кабел Apple, USB Type C', NULL, 59);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3060, 'Адаптер Microsoft Surface USB - Ethernet', NULL, 99);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2243, 'Кабел Zik OTG Galaxy TAB', NULL, 5);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3057, 'Писалка стилус за таблет PEN', NULL, 4);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3061, 'Microsoft Surface Pen', NULL, 299);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2245, 'Модем,3G, Usb Doungle', NULL, 42);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3065, 'Кабел Apple USB-C', NULL, 89);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3331, 'Адаптер Apple multiport AV digital USB-C', NULL, 179);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2252, 'Адаптер Apple Thunderbolt to Gigabit Ethernet', NULL, 70);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3064, 'Адаптер Apple Thunderbolt 3', NULL, 123);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3155, 'Лаптоп ASUS X540MA-GO314T', 'Лаптоп ASUS X540MA-GO314T with processor Intel® Celeron® N4100 up to 2.40 GHz, 15.6", 4GB, 500GB, Intel® UHD Graphics 600, Microsoft Windows 10, Chocolate Black', 549);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3234, 'Лаптоп Gaming HP OMEN', 'Лаптоп Gaming HP OMEN с процесор Intel® Core™ i7-8750H до 4.10 GHz, Coffee Lake, 15.6", Full HD, IPS, 144 Hz, 8 GB, 1 TB + 128 GB SSD, NVIDIA GeForce GTX 1060 6 GB G-Sync, Free DOS, Shadow Black', 1839);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3350, 'Лаптоп Gaming ASUS ROG New ZEPHYRUS GX501GI-EI006T', 'Лаптоп Gaming ASUS ROG New ZEPHYRUS GX501GI-EI006T with processor Intel® Core™ i7-8750H up to 4.10 GHz, Coffee Lake, 15.6", Full HD, 144Hz, 3ms G-Sync, 24GB, 512GB SSD, NVIDIA GeForce GTX 1080 8GB Max-Q, Microsoft Windows 10, Black', 7740);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2236, 'Лаптоп 2 in 1 Kiano Elegance 11.6 360°', 'Лаптоп 2 in 1 Kiano Elegance 11.6 360° с процесор Intel Atom® x5-Z8350 до 1.92 GHz, 11.6", Touch, 2 GB, 32 GB eMMC, Intel HD Graphics, Microsoft Windows 10, Silver', 964);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3054, 'Лаптоп HP 15-da0119nq', 'Лаптоп HP 15-da0119nq с процесор Intel® Core™ i7-7500U до 3.50 GHz, Kaby Lake, 8 GB, 1 TB, NVIDIA® GeForce® MX130 2 GB, Free DOS, Black.', 600);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1782, 'Лаптоп Gaming HP Pavilion 15-bc415nq', 'Лаптоп Gaming HP Pavilion 15-bc415nq с процесор Intel® Core™ i5-8250U до 3.40 GHz, Kaby Lake R, 15.6", Full HD, 4 GB, 1 TB, NVIDIA GeForce GTX 1050 4 GB, Free DOS, Shadow Black.', 625);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2430, 'Лаптоп Gaming ASUS TUF FX504GD-EN940T', 'Лаптоп Gaming ASUS TUF FX504GD-EN940T с процесор Intel® Core™ i5-8300H до 4.00 GHz, Coffee Lake, 15.6", Full HD, 120 Hz, 8 GB + 16 GB Intel® Optane™, 1 TB Hybrid HDD, NVIDIA® GeForce® GTX 1050 4 GB, Microsoft Windows 10, Metal Gun', 1875);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1792, 'Лаптоп Lenovo ThinkPad X1 Carbon 6th', 'Лаптоп Lenovo ThinkPad X1 Carbon 6th with processor Intel® Core™ i7-8550U up to 4.00 GHz, Kaby Lake R, 14", Full HD, IPS, 16GB, 512GB SSD, Intel® UHD Graphics 620, Microsoft Windows 10 Pro, Black.', 5225);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1791, 'Лаптоп Apple MacBook Pro 15', 'Лаптоп Apple MacBook Pro 15, Екран Retina, Touch Bar, Процесор Intel® Quad Core™ i7 2.8GHz, 16GB RAM, 256GB SSD, Radeon Pro 555 2GB, macOS Sierra, ROM KB, Silver', 5275);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2302, 'Лаптоп ASUS X540UB-DM551T', 'Лаптоп ASUS X540UB-DM551T with processor Intel® Core™ i3-7020U 2.30 GHz, Kaby Lake, 15.6", Full HD, 4GB, 1TB, NVIDIA GeForce MX110 2GB, Microsoft Windows 10, Chocolate Black.', 1150);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2453, 'Лаптоп ASUS X542UA-DM521T', 'Лаптоп ASUS X542UA-DM521T с процесор Intel® Core™ i5-8250U up to 3.40 GHz, Kaby Lake R, 15.6", Full HD, 4GB, 1TB, DVD-RW, Intel UHD Graphics 620, Microsoft Windows 10, Matt Dark Grey.', 1195);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1797, 'Лаптоп Apple MacBook Pro 13', 'Лаптоп Apple MacBook Pro 13, Екран Retina, Touch Bar, Процесор Intel® Dual Core™ i5 3.1GHz, 8GB RAM, 512GB SSD, Intel® Iris™ Plus Graphics 650, macOS Sierra, ROM KB, Space Grey.', 5349);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2459, 'Лаптоп ASUS S406UA-BM034T', 'Лаптоп ASUS S406UA-BM034T с процесор Intel® Core™ i7-8550U до 4.00 GHz, Kaby Lake R, 14", Full HD, 16GB, 512GB M.2 SSD, Intel® UHD Graphics 620, Microsoft Windows 10, Ултрапреносим, Icicle Gold.', 2399);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3127, 'Лаптоп Lenovo IdeaPad 130-15IKB', 'Лаптоп Lenovo IdeaPad 130-15IKB с процесор Intel® Core™ i3-6006U 2.00 GHz, Skylake, 15.6", 4 GB, 500 GB, Intel® HD Graphics 520, Free DOS, Black.', 998);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2254, 'Ultrabook ASUS Zenbook UX430UN-GV075T', '1Ultrabook ASUS Zenbook UX430UN-GV075T с процесор Intel® Core™ i7-8550U до 4.00 GHz, Kaby Lake R, 14", Full HD, 16GB, 512GB M.2 SSD, NVIDIA GeForce MX150 2GB, Microsoft Windows 10, Blue.', 3453);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3353, 'Лаптоп Gaming Lenovo IdeaPad 330-17ICH', 'Лаптоп Gaming Lenovo IdeaPad 330-17ICH с процесор Intel® Core™ i5-8300H до 4.00 GHz, Coffee Lake, 17.3", Full HD, IPS, 8 GB, 1 TB + 256 GB SSD, NVIDIA GeForce GTX 1050 4 GB, Free DOS, Platinum Grey.', 1489);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3069, 'Лаптоп Lenovo IdeaPad 130-15IKB', 'Лаптоп Lenovo IdeaPad 130-15IKB с процесор Intel® Core™ i3-6006U 2.00 GHz, Skylake, 15.6", 4 GB, 1 TB, NVIDIA GeForce MX110 2 GB, Free DOS, Black.', 936);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2253, 'Лаптоп 2 in 1 Lenovo YOGA C930-13IKB', 'Лаптоп 2 in 1 Lenovo YOGA C930-13IKB with processor Intel® Core™ i7-8550U up to 4.00 GHz, Kaby Lake R, 13.9", 4K, IPS, 16GB, 512GB SSD, Intel® UHD Graphics 620, Microsoft Windows 10, Mica, Active Pen.', 4399);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3354, 'Лаптоп Lenovo IdeaPad 530S-14IKB', 'Лаптоп Lenovo IdeaPad 530S-14IKB с процесор Intel® Core™ i7-8550U до 4.00 GHz, Kaby Lake R, 14", WQHD, IPS, 16 GB, 512 GB SSD, Intel® UHD Graphics 620, Free DOS, Copper, Ултрапортативен.', 2543);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3072, 'Лаптоп ASUS S510UF-BQ118T', 'Лаптоп ASUS S510UF-BQ118T with processor Intel® Core™ i5-8250U up to 3.40 GHz, Kaby Lake R, 15.6", Full HD, 8GB, 1TB, NVIDIA GeForce MX130 2GB, Microsoft Windows 10, Gold.', 1567);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3334, 'Лаптоп 2 in 1 Lenovo YOGA 730-15IWL', 'Лаптоп 2 in 1 Lenovo YOGA 730-15IWL with processor Intel® Core™ i7-8565U up to 4.60 GHz, Whiskey Lake, 15.6", Full HD, IPS, Touch, 16GB, 512GB SSD, NVIDIA GeForce GTX 1050 4GB, Microsoft Windows 10, Iron Grey, Bluetooth Active Pen.', 2612);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3071, 'Лаптоп Gaming ASUS ROG Strix Scar II GL504GM-ES040', 'Лаптоп Gaming ASUS ROG Strix Scar II GL504GM-ES040 с процесор Intel® Core™ i7-8750H до 4.10 GHz, Coffee Lake, 15.6", Full HD, 144Hz, 16 GB, 1 TB SSHD + 128 GB SSD, NVIDIA GeForce GTX 1060 6 GB, Free DOS, Black.', 3233);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2255, 'Лаптоп Gaming ASUS TUF FX504GM-EN048', 'Лаптоп Gaming ASUS TUF FX504GM-EN048 с процесор Intel® Core™ i7-8750H до 4.10 GHz, Coffee Lake, 15.6", Full HD, 120 Hz, 3 ms, 8 GB, 1 TB FireCuda, NVIDIA GeForce GTX 1060 6 GB, Free DOS, Gun Metal.', 2075);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1743, 'Лаптоп 2 in 1 Lenovo YOGA Glass C930-13IKB', 'Лаптоп 2 in 1 Lenovo YOGA Glass C930-13IKB with processor Intel® Core™ i7-8550U up to 4.00 GHz, Kaby Lake R, 13.9", UHD, IPS, 16GB, 1TB, Intel® UHD Graphics 620, Microsoft Windows 10 Pro, Iron Grey, Active Pen.', 4800);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2382, 'Лаптоп ASUS A540MA-GO355T', '1Лаптоп ASUS A540MA-GO355T with processor Intel® Celeron® N4100 up to 2.40 GHz, 15.6", 4GB, 500GB, Intel® UHD Graphics 600, Microsoft Windows 10, Chocolate Black.', 650);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3399, 'Лаптоп Gaming ASUS TUF FX705GD-EW141', '1Лаптоп Gaming ASUS TUF FX705GD-EW141 с процесор Intel® Core™ i7-8750H до 4.10 GHz, Coffee Lake, 17.3", Full HD, IPS, 16 GB, 1 TB FireCuda, NVIDIA® GeForce® GTX 1050 4 GB, Free DOS, Gold Steel.', 2815);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3073, 'Лаптоп Gaming MSI GE73 Raider RGB 8RF', 'Лаптоп Gaming MSI GE73 Raider RGB 8RF with processor Intel® Core™ i7-8750H up to 4.10 GHz, Coffee Lake, 17.3", Full HD, 120Hz, 16GB, 1TB + 512GB SSD, NVIDIA GeForce GTX 1070 8GB, Free DOS, Black.', 4224);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1768, 'Лаптоп 2 in 1 HP ENVY x360 13-ag0001nn', 'Лаптоп 2 in 1 HP ENVY x360 13-ag0001nn с процесор AMD Ryzen™ 5 2500U до 3.60 GHz, 13.3", Full HD, IPS, Touch, 8GB, 256GB SSD, AMD Radeon™ Vega 8, Microsoft Windows 10, Dark Ash Silver.', 1845);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2410, 'Лаптоп ASUS S406UA-BM012T', 'Лаптоп ASUS S406UA-BM012T с процесор Intel® Core™ i5-8250U до 3.40 GHz, Kaby Lake, 14", Full HD, 8GB, 256GB SSD, Intel® HD Graphics 620, Microsoft Windows 10, Ултрапреносим, Gold.', 1357);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2257, 'Лаптоп Allview Allbook X', 'Лаптоп Allview Allbook X с процесор Intel® Celeron® Quad-Core N3450 до 2.20 GHz, 13.3", Full HD, IPS, 3GB, 32GB, Intel® HD Graphics, Microsoft Windows 10, Ултрапреносим, Black.', 399);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3400, 'Лаптоп HP 250 G6', 'Лаптоп HP 250 G6 с процесор Intel® Core™ i3-6006U 2.00 GHz, Skylake, 15.6", 4GB, 500GB, Intel HD Graphics, Free DOS, Black.', 789);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3355, 'Лаптоп HP ENVY', 'Лаптоп HP ENVY, 13.3 FHD Antiglare, with processor Intel Core i5-8250U, 8GB LPDDR3, 256GB SSD, Intel UHD Graphics, Windows 10, Natural silver.', 1920);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1772, 'Лаптоп Gaming ASUS GL703GE-EE023', 'Лаптоп Gaming ASUS GL703GE-EE023 with processor Intel® Core™ i7-8750H up to 4.10 GHz, Coffee Lake, 17.3", Full HD, 120Hz 3ms, 8GB, 1TB SSHD, NVIDIA GeForce GTX 1050Ti 4GB, Free DOS, Black.', 2456);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2414, 'UltraBook ASUS UX480FD-BE012R', 'UltraBook ASUS UX480FD-BE012R with processor Intel® Core™ i7-8565U up to 4.60 GHz, Whiskey Lake, 14", Full HD, 16GB, 512GB SSD, NVIDIA GeForce GTX 1050 Max-Q 4GB, Microsoft Windows 10 Pro, Deep Dive Blue.', 2454);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2415, 'Ultrabook Lenovo IdeaPad S530-13IWL', 'Ultrabook Lenovo IdeaPad S530-13IWL с процесор Intel® Core™ i7-8565U до 4.60 GHz, Whiskey Lake, 13.3", Full HD, IPS, 16GB, 512GB SSD, NVIDIA GeForce MX150 2GB, Free DOS, Liquid Blue.', 1359);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2395, 'Часовник smartwatch Samsung Galaxy Watch', NULL, 560);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1755, 'Часовник Smartwatch Samsung Galaxy Watch Active', NULL, 421);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2406, 'Apple Watch 4, GPS, Space Grey', 'Apple Watch 4, GPS, Space Grey, Алуминиев корпус, 44 мм, Black Sport Band', 1120);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2404, 'Часовник Smartwatch Garmin Fenix 5', NULL, 821);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1770, 'Часовник smartwatch Huawei Watch GT', NULL, 454);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2412, 'Спортен Смарт часовник KA Digital F3 Sport', 'Водоустойчив Спортен Смарт часовник KA Digital® F3 Sport, Атмосферно налягане, UV, Барометър, Надморска височина, Bluetooth, Черен/Червен', 68);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2378, 'Монитор Gaming TN LED ASUS 24', 'Монитор Gaming TN LED ASUS 24", Full HD, DVI, 1 ms, FreeSync, 144 Hz, HDMI, Display Port, Черен, MG248QR.', 405);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3087, 'Монитор Gaming LED IPS LG 25', 'Монитор Gaming LED IPS LG 25", UltraWide, UWHD 2K, 2 x HDMI, Flicker Safe, 25UM58-P, Черен.', 224);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2384, 'Монитор LED MVA Philips 23.6', 'Монитор LED MVA Philips 23.6", Wide, FHD, DVI, HDMI, 243V5QHSBA, Черен.', 199);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1749, 'Монитор Acer Gaming LED IPS 23.8', NULL, 237);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1750, 'Монитор LED TN AOC 24.5', 'Монитор LED TN AOC 24.5", Full HD, FreeSync 144Hz, Display Port, Черен, G2590PX.', 299);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2394, 'Монитор LED IPS Dell', 'Монитор LED IPS Dell 23.8", Full HD, DisplayPort, HDMI, USB, U2417H', 328);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2400, 'Монитор Gaming LED IPS Lenovo 27', 'Монитор Gaming LED IPS Lenovo 27", L27i-28, Full HD, Freesync, HDMI, Черен.', 348);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1763, 'Процесор AMD FX-8350', 'Процесор AMD FX-8350, 4.0GHz, 16MB, 125W, AM3+.', 147);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2396, 'Процесор Intel Core i5-9400F', 'Процесор Intel Core i5-9400F, 2.9 GHz, 9MB, Socket 1151, Без вградена графична карта.', 479);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2272, 'Процесор AMD FX X8 8350', 'Процесор AMD FX X8 8350, 4 GHz, 16MB, socket AM3+, Box.', 135);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2274, 'Процесор AMD Ryzen 3 2200G', '3.7 GHz, Socket AM4', 261);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3090, 'Процесор AMD Ryzen 2700X', '4.35GHz, 20MB, Socket AM4, Wraith Prism cooler', 793);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1739, 'USB памет Kingston DataTraveler 100 G3', '6GB, USB 3.0', 9);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3359, 'USB памет SanDisk Cruzer Ultra Flair 16GB', 'USB 3.0, 150 MB/сек', 11);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3088, 'Flash Pen Kingston DataTraveler SE9', '32GB, USB 2.0', 12);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2276, 'USB памет Kingston DataTraveler 50', '32GB, USB 3.0', 15);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3086, 'Външен хард диск WD Elements Portable', '1 TB, 2.5", USB 3.0, Черен', 100);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2311, 'Външен хард диск Seagate Expansion Portable', '1TB, 2.5", USB 3.0, Черен', 95);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (1733, 'Външен хард диск ADATA Durable HD330', '1TB, Shock Sensor, 2.5", USB 3.1, Черен', 109);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2878, 'Дънната платка Asus TUF X470-PLUS GAMING', 'Socket AM4', 345);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2879, 'Дънна платка GIGABYTE Z370P D3', 'Socket 1151 (300 Series), 4xDDR4, RGB Fusion', 256);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (2152, 'Дънна платка ASUS PRIME B350M-E', 'Socket AM4', 131);
insert into PRODUCTS(PRODUCT_ID, NAME, DESCR, PRICE)
values (3301, 'Дънна платка GIGABYTE 970A-DS3P rev 1.0', 'Socket AM3+ 53081', 155);


---------------------------------------
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2354, 103, 177, 'бул. България 140, Пловдив', convert(datetime, '13-07-2010 10:30:00.000', 105)); 
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2355, 101, 145, null, convert(datetime, '26-01-2018', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2356, 103, 150, null, convert(datetime, '26-01-2010 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2357, 102, 166, null, convert(datetime, '08-01-2008 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2358, 102, 166, null, convert(datetime, '09-01-2010', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2359, 108, 169, 'бул. Черхи връх 39, София', convert(datetime, '08-03-2018', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2360, 108, 170, null, convert(datetime, '14-01-2019 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2361, 101, 174, null, convert(datetime, '13-11-2009 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2362, 109, 156, null, convert(datetime, '13-01-2019 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2363, 124, 169, null, convert(datetime, '23-11-2012 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2364, 144, 159, 'ул. Светлина 10, Варна', convert(datetime, '28-08-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2365, 147, 168, null, convert(datetime, '28-09-2013', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2366, 147, 150, null, convert(datetime, '25-08-2014 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2367, 149, 147, null, convert(datetime, '27-06-2000 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2368, 150, 160, null, convert(datetime, '26-06-2010 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2369, 117, 157, null, convert(datetime, '28-03-2019', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2370, 117, 177, 'бул. Копривщица 100, Пловдив', convert(datetime, '26-08-2011', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2371, 114, 170, null, convert(datetime, '16-05-2009 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2372, 118, 169, null, convert(datetime, '27-02-2019 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2373, 117, 153, null, convert(datetime, '24-02-2010 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2374, 121, 160, 'бул. Васил Априлов 18, Пловдив', convert(datetime, '27-04-2010 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2375, 133, 164, null, convert(datetime, '26-02-2019', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2376, 124, 152, null, convert(datetime, '07-04-2019 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2377, 133, 154, null, convert(datetime, '07-06-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2378, 141, 145, null, convert(datetime, '24-01-2019 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2379, 145, 167, null, convert(datetime, '16-05-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2380, 143, 146, null, convert(datetime, '16-05-2017 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2381, 101, 178, null, convert(datetime, '14-05-2016 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2382, 104, 151, 'бул. Александър Малинов 39, София', convert(datetime, '13-05-2012', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2383, 105, 166, null, convert(datetime, '12-05-2016 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2384, 147, 158, null, convert(datetime, '12-05-2013 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2385, 146, 169, null, convert(datetime, '08-11-2009 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2386, 149, 147, null, convert(datetime, '06-10-2009 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2387, 149, 178, null, convert(datetime, '11-03-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2388, 150, 149, null, convert(datetime, '04-06-2012 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2389, 121, 156,'ул. Съединение 49, Стара Загора', convert(datetime, '04-06-2013', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2390, 152, 154, null, convert(datetime, '17-11-2009 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2391, 153, 159, null, convert(datetime, '27-03-2008', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2392, 154, 148, null, convert(datetime, '21-07-2009 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2393, 155, 151, null, convert(datetime, '10-02-2010 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2394, 109, 145, null, convert(datetime, '12-02-2000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2395, 118, 171, null, convert(datetime, '02-03-2008', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2396, 122, 146, null, convert(datetime, '02-02-2015 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2397, 102, 158, null, convert(datetime, '15-01-2016 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2398, 159, 145, null, convert(datetime, '19-11-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2399, 158, 159, null, convert(datetime, '19-11-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2400, 160, 156, null, convert(datetime, '11-08-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2401, 161, 145, null, convert(datetime, '11-08-2009 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2402, 145, 148, 'ул. Севастопол 49, Пловдив', convert(datetime, '02-10-2018', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2403, 133, 145, null, convert(datetime, '02-07-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2404, 163, 147, null, convert(datetime, '01-07-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2405, 163, 162, null, convert(datetime, '01-07-2009 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2406, 148, 162, null, convert(datetime, '29-08-2009 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2407, 165, 164, null, convert(datetime, '29-06-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2408, 165, 147, null, convert(datetime, '29-06-2015 13:56:34.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2409, 167, 157, null, convert(datetime, '30-06-2009 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2410, 117, 155, null, convert(datetime, '24-04-2000 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2411, 185, 176, 'ул. Айронуиид 1599 , Торонто', convert(datetime, '24-05-2009 13:56:34.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2412, 117, 165, null, convert(datetime, '31-03-2008', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2413, 101, 166, null, convert(datetime, '29-03-2016 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2414, 104, 164, null, convert(datetime, '20-03-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2415, 103, 149, null, convert(datetime, '29-03-2017 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2416, 104, 175, null, convert(datetime, '29-04-2009 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2417, 105, 163, null, convert(datetime, '20-03-2016 13:56:34.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2418, 106, 161, null, convert(datetime, '21-03-2006', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2419, 107, 163, null, convert(datetime, '20-03-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2420, 110, 160, null, convert(datetime, '13-03-2016 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2421, 109, 174, null, convert(datetime, '13-03-2009 13:56:34.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2422, 144, 173, null, convert(datetime, '16-12-2014 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2423, 145, 171, null, convert(datetime, '21-11-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2424, 146, 146, null, convert(datetime, '21-11-2015 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2425, 147, 168, null, convert(datetime, '17-11-2008 13:56:34.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2426, 148, 147, null, convert(datetime, '17-11-2017', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2427, 149, 167, null, convert(datetime, '12-11-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2428, 116, 164, null, convert(datetime, '10-11-2013 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2429, 117, 153, null, convert(datetime, '10-11-2009 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2430, 101, 158, null, convert(datetime, '02-10-2009 13:56:34.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2431, 102, 156, null, convert(datetime, '15-09-2015', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2432, 102, 153, null, convert(datetime, '14-11-2009 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2433, 103, 155, null, convert(datetime, '13-09-2016 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2434, 149, 145, null, convert(datetime, '13-11-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2435, 144, 167, null, convert(datetime, '02-09-2015', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2436, 116, 159, null, convert(datetime, '02-09-2013 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2437, 103, 147, null, convert(datetime, '13-09-2008 13:56:34.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2438, 104, 159, null, convert(datetime, '01-09-2013', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2439, 105, 157, null, convert(datetime, '31-08-2009 13:56:34.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2440, 107, 166, null, convert(datetime, '31-08-2009 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2441, 106, 160, null, convert(datetime, '01-08-2016', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2442, 107, 166, null, convert(datetime, '27-07-2014 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2443, 109, 170, null, convert(datetime, '28-07-2015', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2444, 109, 173, null, convert(datetime, '27-07-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2445, 144, 172, null, convert(datetime, '28-07-2017 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2446, 116, 155, null, convert(datetime, '27-07-2017 13:56:34.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2447, 101, 158, null, convert(datetime, '27-07-2000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2448, 145, 145, null, convert(datetime, '19-06-2010 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2449, 146, 145, null, convert(datetime, '13-06-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2450, 147, 168, null, convert(datetime, '11-04-2012 12:10:00.453', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2451, 148, 178, null, convert(datetime, '27-12-2009 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2452, 108, 158, null, convert(datetime, '06-10-2013', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2453, 116, 165, null, convert(datetime, '04-10-2009', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2454, 149, 169, null, convert(datetime, '12-10-2010 10:30:00.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2455, 145, 156, null, convert(datetime, '20-09-2009 17:42:15.984', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2456, 117, 149, null, convert(datetime, '07-11-2015 13:56:34.000', 105));
insert into ORDERS(ORDER_ID, CUSTOMER_ID, EMPLOYEE_ID, SHIP_ADDRESS, ORDER_DATE)
values (2457, 118, 145, null, convert(datetime, '31-10-2009 10:30:00.000', 105));

------------------------------------------

insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2355, 2289, 18, 200);  
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2356, 2264, 9, 38);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2356, 2289, 18, 200);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2357, 2211, 333, 140);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2358, 1781, 17, 9);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2359, 2497, 159, 1);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2360, 2058, 23, 29);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2361, 2289, 18, 180);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2362, 2289, 18, 200);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2363, 2264, 9, 9);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2364, 1740, 434, 6);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2365, 2289, 18, 92);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2366, 2359, 59, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2367, 2289, 18, 99);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2354, 3106, 48, 61);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2368, 3106, 48, 150);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2369, 1748, 43, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2370, 1739, 9, 9);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2371, 2274, 260, 6);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2372, 3106, 48, 6);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2373, 1739, 9, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2374, 1740, 430, 10);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2375, 3106, 42, 140);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2376, 2270, 26, 14);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2377, 2289, 17, 130);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2378, 2403, 47, 20);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2379, 3106, 42, 92);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2380, 3106, 42, 26);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2381, 3117, 11, 110);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2381, 2289, 18, 200);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2382, 3106, 42, 160);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2383, 2409, 104.7, 37);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2384, 2289, 18, 95);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2385, 2289, 18, 200);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2386, 1750, 293.1, 7);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2387, 2211, 343, 52);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2388, 2289, 17, 150);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2389, 3106, 43, 180);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2390, 1750, 294, 4);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2391, 1787, 450, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2392, 3106, 43, 63);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2393, 1748, 43, 10);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2394, 3117, 11, 90);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2395, 2211, 333, 110);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2396, 3106, 44, 150);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2397, 2976, 352, 2);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2398, 1761, 18, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2399, 2289, 17, 120);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2400, 2976, 352, 4);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2401, 1761, 18, 4);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2402, 1750, 295, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2403, 2522, 124, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2404, 1761, 18, 6);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2405, 2638, 637, 9);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2406, 1750, 295, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2408, 2751, 86, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2409, 1726, 96, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2411, 3082, 21, 2);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2412, 3106, 46, 170);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2413, 3108, 18, 200);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2414, 1726, 99, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2415, 2751, 86, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2416, 1750, 299, 10);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2417, 1726, 94.4, 9);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2418, 1761, 18, 15);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2419, 1763, 146, 150);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2420, 3106, 46, 110);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2421, 3106, 46, 160);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2422, 3106, 46, 18);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2423, 1726, 99, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2424, 3350, 7740, 11);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2426, 1726, 99, 6);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2427, 2430, 1873, 12);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2429, 3106, 42, 200);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2431, 3097, 673, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2432, 2976, 349, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2434, 2211, 333, 81);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2435, 2289, 18, 35);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2436, 1726, 99, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2437, 1726, 99, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2438, 1763, 147, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2439, 1797, 5346.8, 9);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2440, 2289, 18, 19);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2441, 2289, 17, 150);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2442, 1763, 147, 26);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2443, 1750, 294, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2444, 3117, 11, 110);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2445, 2270, 26, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2446, 2289, 18, 47);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2447, 2264, 9, 29);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2448, 3106, 44, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2449, 2522, 124, 2);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2450, 1726, 99, 4);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2451, 1726, 99, 9);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2452, 3117, 11, 140);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2453, 1726, 99, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2454, 2289, 18, 120);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2455, 1726, 99, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2456, 1763, 147, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2457, 1742, 15, 36);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2356, 2274, 260, 34);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2358, 1742, 15, 4);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2361, 2299, 6, 180);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2362, 2299, 6, 160);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2363, 2272, 129, 7);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2365, 2293, 15, 28);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2368, 3110, 28, 60);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2369, 3155, 543, 1);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2372, 3108, 18, 2);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2373, 1733, 104, 1);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2374, 1733, 100, 6);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2375, 3112, 47, 84);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2376, 2276, 15, 4);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2378, 2412, 68, 2);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2380, 3108, 18, 18);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2381, 1742, 15, 44);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2382, 1750,293, 64);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2384, 2299, 6, 48);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2388, 2293, 15, 90);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2389, 3112, 47, 18);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2390, 3400, 784, 2);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2396, 3108, 18, 75);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2399, 3400, 744, 12);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2400, 2982, 441, 1);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2412, 3114, 30, 68);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2413, 3112, 47, 40);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2419, 3114, 30, 45);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2420, 3110, 28, 11);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2421, 3108, 18, 160);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2422, 1726, 99, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2423, 3400, 782, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2424, 3354, 2541, 9);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2425, 3400, 789, 2);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2427, 2439, 1400, 1);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2431, 3106, 48, 1);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2432, 1769, 48, 2);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2438, 3000, 49, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2439, 3400, 745, 4);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2440, 2293, 15, 2);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2441, 3400, 783.6, 7);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2442, 1769, 48, 21);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2445, 1750, 299, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2447, 2266, 1, 23);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2454, 2293, 15, 0);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2457, 1726, 99, 14);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2361, 2308, 15, 182);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2362, 1772, 2443, 160);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2365, 2302, 1133.1, 29);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2368, 3117, 11, 62);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2369, 1726, 99, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2372, 1726, 99, 7);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2375, 3117, 11, 85);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2378, 1726, 99, 7);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2381, 3133, 7, 44);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2382, 1772, 2450, 65);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2389, 3123, 80, 21);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2391, 1797, 5348, 7);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2392, 3117, 11, 58);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2393, 3064, 123, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2394, 3124, 14, 39);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2396, 3110, 28, 79);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2399, 2299, 6, 15);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2400, 3400, 789, 4);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2410, 2982, 440, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2411, 3097, 673, 6);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2412, 3123, 71.5, 68);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2413, 3117, 11, 44);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2414, 3400, 741, 9);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2418, 1750, 289.2, 13);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2419, 3123, 71.5, 48);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2422, 3123, 71.5, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2424, 1750, 291, 12);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2428, 3114, 30, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2429, 3110, 28, 43);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2431, 3114, 30, 3);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2439, 1788, 1000, 9);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2442, 2418, 860, 23);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2444, 3133, 7, 90);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2450, 3400, 744, 5);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2457, 1788, 1000, 17);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2457, 3127, 988, 114);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2354, 3129, 51, 47);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2362, 1788, 990, 168);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2366, 2373, 256, 7);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2369, 3400, 784, 10);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2375, 1750, 288.4, 86);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2377, 1726, 99, 119);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2457, 3204, 799, 11);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2380, 1726, 99, 24);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2382, 3117, 11, 66);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2389, 3129, 56, 22);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2391, 3400, 789, 10);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2394, 3129, 56, 41);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2396, 3114, 30, 83);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2397, 1791, 5250, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2412, 3127, 998, 72);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2413, 3127, 998, 44);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2420, 3123, 79, 20);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2428, 3117, 11, 6);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2429, 3123, 79, 46);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2431, 3117, 11, 7);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2436, 1792, 5222, 6);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2439, 3114, 30, 13);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2442, 3114, 30, 25);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2444, 3114, 29, 93);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2457, 1792, 5217, 115);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2354, 1791, 5241, 48);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2355, 1948, 37, 185);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2356, 2293, 15, 40);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2358, 1948, 37.8, 12);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2361, 1750, 292, 187);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2365, 1948, 38, 29);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2366, 2382, 650, 10);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2372, 3123, 81, 10);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2374, 3400, 778, 15);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2377, 2311, 95, 121);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2380, 3133, 7, 28);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2382, 3123, 79, 71);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2383, 1726, 99, 46);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2388, 1948, 36, 96);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2393, 1948, 37.7, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2399, 1948, 36, 17);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2410, 3400, 768, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2412, 3204, 788, 75);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2420, 3127, 998, 22);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2421, 2049, 25, 168);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2428, 2049, 25, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2429, 3127, 998, 49);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2431, 3127, 998, 9);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2435, 2311, 86.9, 8);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2444, 3204, 729, 95);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2447, 2278, 355, 25);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2355, 2311, 86.9, 188);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2356, 2299, 6, 44);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2365, 2056, 38, 34);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2367, 2056, 34, 39);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2371, 2299, 6, 15);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2372, 2056, 36, 13);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2375, 2056, 37, 90);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2376, 2299, 6, 17);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2380, 3114, 30, 30);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2383, 2430, 1874, 50);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2391, 3114, 30, 18);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2393, 2056, 38, 10);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2394, 3114, 29, 45);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2399, 2311, 86.9, 20);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2419, 2058, 23, 57);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2421, 3129, 56, 172);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2422, 3133, 7, 11);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2423, 3114, 30, 13);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2427, 1726, 99, 6);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2428, 3127, 998, 12);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2429, 1726, 99, 52);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2431, 3129, 54, 11);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2434, 2236, 949.3, 84);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2435, 1726, 99, 10);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2440, 2152, 126.9, 7);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2442, 2439, 1400, 30);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2445, 2293, 15, 11);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2448, 3133, 7, 11);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2452, 2152, 130, 10);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2354, 3400, 789, 58);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2355, 3400, 719, 188);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2356, 2152, 128, 47);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2358, 3400, 789, 14);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2362, 2152, 131, 173);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2363, 2152, 131, 25);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2365, 2152, 131, 38);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2368, 3129, 52, 72);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2375, 2152, 131, 93);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2379, 2152, 128.4, 23);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2382, 3129, 52, 76);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2383, 2211, 335.5, 54);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2391, 3204, 793.3, 23);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2392, 2211, 343, 66);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2393, 3086, 100, 13);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2394, 3400, 789, 48);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2399, 2211, 342, 24);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2400, 3003, 39, 19);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2412, 3334, 2576, 80);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2414, 2211, 242.3, 18);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2419, 3133, 7, 61);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2423, 2211, 242.3, 14);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2427, 3334, 2600, 6);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2429, 2211, 341, 54);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2432, 2999, 29, 11);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2434, 2245, 41, 86);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2435, 2211, 344, 12);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2436, 2211, 344, 16);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2453, 3204, 799.4, 17);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2440, 2211, 343, 10);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2445, 2236, 962, 14);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2448, 2236, 964, 14);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2450, 3334, 2600, 11);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2452, 2236, 964, 12);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2455, 2236, 963.4, 32);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2354, 2236, 960, 61);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2355, 2236, 957, 190);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2361, 3334, 2600.1, 194);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2362, 2236, 950, 177);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2363, 2236, 957, 26);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2365, 2236, 949, 43);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2366, 2400, 348, 16);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2372, 2243, 5, 21);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2374, 2243, 5, 21);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2375, 3334, 2610, 93);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2382, 2243, 5, 79);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2384, 2243, 5, 61);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2385, 2243, 5, 96);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2387, 2243, 5, 22);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2392, 2243, 5, 68);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2393, 2243, 5, 14);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2395, 2252, 70, 30);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2407, 2752, 9, 18);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2411, 2243, 5, 17);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2414, 3334, 2606.8, 23);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2420, 3334, 2610, 34);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2426, 2243, 5, 18);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2428, 3334, 2610, 13);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2434, 2252, 70, 87);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2435, 2243, 5, 14);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2440, 3350, 7701.1, 13);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2444, 3155, 549, 104);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2450, 3350, 7741, 14);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2452, 2245, 35, 13);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2457, 3350, 7717, 27);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2354, 3350, 7737, 64);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2355, 3350, 7601.1, 192);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2360, 3350, 7730.7, 42);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2361, 2245, 35.3, 198);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2363, 2252, 70, 29);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2364, 2252, 70, 20);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2365, 2252, 70, 44);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2371, 3350, 7721, 21);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2375, 3155, 545, 98);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2381, 3350, 7735, 55);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2385, 3350, 7725, 97);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2392, 3350, 7718, 72);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2396, 2252, 70, 93);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2399, 2252, 68.1, 28);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2406, 2761, 26, 19);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2410, 2252, 70, 15);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2411, 1726, 95, 17);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2410, 1726, 95, 21);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2428, 3353, 1417, 16);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2429, 3353, 1417, 55);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2435, 3204, 825, 19);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2436, 3353, 1436, 18);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2440, 2253, 4333.3, 15);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2443, 2253, 4378, 17);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2452, 3155, 544, 13);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2454, 3353, 1418, 16);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2355, 3353, 1401.1, 197);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2369, 3353, 1462.2, 24);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2371, 3353, 1417, 24);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2375, 3204, 800, 99);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2376, 3353, 1425, 32);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2377, 2253, 4331.1, 132);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2380, 2253, 4332, 36);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2383, 2253, 4344.4, 62);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2386, 2370, 96, 28);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2419, 3353, 1417, 69);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2435, 3353, 1441.9, 24);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2442, 3353, 1480, 44);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2443, 3155, 549, 21);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2354, 2254, 3445.2, 70);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2365, 3353, 1425, 50);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2366, 2415, 1339.9, 24);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2368, 3155, 545, 75);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2369, 3354, 2542.2, 28);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2379, 3354, 2519, 35);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2386, 2375, 1800, 32);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2396, 3155, 547, 98);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2440, 2254, 3425, 23);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2444, 2254, 3437, 112);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2446, 3354, 2541.1, 36);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2359, 2377, 96, 17);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2365, 3354, 2532, 54);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2366, 2419, 669, 24);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2367, 3354, 2541.3, 54);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2372, 3354, 2534, 32);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2375, 3354, 2532, 107);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2395, 2268, 300, 37);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2411, 3133, 7, 23);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2412, 3155, 540, 92);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2426, 3155, 549, 26);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2428, 3155, 545.2, 24);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2440, 3155, 541.9, 24);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2392, 3155, 540, 81);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2393, 3108, 18, 30);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2394, 3155, 542, 68);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2395, 2270, 26, 41);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2399, 2255, 2026.6, 38);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2404, 2255, 2030, 37);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2406, 3155, 542, 31);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2411, 2255, 2065, 24);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2417, 2976, 352, 37);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2428, 2255, 2055, 28);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2429, 2255, 2066, 67);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2434, 2255, 2075, 104);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2435, 3155, 545, 33);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2440, 2359, 59, 28);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2447, 2311, 93, 44);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2455, 3155, 545, 54);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2455, 3204, 796, 45);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2355, 1750, 296.6, 204);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2357, 2289, 18, 41);
insert into ORDER_ITEMS(ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
values (2361, 2255, 2040, 209);

-------------------------------------------