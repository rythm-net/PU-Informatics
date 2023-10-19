/*�������� ��-���� �� ���������� � ������ �� �������� �� ����������� �������*/
SELECT PRODUCT_ID, SUM(UNIT_PRICE * QUANTITY) AS TOTAL 
FROM ORDER_ITEMS
GROUP BY PRODUCT_ID

/*�������� ���� �� ���������*/
SELECT COUNT(CUSTOMER_ID) AS TOTAL 
FROM CUSTOMERS

/*�������� ���� �� ��������� �� ����� ������.� ��������� �� �������� ���� 
���������, ����� �� ��������� ������ �� 3 �������. */
SELECT CUSTOMER_ID, COUNT(ORDER_ID) AS TOTAL 
FROM ORDERS
GROUP BY CUSTOMER_ID
HAVING COUNT(ORDER_ID) > 3 

/*�������� �������� � ����������� � ���� ���������, �������� �� ����������� ��������*/
SELECT JOB_ID, COUNT(EMPLOYEE_ID) AS TOTAL 
FROM EMPLOYEES
GROUP BY JOB_ID





















/*�������� ������� �� ��������� � ������� �� ���������, � ����� �� �������*/
SELECT REGIONS.NAME AS REGION, COUNTRIES.NAME AS COUNTRY
FROM REGIONS JOIN COUNTRIES
ON REGIONS.REGION_ID =COUNTRIES.REGION_ID

SELECT R.NAME AS REGION, C.NAME AS COUNTRY
FROM REGIONS R JOIN COUNTRIES C
ON R.REGION_ID =C.REGION_ID

/*�������� ������� �� ��������� � ������� �� ���������, � ����� �� �������, 
���� � ��������� �������� � ���������, � ����� ���� �������*/
SELECT R.NAME AS REGION, C.NAME AS COUNTRY
FROM REGIONS R LEFT JOIN COUNTRIES C
ON R.REGION_ID =C.REGION_ID

SELECT R.NAME AS REGION, C.NAME AS COUNTRY 
FROM COUNTRIES C RIGHT JOIN REGIONS R 
ON C.REGION_ID = R.REGION_ID
/*�������� ������� �� ��������� � ������� �� ���������, � ����� �� �������,
 ���� � ��������� �������� � ���������, ����� ����� �������*/
SELECT R.NAME AS REGION, C.NAME AS COUNTRY
FROM REGIONS R RIGHT JOIN COUNTRIES C
ON R.REGION_ID =C.REGION_ID

SELECT R.NAME AS REGION, C.NAME AS COUNTRY
FROM COUNTRIES C LEFT JOIN REGIONS R
ON C.REGION_ID = R.REGION_ID

 
/*�������� ������� �� ��������� � ������� �� ���������, � ����� �� �������, 
���� � ��������� �������� ���������,����� ����� ��������� � ���������, 
 � ����� ���� �������*/
 SELECT R.NAME AS REGION, C.NAME AS COUNTRY
FROM REGIONS R FULL JOIN COUNTRIES C
ON R.REGION_ID =C.REGION_ID

/*�������� ������� �� ��������� � ���� �������, ����� �� �������. 
��������� ��������� �� ���� ������� ���������*/
SELECT FNAME + ' ' + LNAME AS CUSTOMER, COUNT(ORDER_ID) AS TOTAL 
FROM CUSTOMERS C JOIN ORDERS O 
ON C.CUSTOMER_ID = O.CUSTOMER_ID
GROUP  BY FNAME + ' ' + LNAME 
ORDER BY TOTAL DESC 

/*�������� ������� �� ��������� � ���� �������, ���� � ��������� �������� �
 ���������,����� �� �� ������� ������� �� �������, ��������� �� ���� 
 ������� ���������*/
SELECT FNAME + ' ' + LNAME AS CUSTOMER, COUNT(ORDER_ID) AS TOTAL 
FROM CUSTOMERS C LEFT JOIN ORDERS O 
ON C.CUSTOMER_ID = O.CUSTOMER_ID
GROUP  BY FNAME + ' ' + LNAME 
ORDER BY TOTAL DESC 

/*�������� ������� �� ����������� � �������������� �� ���������� ��*/
SELECT FNAME + ' ' + LNAME AS EMPLOYEE, JOB_TITLE 
FROM EMPLOYEES E JOIN JOBS J 
ON E.JOB_ID = J.JOB_ID

/*�������� ������� �� ���������, ������� �� ���������, � ����� �� ������� 
� ������� �� ��������� �� ����������� �������*/
SELECT FNAME + ' ' + LNAME AS CUSTOMER, CO.NAME AS COUNTRY, R.NAME AS REGION 
FROM CUSTOMERS C JOIN COUNTRIES CO 
ON C.COUNTRY_ID = CO.COUNTRY_ID
JOIN REGIONS R 
ON R.REGION_ID = CO.REGION_ID

/*�������� ������� �� ��������� � ������ �������� �� ���������, ����� �� 
���������*/
SELECT FNAME + ' ' + LNAME AS CUSTOMER, SUM(UNIT_PRICE * QUANTITY) AS TOTAL 
FROM CUSTOMERS C JOIN ORDERS O 
ON O.CUSTOMER_ID = C.CUSTOMER_ID
JOIN ORDER_ITEMS OI 
ON O.ORDER_ID = OI.ORDER_ID
GROUP BY FNAME + ' ' + LNAME 

/*�������� ������� �� ��������� � ������ �������� �� ���������, ����� �� 
���������, ���� � ��������� �������� ���� ��������� � ���� �������� �� 
��������� ��� 10000*/
SELECT FNAME + ' ' + LNAME AS CUSTOMER, SUM(UNIT_PRICE * QUANTITY) AS TOTAL 
FROM CUSTOMERS C JOIN ORDERS O 
ON O.CUSTOMER_ID = C.CUSTOMER_ID
JOIN ORDER_ITEMS OI 
ON O.ORDER_ID = OI.ORDER_ID
GROUP BY FNAME + ' ' + LNAME 
HAVING SUM(UNIT_PRICE * QUANTITY) > 10000

/*�������� ������� �� �������� � ���� ��������� � ���, ���� � ��������� 
�������� ���� ������ � ������ �� 5 ��������� ���������*/
SELECT NAME, COUNT(EMPLOYEE_ID) AS TOTAL 
FROM DEPARTMENTS  D JOIN EMPLOYEES E 
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
GROUP BY NAME 
HAVING COUNT(EMPLOYEE_ID) > 5

/*�������� ������� �� �������� � ���� ��������� � ���, ���� � ��������� 
�������� ���� ������ � ������ �� 5 ��������� ��������� � ������, ����� ��
 ������� � ��������� US ��� DE*/
SELECT NAME, COUNT(EMPLOYEE_ID) AS TOTAL 
FROM DEPARTMENTS  D JOIN EMPLOYEES E 
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
WHERE D.COUNTRY_ID IN ('US', 'DE')
GROUP BY NAME 
HAVING COUNT(EMPLOYEE_ID) > 5

