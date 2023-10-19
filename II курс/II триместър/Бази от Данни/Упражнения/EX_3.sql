/*Изведете имената на продуктите и общото количество, в което са били 
поръчани, нека в резултата участват само продуктите, които са поръчани в 
общо количество > 1000. Подредете резултата по общо количество низходящо*/
SELECT NAME, SUM(QUANTITY) AS TOTAL 
FROM PRODUCTS P JOIN ORDER_ITEMS OI 
ON P.PRODUCT_ID = OI.PRODUCT_ID
GROUP BY NAME 
HAVING SUM(QUANTITY) > 1000
ORDER BY TOTAL DESC 

/*Изведете имената на служителите и имената на техните преки началници*/
SELECT E.FNAME + ' ' + E.LNAME AS EMPLOYEE, M.FNAME + ' ' + M.LNAME AS MANAGER 
FROM EMPLOYEES E JOIN EMPLOYEES M 
ON E.MANAGER_ID = M.EMPLOYEE_ID

/*Изведете имената на служителите и имената на техните преки началници,
 нека в резултата участват и служителите, които нямат преки началници*/
SELECT E.FNAME + ' ' + E.LNAME AS EMPLOYEE, M.FNAME + ' ' + M.LNAME AS MANAGER 
FROM EMPLOYEES E LEFT JOIN EMPLOYEES M 
ON E.MANAGER_ID = M.EMPLOYEE_ID

/*Изведете имената на служителите, които получават заплата по-голяма от 
заплатата на служител Peter Hall*/
SELECT E.FNAME + ' ' + E.LNAME AS EMPLOYEE
FROM EMPLOYEES E JOIN EMPLOYEES PH 
ON E.SALARY > PH.SALARY
WHERE PH.FNAME = 'Peter' AND PH.LNAME = 'Hall'

SELECT FNAME + ' ' + LNAME AS EMPLOYEE
FROM EMPLOYEES
WHERE SALARY > (SELECT SALARY 
				FROM EMPLOYEES 
				WHERE FNAME = 'Peter' AND LNAME = 'Hall')












----------any, all, like
/*Изведете имената на служителите, които получават заплата по-голяма от 
заплатата на някой от служителите, който работи в отдел 80*/
SELECT FNAME + ' ' + LNAME AS EMPLOYEE
FROM EMPLOYEES
WHERE SALARY > ANY (SELECT SALARY 
					FROM EMPLOYEES
					WHERE DEPARTMENT_ID = 80)

/*Изведете имената на служителите, които получават заплата по-голяма от 
заплатата на всеки от служителите, който работи в отдел 80*/
SELECT FNAME + ' ' + LNAME AS EMPLOYEE
FROM EMPLOYEES
WHERE SALARY > ALL (SELECT SALARY 
					FROM EMPLOYEES
					WHERE DEPARTMENT_ID = 80)

/*Изведете всички служители, които са наети след някой от служителите работещи в отдел 80*/
SELECT FNAME + ' ' + LNAME AS EMPLOYEE
FROM EMPLOYEES
WHERE HIRE_DATE > ANY (SELECT HIRE_DATE
						FROM EMPLOYEES
						WHERE DEPARTMENT_ID = 80)

/*Изведете служителите, които получават заплата по-висока всички минимални заплати, 
дефинирани за заеманите длъжности*/
SELECT FNAME + ' ' + LNAME AS EMPLOYEE
FROM EMPLOYEES 
WHERE SALARY > ALL (SELECT MIN_SALARY 
					FROM JOBS
					WHERE MIN_SALARY IS NOT NULL)

/*Изведете номерата и датите на всички поръчки, които са направени
 след 12.04.2008*/
 SELECT ORDER_ID, ORDER_DATE 
 FROM ORDERS
 WHERE ORDER_DATE > '2008-04-12'

/*Изведете имената и датите на назначаване на служителите, като изведете
 датите в стил 109*/
 SELECT FNAME + ' ' + LNAME AS EMPLOYEE, HIRE_DATE,
 CONVERT(VARCHAR, HIRE_DATE, 109) AS CONVERTED_DATE
 FROM EMPLOYEES

 SELECT YEAR(HIRE_DATE) 
 FROM EMPLOYEES

  SELECT MONTH(HIRE_DATE) 
 FROM EMPLOYEES

  SELECT DAY(HIRE_DATE) 
 FROM EMPLOYEES

 SELECT GETDATE()

/*Изведете имената, датите на назначаване и месеца, в който е бил назначен
 всеки един служител*/
 SELECT FNAME + ' '  + LNAME AS EMPLOYEE, HIRE_DATE, 
 DATENAME(MONTH, HIRE_DATE) AS MONTH_NAME
 FROM EMPLOYEES
 
/*Изведете имената и фамилиите на всички служители, чиято фамилия започва
 с буква М*/
 SELECT FNAME + ' ' + LNAME AS EMPLOYEE
 FROM EMPLOYEES
 WHERE LNAME LIKE 'M%'

 SELECT FNAME + ' ' + LNAME AS EMPLOYEE
 FROM EMPLOYEES
 WHERE LNAME LIKE 'M%n'

  SELECT FNAME + ' ' + LNAME AS EMPLOYEE
 FROM EMPLOYEES
 WHERE LNAME LIKE 'M__%i%n'

   SELECT FNAME + ' ' + LNAME AS EMPLOYEE
 FROM EMPLOYEES
 WHERE LNAME LIKE 'Mc__%i%n'

/*Изведете имената на държавите, в които има клиенти или отдели на фирмата*/
SELECT NAME 
FROM COUNTRIES C JOIN CUSTOMERS CU
ON C.COUNTRY_ID = CU.COUNTRY_ID
UNION
SELECT C.NAME 
FROM COUNTRIES C JOIN DEPARTMENTS D 
ON C.COUNTRY_ID =D.COUNTRY_ID


SELECT FNAME 
FROM CUSTOMERS
UNION 
SELECT FNAME 
FROM EMPLOYEES

SELECT FNAME, NULL  
FROM CUSTOMERS
UNION 
SELECT FNAME, LNAME
FROM EMPLOYEES


SELECT FNAME, CAST(CUSTOMER_ID AS VARCHAR)
FROM CUSTOMERS
UNION 
SELECT FNAME, LNAME 
FROM EMPLOYEES





