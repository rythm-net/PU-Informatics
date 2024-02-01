/*==============================================================*/
/* Table: REGIONS                                               */
/*==============================================================*/
create table REGIONS 
(
   REGION_ID smallint    not null primary key identity(1, 1),
   NAME      varchar(25) not null unique
)

/*==============================================================*/
/* Table: COUNTRIES                                             */
/*==============================================================*/
create table COUNTRIES 
(
   COUNTRY_ID           char(2)              not null,
   NAME                 varchar(40)          not null,
   REGION_ID            smallint             null,
   constraint PK_COUNTRY primary key (COUNTRY_ID),
   constraint FK_COUNTRIES_REGIONS foreign key (REGION_ID)
      references REGIONS (REGION_ID)
)
go

/*==============================================================*/
/* Table: CUSTOMERS                                             */
/*==============================================================*/
create table CUSTOMERS 
(
   CUSTOMER_ID          numeric(6)           not null,
   COUNTRY_ID           char(2)              not null,
   FNAME                varchar(20)          not null,
   LNAME                varchar(20)          not null,
   ADDRESS              text                 null,
   EMAIL                varchar(30)          null,
   GENDER               char(1)              null default 'M'
      constraint CUST_GENDER check (GENDER is null or (GENDER in ('M','F'))),
   constraint PK_CUSTOMERS primary key (CUSTOMER_ID)
)
go

/*==============================================================*/
/* Table: DEPARTMENTS                                           */
/*==============================================================*/
create table DEPARTMENTS 
(
   DEPARTMENT_ID        int                  not null,
   NAME                 varchar(30)          not null,
   MANAGER_ID           int                  null,
   COUNTRY_ID           char(2)              not null,
   CITY                 varchar(30)          not null,
   STATE                varchar(25)          null,
   ADDRESS              varchar(40)          null,
   POSTAL_CODE          varchar(12)          null,
   constraint PK_DEPT primary key (DEPARTMENT_ID)
)
go

/*==============================================================*/
/* Table: EMPLOYEES                                             */
/*==============================================================*/
create table EMPLOYEES 
(
   EMPLOYEE_ID          int                  not null,
   FNAME                varchar(20)          not null,
   LNAME                varchar(25)          not null,
   EMAIL                varchar(40)          not null,
   PHONE                varchar(20)          null,
   HIRE_DATE            date                 not null,
   SALARY               numeric(8,2)         not null
      constraint EMP_SALARY_MIN check (SALARY > 0),
   JOB_ID               varchar(10)          not null,
   MANAGER_ID           int                  null,
   DEPARTMENT_ID        int                  null,
   constraint PK_EMP primary key (EMPLOYEE_ID),
   constraint UK_EMP unique (EMAIL)
)
go

/*==============================================================*/
/* Table: JOBS                                                  */
/*==============================================================*/
create table JOBS 
(
   JOB_ID               varchar(10)          not null,
   JOB_TITLE            varchar(35)          not null,
   MIN_SALARY           numeric(6)           null,
   MAX_SALARY           numeric(6)           null,
   constraint PK_JOB primary key (JOB_ID)
)
go

/*==============================================================*/
/* Table: ORDERS                                                */
/*==============================================================*/
create table ORDERS 
(
   ORDER_ID             int                  not null,
   ORDER_DATE           datetime             not null,
   CUSTOMER_ID          numeric(6)           not null,
   EMPLOYEE_ID          int                  not null,
   SHIP_ADDRESS         varchar(150)         null,
   constraint PK_ORDER primary key (ORDER_ID)
)
go

/*==============================================================*/
/* Table: ORDER_ITEMS                                           */
/*==============================================================*/
create table ORDER_ITEMS 
(
   ORDER_ID             int                  not null,
   PRODUCT_ID           integer              not null,
   UNIT_PRICE           numeric(8,2)         not null,
   QUANTITY             numeric(8)           not null,
   constraint PK_ORDER_ITEMS primary key (ORDER_ID, PRODUCT_ID)
)
go

/*==============================================================*/
/* Table: PRODUCTS                                              */
/*==============================================================*/
create table PRODUCTS 
(
   PRODUCT_ID           int                  not null,
   NAME                 varchar(70)          not null,
   PRICE                numeric(8,2)         not null,
   DESCR                varchar(2000)        null,
   constraint PK_PRODUCTS primary key (PRODUCT_ID)
)
go


alter table CUSTOMERS
   add constraint FK_CUSTOMER_COUNTRIES foreign key (COUNTRY_ID)
      references COUNTRIES (COUNTRY_ID)
go

alter table DEPARTMENTS
   add constraint DEPT_MGR_FK foreign key (MANAGER_ID)
      references EMPLOYEES (EMPLOYEE_ID)
go

alter table DEPARTMENTS
   add constraint FK_DEPT_REFERENCE_COUNTRIE foreign key (COUNTRY_ID)
      references COUNTRIES (COUNTRY_ID)
go

alter table EMPLOYEES
   add constraint FK_EMPLOYEE_DEPARTMENTS foreign key (DEPARTMENT_ID)
      references DEPARTMENTS (DEPARTMENT_ID)
go

alter table EMPLOYEES
   add constraint FK_EMPLOYEE_JOBS foreign key (JOB_ID)
      references JOBS (JOB_ID)
go

alter table EMPLOYEES
   add constraint FK_EMPLOYEE_MANAGERS foreign key (MANAGER_ID)
      references EMPLOYEES (EMPLOYEE_ID)
go

alter table ORDERS
   add constraint FK_ORDERS_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMERS (CUSTOMER_ID)
go

alter table ORDERS
   add constraint FK_ORDERS_REFERENCE_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEES (EMPLOYEE_ID)
go

alter table ORDER_ITEMS
   add constraint FK_ORD_ITEM_ORDERS foreign key (ORDER_ID)
      references ORDERS (ORDER_ID)
         on update cascade on delete cascade
go

alter table ORDER_ITEMS
   add constraint FK_ORD_ITEM_PRODUCTS foreign key (PRODUCT_ID)
      references PRODUCTS (PRODUCT_ID)
go

