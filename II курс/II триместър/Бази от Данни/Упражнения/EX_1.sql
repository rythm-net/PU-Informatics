/*��������� ��������� �� ������ ���������, ����� ������� � ����� 50, � 1000*/
UPDATE EMPLOYEES
SET SALARY += 1000
WHERE DEPARTMENT_ID = 50

/*��������� ��������� �� �����������, ����� ������� � ����� 80 � ��������� ������� 
������� ��-����� �� 700 � 10%*/
UPDATE EMPLOYEES
SET SALARY *= 1.1
WHERE DEPARTMENT_ID = 80 AND SALARY/12 < 700

/*��������� ������������, � ����� � ��� ������� ������� 2308 � ������� 2355 � 200 ��.
� �������� ���������� ���� � 5%*/
UPDATE ORDER_ITEMS
SET QUANTITY += 200, UNIT_PRICE *= 0.95
WHERE PRODUCT_ID = 2308 AND ORDER_ID = 2355

/*�������� �����������, ����� ��������� ������� > 10000*/
SELECT *
FROM EMPLOYEES 
WHERE SALARY  > 10000

/*�������� ������� �� ����������� � �������� �� ����������� ��*/
SELECT FNAME, LNAME, MANAGER_ID
FROM EMPLOYEES

SELECT FNAME + ' ' + LNAME AS EMPLOYEE, MANAGER_ID
FROM EMPLOYEES

/*�������� ������� � ������ �� ������ ��������, ����� ���� ���� >= 500 � <= 1000*/
SELECT NAME, PRICE 
FROM PRODUCTS
WHERE PRICE >= 500 AND PRICE <= 1000

SELECT NAME, PRICE
FROM PRODUCTS
WHERE PRICE BETWEEN 500 AND 1000





-----------------------------------
/*�������� ���� ��������� ��� �������*/
SELECT COUNT(*) AS TOTAL
FROM EMPLOYEES

/*�������� ������, �� ����� � ��� �������� ������ �������� ��� ������� � ����� �� 
��������� � ���-����� ����������*/ 
SELECT MIN(HIRE_DATE) 
FROM EMPLOYEES

SELECT FNAME, LNAME, HIRE_DATE 
FROM EMPLOYEES
WHERE HIRE_DATE = (SELECT MIN(HIRE_DATE) FROM EMPLOYEES)

SELECT TOP 1 WITH TIES FNAME, LNAME, HIRE_DATE 
FROM EMPLOYEES
ORDER BY HIRE_DATE   
--ASC / DESC 

/*�������� ������, �� ����� � ��� �������� ��������� �������� ��� ������� � ����� �� 
��������� � ���-����� ����������*/ 
SELECT FNAME, LNAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE = (SELECT MAX(HIRE_DATE) FROM EMPLOYEES)

SELECT TOP 1 WITH TIES FNAME, LNAME, HIRE_DATE 
FROM EMPLOYEES
ORDER BY HIRE_DATE DESC 

/*�������� ������ �� ��������� �� ����� 50*/
SELECT SUM(SALARY)  AS TOTAL 
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 50

/*�������� ���������� �� ������� 2355*/
SELECT SUM(UNIT_PRICE * QUANTITY) AS TOTAL 
FROM ORDER_ITEMS
WHERE ORDER_ID = 2355

/*�������� �������� � ���������� �� ������ �������*/
SELECT ORDER_ID, SUM(UNIT_PRICE * QUANTITY) AS TOTAL 
FROM ORDER_ITEMS
GROUP BY ORDER_ID

/*�������� �������� �� ��������, ���� ��������� � ��� � ����������� ������ �������*/
SELECT DEPARTMENT_ID, COUNT(EMPLOYEE_ID) AS EMPL_COUNT, AVG(SALARY) AS AVG_SALARY 
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID

/*�������� �������� �� ���������� � ������ ����������, � ����� �� ���� ��������*/
SELECT PRODUCT_ID, SUM(QUANTITY) AS TOTAL 
FROM ORDER_ITEMS
GROUP BY PRODUCT_ID

/*�������� ��-���� �� ����������� � �������� ������� �� ����� �� ���*/
SELECT JOB_ID, AVG(SALARY) AS AVG_SALARY
FROM EMPLOYEES
GROUP BY JOB_ID

/*�������� �������� �� ��������� � ���� �������, ����� �� �������. 
��������� ��������� �� ���� ������� ���������*/
SELECT CUSTOMER_ID, COUNT(ORDER_ID) AS TOTAL 
FROM ORDERS
GROUP BY CUSTOMER_ID
ORDER BY TOTAL DESC 

