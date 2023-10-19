/*
INTERSECT -ANY, IN, EXISTS
EXCEPT - <> ALL, NOT IN, EXISTS
*/

/*�������� ������� ����� � ������, ����� ����������� � �� �������� � �� ������*/
SELECT FNAME 
FROM EMPLOYEES
INTERSECT 
SELECT FNAME 
FROM CUSTOMERS

SELECT FNAME 
FROM CUSTOMERS
INTERSECT 
SELECT FNAME 
FROM EMPLOYEES

SELECT DISTINCT FNAME 
FROM EMPLOYEES
WHERE FNAME  = ANY (SELECT FNAME	
					FROM CUSTOMERS)

SELECT DISTINCT FNAME 
FROM EMPLOYEES
WHERE FNAME IN (SELECT FNAME	
				FROM CUSTOMERS)

SELECT DISTINCT FNAME
FROM EMPLOYEES E 
WHERE EXISTS (SELECT *
				FROM CUSTOMERS C 
				WHERE C.FNAME  = E.FNAME )

/*�������� ������� ����� � ������, ����� ����������� �� ��������� � �� ����������� �� �������*/
SELECT FNAME 
FROM EMPLOYEES
EXCEPT
SELECT FNAME 
FROM CUSTOMERS

--REVERSE 
SELECT FNAME 
FROM CUSTOMERS
EXCEPT
SELECT FNAME 
FROM EMPLOYEES

SELECT DISTINCT FNAME 
FROM EMPLOYEES
WHERE FNAME <> ALL (SELECT FNAME FROM CUSTOMERS)

SELECT DISTINCT FNAME 
FROM EMPLOYEES
WHERE FNAME NOT IN (SELECT FNAME FROM CUSTOMERS)

SELECT DISTINCT FNAME 
FROM EMPLOYEES E
WHERE NOT EXISTS (SELECT * 
					FROM CUSTOMERS C 
					WHERE C.FNAME = E.FNAME)
/*�������� ������� �� ���������, � ����� ��� ������� � �������� �� �������*/
SELECT NAME 
FROM COUNTRIES C JOIN CUSTOMERS CU 
ON C.COUNTRY_ID = CU.COUNTRY_ID
INTERSECT 
SELECT C.NAME 
FROM COUNTRIES C JOIN DEPARTMENTS D 
ON C.COUNTRY_ID = D.COUNTRY_ID

/*�������� ������� �� ���������, � ����� ��� ������� � ���� ������ �� �������*/
SELECT NAME 
FROM COUNTRIES C JOIN CUSTOMERS CU 
ON C.COUNTRY_ID = CU.COUNTRY_ID
EXCEPT 
SELECT C.NAME 
FROM COUNTRIES C JOIN DEPARTMENTS D 
ON C.COUNTRY_ID = D.COUNTRY_ID


/*�������� ������� �� �����������, ����� �� ��������� �������� ��� �������*/ 
SELECT TOP 1 WITH TIES FNAME + ' ' + LNAME AS EMPLOYEE, HIRE_DATE
FROM EMPLOYEES 
ORDER BY HIRE_DATE DESC 

/*�������� ��������, ������ � ���������� �� ������ �������
��������� ���� 2000 ������*/
SELECT O.ORDER_ID, ORDER_DATE, SUM(UNIT_PRICE * QUANTITY) AS TOTAL
FROM ORDERS O  JOIN ORDER_ITEMS OI
ON O.ORDER_ID = OI.ORDER_ID
WHERE YEAR(ORDER_DATE) = 2000
GROUP BY O.ORDER_ID, ORDER_DATE

/*�������� ��������, ������ � ���������� �� ����� �������, ���� ��� ����� ������� ������ �� ����
������� 7 ��� ���� ���� � ��������, �������� � ������, �� ����� ������ �� ���� �������.*/
SELECT O.ORDER_ID, ORDER_DATE, SUM(UNIT_PRICE * QUANTITY) AS TOTAL, 
DATEADD(DAY, 7, ORDER_DATE) AS PAID_DATE
FROM ORDERS O JOIN ORDER_ITEMS OI 
ON O.ORDER_ID = OI.ORDER_ID
GROUP BY O.ORDER_ID, ORDER_DATE

/*�������� ������� �� ����������� � ���� �������, ����� �� �����������. ���� � ��������� 
�������� � �����������, ����� �� �� ����������� ������� �� �������.*/
SELECT FNAME + ' ' + LNAME AS EMPLOYEE, COUNT(ORDER_ID) AS TOTAL 
FROM EMPLOYEES E LEFT JOIN ORDERS O 
ON E.EMPLOYEE_ID = O.EMPLOYEE_ID
GROUP BY FNAME  + ' ' +  LNAME 

/*�������� ����������, ����� ����� �������� � S, ���� ���� ��� ������� �������  � 
��������� �� L*/
SELECT NAME 
FROM PRODUCTS
WHERE NAME LIKE 'S___%L'

/*�������� ������� �� ���������, ����� �� �������� ���-������� � ���-�������� �������
� ���������� �� ����������� �������*/
SELECT *
FROM (SELECT TOP 1 FNAME + ' ' + LNAME AS CUSTOMER, O.ORDER_ID, 
SUM(UNIT_PRICE  *QUANTITY) AS TOTAL 
FROM CUSTOMERS C JOIN ORDERS O 
ON C.CUSTOMER_ID = O.CUSTOMER_ID
JOIN ORDER_ITEMS OI
ON O.ORDER_ID = OI.ORDER_ID
GROUP BY FNAME + ' ' + LNAME, O.ORDER_ID
ORDER BY TOTAL) MIN_ORD
UNION
SELECT * 
FROM (SELECT TOP 1 FNAME + ' ' + LNAME AS CUSTOMER, O.ORDER_ID, 
SUM(UNIT_PRICE  *QUANTITY) AS TOTAL 
FROM CUSTOMERS C JOIN ORDERS O 
ON C.CUSTOMER_ID = O.CUSTOMER_ID
JOIN ORDER_ITEMS OI
ON O.ORDER_ID = OI.ORDER_ID
GROUP BY FNAME + ' ' + LNAME, O.ORDER_ID
ORDER BY TOTAL DESC ) MAX_ORD