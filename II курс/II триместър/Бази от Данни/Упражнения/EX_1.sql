/*Увеличете заплатите на всички служители, които работят в отдел 50, с 1000*/
UPDATE EMPLOYEES
SET SALARY += 1000
WHERE DEPARTMENT_ID = 50

/*Увеличете заплатите на служителите, които работят в отдел 80 и получават месечна 
заплата по-малка от 700 с 10%*/
UPDATE EMPLOYEES
SET SALARY *= 1.1
WHERE DEPARTMENT_ID = 80 AND SALARY/12 < 700

/*Увеличете количеството, в което е бил поръчан продукт 2308 в поръчка 2355 с 200 бр.
и намалете единичната цена с 5%*/
UPDATE ORDER_ITEMS
SET QUANTITY += 200, UNIT_PRICE *= 0.95
WHERE PRODUCT_ID = 2308 AND ORDER_ID = 2355

/*Изведете служителите, които получават заплата > 10000*/
SELECT *
FROM EMPLOYEES 
WHERE SALARY  > 10000

/*Изведете имената на служителите и номерата на мениджърите им*/
SELECT FNAME, LNAME, MANAGER_ID
FROM EMPLOYEES

SELECT FNAME + ' ' + LNAME AS EMPLOYEE, MANAGER_ID
FROM EMPLOYEES

/*Изведете имената и цените на всички продукти, които имат цена >= 500 и <= 1000*/
SELECT NAME, PRICE 
FROM PRODUCTS
WHERE PRICE >= 500 AND PRICE <= 1000

SELECT NAME, PRICE
FROM PRODUCTS
WHERE PRICE BETWEEN 500 AND 1000





-----------------------------------
/*Изведете броя служители във фирмата*/
SELECT COUNT(*) AS TOTAL
FROM EMPLOYEES

/*Изведете датата, на която е бил назначен първия служител във фирмата и името на 
служителя с най-ранно назначение*/ 
SELECT MIN(HIRE_DATE) 
FROM EMPLOYEES

SELECT FNAME, LNAME, HIRE_DATE 
FROM EMPLOYEES
WHERE HIRE_DATE = (SELECT MIN(HIRE_DATE) FROM EMPLOYEES)

SELECT TOP 1 WITH TIES FNAME, LNAME, HIRE_DATE 
FROM EMPLOYEES
ORDER BY HIRE_DATE   
--ASC / DESC 

/*Изведете датата, на която е бил назначен последния служител във фирмата и името на 
служителя с най-късно назначение*/ 
SELECT FNAME, LNAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE = (SELECT MAX(HIRE_DATE) FROM EMPLOYEES)

SELECT TOP 1 WITH TIES FNAME, LNAME, HIRE_DATE 
FROM EMPLOYEES
ORDER BY HIRE_DATE DESC 

/*Изведете сумата на заплатите от отдел 50*/
SELECT SUM(SALARY)  AS TOTAL 
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 50

/*Изведете стойността на поръчка 2355*/
SELECT SUM(UNIT_PRICE * QUANTITY) AS TOTAL 
FROM ORDER_ITEMS
WHERE ORDER_ID = 2355

/*Изведете номерата и стойността на всички поръчки*/
SELECT ORDER_ID, SUM(UNIT_PRICE * QUANTITY) AS TOTAL 
FROM ORDER_ITEMS
GROUP BY ORDER_ID

/*Изведете номерата на отделите, броя служители в тях и съответната средна заплата*/
SELECT DEPARTMENT_ID, COUNT(EMPLOYEE_ID) AS EMPL_COUNT, AVG(SALARY) AS AVG_SALARY 
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID

/*Изведете номерата на продуктите и общото количество, в което са били поръчани*/
SELECT PRODUCT_ID, SUM(QUANTITY) AS TOTAL 
FROM ORDER_ITEMS
GROUP BY PRODUCT_ID

/*Изведете ид-тата на длъжностите и средната заплата за всяка от тях*/
SELECT JOB_ID, AVG(SALARY) AS AVG_SALARY
FROM EMPLOYEES
GROUP BY JOB_ID

/*Изведете номерата на клиентите и броя поръчки, които са правили. 
Подредете резултата по брой поръчки низходящо*/
SELECT CUSTOMER_ID, COUNT(ORDER_ID) AS TOTAL 
FROM ORDERS
GROUP BY CUSTOMER_ID
ORDER BY TOTAL DESC 

