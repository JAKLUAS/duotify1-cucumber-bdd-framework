package com.duotify.dbDemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {


    public static void main(String[] args) throws SQLException {
        //jdbc:{driverType}://{urlToDBandSchema}
        String url = "jdbc:mysql://db-duotech.cc652zs7kmja.us-east-2.rds.amazonaws.com/employees";


        String username = "duotech";
        String password = "duotech2021";

        // Create connection obj
        Connection connection = DriverManager.getConnection(url, username, password);


        System.out.println("Connection success");


        // Creating statement obj heryerde once bu yaazilacak

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


        ResultSet resultSet = statement.executeQuery("SELECT * FROM (SELECT * FROM employees LIMIT 10) AS employees_t1 ORDER BY first_name");

        System.out.println(resultSet);

        resultSet.next();
        //Moves the cursor forward one row from its current position. A ResultSet cursor is initially positioned before the first row; the first call to the method next makes the first row the current row; the second call makes the second row the current row, and so on.

        String firstName =  resultSet.getString(3);

        System.out.println(firstName);






        // move to specific row
        resultSet.absolute(5);

        System.out.println(resultSet.getString(4));

        for (int i = 1; i <= 6; i++) {
            System.out.print(resultSet.getObject(i) + "\t");
        }

        System.out.println();

        resultSet.last();// which will move to the last row and get the info
        System.out.println(resultSet.getString(4));


        int rowCount = resultSet.getRow();  // gets the current row no

        System.out.println(rowCount);


        resultSet.absolute(2);

        System.out.println(resultSet.getString(4));
        System.out.println(resultSet.getString("last_name"));



        // count of columns

        ResultSetMetaData metaData = resultSet.getMetaData(); // which is the columns count of the columns name of the table

        int columnCount = metaData.getColumnCount();

        System.out.println("Columns: " + columnCount);



        List<String> columnNames =  new ArrayList<>();

        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        System.out.println(columnNames);


        for (String columnName : columnNames) {
            System.out.print(resultSet.getString(columnName) + "\t");
        }

        System.out.println();

        resultSet.beforeFirst();  //

//        while(resultSet.next()){              // it will give you the all names in that column
//            System.out.println(resultSet.getString(3));
//        }

// for each look takes every element in that table
        for (int i = 1; i <= rowCount ; i++) {
            resultSet.next();
            for (int j = 1; j <= columnCount ; j++) {
                System.out.print(resultSet.getString(j) + "\t");
            }

            System.out.println();

        }


        int i = statement.executeUpdate("UPDATE employees SET first_name='Asif', last_name='Hamzaev' where emp_no=10002");
        System.out.println(i);

//        statement.executeUpdate("INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date ) values (3, '2002-05-09', 'Lara', 'Alissa', 'M', '2022-09-01')");

        statement.executeUpdate("DELETE from employees where emp_no=1");


        resultSet.close();
        statement.close();
        connection.close();







    }
}
