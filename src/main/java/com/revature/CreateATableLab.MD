## Create A Table Lab

As of right now, all the data that we are storing into variables in java are lost when the application ends. We need a tool that will allow us to persist data past the lifetime of the java application. The most common tool to achieve this is a database.


The specific type of database we will be utilizing uses a language called SQL (Structure Query Language). Before we store or retrieve any data, we need to define the format in which it is stored. SQL utilizes tables as its format. This follows a similar format to a spreadsheet.



### The tables will have rows and columns:

- A column defines one attribute of a table.

- A row defines a complete item in the table.



### The syntax for Creating a table is as follows:

```sql
CREATE TABLE table_name(
     variable_name datatype constraint,
     ...
);
```

### Note: there are two terms above that we need clarity on:

- ### Datatype:
  - A datatype defines what type of data we will be storing into this specific column.
  - Common datatypes:
    - **`int`**: stores whole numbers
    - **`double precision`**: stores decimal numbers
    - **`varchar(100)`**: stores a string of 100 characters maximum
    - **`boolean`**: stores true and false values
- ### Constraint:
  - a constraint is a rule we can add to a column that anyone who wants to insert records into this table must follow
  - Common Constraints:
    - **`NOT NULL`**: the column must have a value when inserting a record
    - **`UNIQUE`**: every record in a specific column must have a unique value
  - If a constraint that was defined is not met when inserting a record, a SQLException will be thrown.

Additional reference material if needed:

- https://www.w3schools.com/sql/sql_create_table.asp
- https://www.w3schools.com/sql/sql_constraints.asp

## Problem 1

| title     | artist  |
| --------- | ------- |
| Let it be | Beatles |
| Imagine   | Beatles |

***Create a new table in the "problem1.sql" file called "songs" with 2 columns "Title" and "Artist".***



## Problem 2

| title (UNIQUE and NOT NULL) | artist (NOT NULL) |
| --------------------------- | ----------------- |
| Let it be                   | Beatles           |
| Imagine                     | Beatles           |

***Create the same table in the "problem2.sql" however the title column should have the `NOT NULL` and `UNIQUE` constraint and the artist column should have the `NOT NULL` constraint.***
