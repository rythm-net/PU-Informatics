--TRANSACTIONS
BEGIN TRAN 

INSERT INTO PRODUCTS
VALUES(1, 'PROD-TRANSACTION', 100, NULL)

UPDATE EMPLOYEES
SET SALARY += 1000
WHERE EMPLOYEE_ID = 114

COMMIT 

--12000.00
SELECT SALARY 
FROM EMPLOYEES 
WHERE EMPLOYEE_ID = 114

SELECT *
FROM PRODUCTS 
WHERE PRODUCT_ID = 1

/*Създайте процедура, която извежда имената на всички продукти, които са били поръчвани*/
CREATE PROCEDURE GET_PRODUCT_NAME_PRC
AS
SELECT DISTINCT NAME 
FROM PRODUCTS P JOIN ORDER_ITEMS OI 
ON P.PRODUCT_ID = OI.PRODUCT_ID

EXECUTE GET_PRODUCT_NAME_PRC

/*Създайте процедура, която връща като резултат броя поръчки на клиент и
има като входен параметър номер на клиент*/
CREATE PROC GET_CUST_TOTAL_ORD_PRC @CUST_ID INT 
AS 
SELECT FNAME + ' ' + LNAME AS CUETOMER, COUNT(ORDER_ID) AS TOTAL 
FROM CUSTOMERS C LEFT JOIN ORDERS O 
ON C.CUSTOMER_ID = O.CUSTOMER_ID
WHERE C.CUSTOMER_ID = @CUST_ID
GROUP BY C.CUSTOMER_ID, FNAME + ' ' + LNAME

EXEC GET_CUST_TOTAL_ORD_PRC @CUST_ID = 101

--тригер
CREATE TRIGGER PRODUCT_NAME_TRIGGER
ON PRODUCTS
AFTER INSERT 
AS
SELECT *
FROM inserted

INSERT INTO PRODUCTS
VALUES(2, 'PROD-TRIGGER', 100, NULL)

/*Създайте изглед, който съдържа имената на държавите и имената на регионите,
 в които се намират. нека в резултата участват само държавите, в които 
 няма отдели и клиенти на фирмата*/
 CREATE VIEW COUNTRY_REG_VIEW
 AS
 SELECT C.NAME AS COUNTRY, R.NAME  AS REGION
 FROM COUNTRIES C JOIN REGIONS R 
 ON C.REGION_ID = R.REGION_ID
 LEFT JOIN CUSTOMERS CU 
 ON C.COUNTRY_ID = CU.COUNTRY_ID
 LEFT JOIN DEPARTMENTS D 
 ON D.COUNTRY_ID = C.COUNTRY_ID
 WHERE D.COUNTRY_ID IS NULL AND CU.COUNTRY_ID IS NULL 

 SELECT*
 FROM COUNTRY_REG_VIEW

/*Създайте изглед, който съдържа имената на отделите, броя служители в тях и 
най-високата заплата*/
CREATE VIEW DEP_EMPL_SAL_VIEW 
AS 
SELECT NAME, COUNT(EMPLOYEE_ID) AS TOTAL, MAX(SALARY) AS MAX_SALARY 
FROM DEPARTMENTS D JOIN EMPLOYEES E 
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
GROUP BY NAME 

SELECT *
FROM DEP_EMPL_SAL_VIEW

/*Създайте изглед, който съдържа имената на продуктите и общото количество,
 в което  са били поръчани.*/
 CREATE VIEW PRODUCT_VIEW
 AS
 SELECT DISTINCT NAME, COUNT(QUANTITY) AS TOTAL 
 FROM PRODUCTS P JOIN ORDER_ITEMS OI 
 ON P.PRODUCT_ID = OI.PRODUCT_ID
 GROUP BY NAME 

 SELECT *
 FROM PRODUCT_VIEW 

/*имената на служителите и наименованията на отделите, в които работят,
 в резултата да участват само служителите, които получават заплата по-голяма 
 от всеки служител, работещ в отдел Маркетинг(номер 20)*/
 SELECT FNAME + ' ' + LNAME AS EMPLOYEE, NAME 
 FROM EMPLOYEES E JOIN DEPARTMENTS D 
 ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 WHERE SALARY > ALL (SELECT	SALARY
					 FROM EMPLOYEES
					 WHERE DEPARTMENT_ID = 20)

/*Изведете наименованието на длъжността, в която са назначени най-много служители*/
SELECT TOP 1 WITH TIES JOB_TITLE, COUNT(EMPLOYEE_ID) AS TOTAL 
FROM JOBS J JOIN EMPLOYEES E 
ON J.JOB_ID = E.JOB_ID
GROUP BY JOB_TITLE
ORDER BY TOTAL DESC 

/*Изведете имената на клиентите, които са от женски пол и не са правили поръчки до 
момента*/
SELECT FNAME + ' ' + LNAME AS FEMALE_CUSTOMER
FROM CUSTOMERS 
WHERE GENDER = 'F' AND CUSTOMER_ID NOT IN (SELECT CUSTOMER_ID	
											FROM ORDERS)

/*Извдете отделите и имената на мениджърите им. Подредете резултата възходящо по 
име на отдел.*/
SELECT NAME, FNAME + ' ' + LNAME AS MANAGER
FROM DEPARTMENTS D JOIN EMPLOYEES E 
ON D.MANAGER_ID = E.EMPLOYEE_ID
ORDER BY NAME 

