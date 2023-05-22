package section01.statement;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application3 {

    public static void main(String[] args) {

        /* 1. Connection 생성 */
        Connection con = getConnection();

        /* 2. Statement 생성 */
        Statement stmt = null;

        /* 3. ResultSet 생성 */
        ResultSet rset = null;

        try {
            /* 4. Connection의 createStatement()를 이용한 Statement 인스턴스 생성 */
            stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.print("조회하려는 사번을 입력해주세요 : ");
            String empId = sc.nextLine();
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";

            System.out.println(query);

            /* 5. executeQuery()로 쿼리문 실행하고 결과를 ResultSet으로 반환받음  */
            rset = stmt.executeQuery(query);

            /* 6. ResultSet에 담긴 결과물을 컬럼 이름을 이용해 꺼내오기 */
            if(rset.next()) {
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /* 7. 사용한 자원 반납 */
            close(rset);
            close(stmt);
            close(con);
        }
    }

}
