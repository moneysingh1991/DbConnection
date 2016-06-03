package example;/**
 * Created by maninder on 6/2/16.
 */

import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import com.sun.security.ntlm.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author maninderpalsingh
 */
public class Database_controller {

  private String url = "jdbc:mysql://localhost:3306/androidlogin";
  private String userid = "root";
  private String password = "9872476129Mm";
  private String sql = "";


  public Connection connect_database() throws SQLException {

    Connection connection = null;

    connection = DriverManager.getConnection(url, userid, password);

    if(connection != null) {

      System.out.println("\n MY SQL connected success.............. \n");
    }


    return connection;
  }

  /**
   * this method for close open connetion
   * @return it will return true after close connection
   * @throws SQLException
     */
  public boolean close_connection() throws SQLException {

    if(connect_database() != null) {

      Connection connection = connect_database();

      connection.close();

      return true;  // return true after close connection

    } else {

      return false;  // return false  to show connection is still open
    }

  }

  /**
   * This method will execute statement and return result set and will accept string parameter
   * @param
     */

  public  void execute_statement(String sql) {


  }

  public void set_sql(String s) {
    sql = s;
  }

  public String get_sql() {
    return sql;
  }

  public void insert_client_into_db() {


  }

  public ArrayList getData_from_client_table() throws SQLException {

    ArrayList row = null;


    Connection connection = DriverManager.getConnection( url, userid, password );
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery( sql );

    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();


    if(columns > 0) {

      System.out.println(columns + " found");

      while (rs.next())
      {
        row = new ArrayList(columns);

        for (int i = 1; i <= columns; i++)
        {
          row.add( rs.getObject(i) );


        }
      }

    }

    return row;
  }

  public ArrayList getData_from_Account_table() throws SQLException {

    ArrayList row = null;


    Connection connection = DriverManager.getConnection( url, userid, password );
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery( sql );

    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();


    if(columns > 0) {

      System.out.println(columns + " found");

      while (rs.next())
      {
        row = new ArrayList(columns);

        for (int i = 1; i <= columns; i++)
        {
          row.add( rs.getObject(i) );


        }
      }

    }

    return row;
  }

  public void update_execute_sql_statement() throws SQLException {
    try (Connection connection = DriverManager.getConnection( url, userid, password );
         // Statement stmt = connection.createStatement();
         //ResultSet rs = stmt.executeUpdate()( sql ))
         PreparedStatement pst =  connection.prepareStatement(sql))

    {
      pst.executeUpdate(sql);

      //  md = rs.getMetaData();

    } catch (SQLException e)
    {
      System.out.println( e.getMessage() );
    }
  }

  public boolean check_db_exist() throws SQLException {

    Connection connection = DriverManager.getConnection( url, userid, password );

    Statement stmt = connection.createStatement();

    ResultSet rs = stmt.executeQuery( sql );


    ResultSetMetaData md = rs.getMetaData();

    int columns = md.getColumnCount();

    if(columns > 0) {

      return true;

    } else {

      return false;
    }

  }

  public String get_primary_key() throws SQLException {

    String key = null;

    ArrayList arr = null;

    if(check_db_exist()) {
      arr = getData_from_Account_table();
    }

    return arr.get(0).toString();
  }

}