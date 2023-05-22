package section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {

    public static void main(String[] args) {

        /* DB 접속을 위한 Connection instance 생성을 위해 레퍼런스 변수 선언 */
        Connection con = null;

        try {
            /* 사용할 Driver 등록 */
            Class.forName("com.mysql.cj.jdbc.Driver");

            /* DriverManager를 이용해 Connection 생성 */
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee", "sahmyook", "sahmyook");

            System.out.println("con : " + con);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
