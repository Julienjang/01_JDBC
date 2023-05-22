package section02.template;

import static section02.template.JDBCTemplate.close;
import static section02.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.SQLException;


public class Application {

    public static void main(String[] args) {

        Connection con = getConnection();
        System.out.println(con);

        /*
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        */

        close(con);

    }

}
