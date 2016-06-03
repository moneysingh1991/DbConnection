package example;

import java.sql.SQLException;

/**
 * Created by maninder on 6/2/16.
 */
public class Dbcontroller {



    public static void main(String [] args)  {

        Database_controller db = new Database_controller();

        try {
            db.connect_database();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
