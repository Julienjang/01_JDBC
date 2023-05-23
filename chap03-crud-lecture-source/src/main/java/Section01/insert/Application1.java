package Section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con= getConnection();

        PreparedStatement pstmt= null;
        int result=0;

        Properties prop =new Properties();
        try {
            prop.loadFromXML(new FileInputStream("chap03-crud-lecture-source/src/main/java/mapper/menu-query.xml"));
            String query = prop.getProperty("insertMenu");
            System.out.println(query);

            pstmt= con.prepareStatement(query);

            pstmt.setString(1,"뚝배기불고기");
            pstmt.setInt(2,50000);
            pstmt.setInt(3,4);
            pstmt.setString(4,"y");

            result= pstmt.executeUpdate();

        } catch (IOException e) {
           e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
        }
        System.out.println(result);
    }
}
