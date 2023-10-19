/*Изведете ид-тата на продуктите и общата им стойност от направените поръчки*/
SELECT PRODUCT_ID, SUM(UNIT_PRICE * QUANTITY) AS TOTAL 
FROM ORDER_ITEMS
GROUP BY PRODUCT_ID

/*Изведете броя на клиентите*/
SELECT COUNT(CUSTOMER_ID) AS TOTAL 
FROM CUSTOMERS

/*Изведете броя на поръчките на всеки клиент.В резултата да участват само 
клиентите, които са направили повече от 3 поръчки. */
SELECT CUSTOMER_ID, COUNT(ORDER_ID) AS TOTAL 
FROM ORDERS
GROUP BY CUSTOMER_ID
HAVING COUNT(ORDER_ID) > 3 

/*Изведете номерата н длъжностите и броя служители, работещи на съответната длъжност*/
SELECT JOB_ID, COUNT(EMPLOYEE_ID) AS TOTAL 
FROM EMPLOYEES
GROUP BY JOB_ID





















/*Изведете имената на държавите и имената на регионите, в които се намират*/
SELECT REGIONS.NAME AS REGION, COUNTRIES.NAME AS COUNTRY
FROM REGIONS JOIN COUNTRIES
ON REGIONS.REGION_ID =COUNTRIES.REGION_ID

SELECT R.NAME AS REGION, C.NAME AS COUNTRY
FROM REGIONS R JOIN COUNTRIES C
ON R.REGION_ID =C.REGION_ID

/*Изведете имената на държавите и имената на регионите, в които се намират, 
нека в резултата участват и регионите, в които няма държави*/
SELECT R.NAME AS REGION, C.NAME AS COUNTRY
FROM REGIONS R LEFT JOIN COUNTRIES C
ON R.REGION_ID =C.REGION_ID

SELECT R.NAME AS REGION, C.NAME AS COUNTRY 
FROM COUNTRIES C RIGHT JOIN REGIONS R 
ON C.REGION_ID = R.REGION_ID
/*Изведете имената на държавите и имената на регионите, в които се намират,
 нека в резултата участват и държавите, които нямат региони*/
SELECT R.NAME AS REGION, C.NAME AS COUNTRY
FROM REGIONS R RIGHT JOIN COUNTRIES C
ON R.REGION_ID =C.REGION_ID

SELECT R.NAME AS REGION, C.NAME AS COUNTRY
FROM COUNTRIES C LEFT JOIN REGIONS R
ON C.REGION_ID = R.REGION_ID

 
/*Изведете имената на държавите и имената на регионите, в които се намират, 
нека в резултата участват държавите,които нямат регионите и регионите, 
 в които няма държави*/
 SELECT R.NAME AS REGION, C.NAME AS COUNTRY
FROM REGIONS R FULL JOIN COUNTRIES C
ON R.REGION_ID =C.REGION_ID

/*Изведете имената на клиентите и броя поръчки, които са правили. 
Подредете резултата по брой поръчки низходящо*/
SELECT FNAME + ' ' + LNAME AS CUSTOMER, COUNT(ORDER_ID) AS TOTAL 
FROM CUSTOMERS C JOIN ORDERS O 
ON C.CUSTOMER_ID = O.CUSTOMER_ID
GROUP  BY FNAME + ' ' + LNAME 
ORDER BY TOTAL DESC 

/*Изведете имената на клиентите и броя поръчки, нека в резултата участват и
 клиентите,които не са правили поръчки до момента, подредете по брой 
 поръчки низходящо*/
SELECT FNAME + ' ' + LNAME AS CUSTOMER, COUNT(ORDER_ID) AS TOTAL 
FROM CUSTOMERS C LEFT JOIN ORDERS O 
ON C.CUSTOMER_ID = O.CUSTOMER_ID
GROUP  BY FNAME + ' ' + LNAME 
ORDER BY TOTAL DESC 

/*Изведете имената на служителите и наименованието на длъжността им*/
SELECT FNAME + ' ' + LNAME AS EMPLOYEE, JOB_TITLE 
FROM EMPLOYEES E JOIN JOBS J 
ON E.JOB_ID = J.JOB_ID

/*Изведете имената на клиентите, имената на държавите, в които се намират 
и имената на регионите на съответните държави*/
SELECT FNAME + ' ' + LNAME AS CUSTOMER, CO.NAME AS COUNTRY, R.NAME AS REGION 
FROM CUSTOMERS C JOIN COUNTRIES CO 
ON C.COUNTRY_ID = CO.COUNTRY_ID
JOIN REGIONS R 
ON R.REGION_ID = CO.REGION_ID

/*Изведете имената на клиентите и общата стойност на поръчките, които са 
направили*/
SELECT FNAME + ' ' + LNAME AS CUSTOMER, SUM(UNIT_PRICE * QUANTITY) AS TOTAL 
FROM CUSTOMERS C JOIN ORDERS O 
ON O.CUSTOMER_ID = C.CUSTOMER_ID
JOIN ORDER_ITEMS OI 
ON O.ORDER_ID = OI.ORDER_ID
GROUP BY FNAME + ' ' + LNAME 

/*Изведете имената на клиентите и общата стойност на поръчките, които са 
направили, нека в резултата участват само клиентите с обща стойност на 
поръчките над 10000*/
SELECT FNAME + ' ' + LNAME AS CUSTOMER, SUM(UNIT_PRICE * QUANTITY) AS TOTAL 
FROM CUSTOMERS C JOIN ORDERS O 
ON O.CUSTOMER_ID = C.CUSTOMER_ID
JOIN ORDER_ITEMS OI 
ON O.ORDER_ID = OI.ORDER_ID
GROUP BY FNAME + ' ' + LNAME 
HAVING SUM(UNIT_PRICE * QUANTITY) > 10000

/*Изведете имената на отделите и броя служители в тях, нека в резултата 
участват само отдели с повече от 5 назначени служители*/
SELECT NAME, COUNT(EMPLOYEE_ID) AS TOTAL 
FROM DEPARTMENTS  D JOIN EMPLOYEES E 
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
GROUP BY NAME 
HAVING COUNT(EMPLOYEE_ID) > 5

/*Изведете имената на отделите и броя служители в тях, нека в резултата 
участват само отдели с повече от 5 назначени служители и отдели, които се
 намират в държавите US или DE*/
SELECT NAME, COUNT(EMPLOYEE_ID) AS TOTAL 
FROM DEPARTMENTS  D JOIN EMPLOYEES E 
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
WHERE D.COUNTRY_ID IN ('US', 'DE')
GROUP BY NAME 
HAVING COUNT(EMPLOYEE_ID) > 5

