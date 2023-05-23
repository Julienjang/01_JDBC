package section02.preparedstatement;

import model.dto.EmployeeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application5{

    public static void main(String[] args) {
        /* 1. Connection 생성 */
        Connection con = getConnection();

        /* 2. PreparedStatement, ResultSet 생성 */
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        EmployeeDTO eto = null;
        List<EmployeeDTO> empList = null;
        /* 3. Scanner를 활용하여 조회할 사번 입력받기 */
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 성을 입력해 주세요 : ");
        String empFamilyName = sc.nextLine();
        /* 4. 조회를 위한 쿼리 작성 (placeholder 사용) */
        String query = "SELECT E.* FROM EMPLOYEE E WHERE E.EMP_NAME LIKE CONCAT( ?, '%')";
        /* 6. prepareStatement 생성 및 쿼리 준비 */
        try {
            pstmt = con.prepareStatement(query);
            /* 7. 조건에 해당하는 성씨 세팅 */
            pstmt.setString(1, empFamilyName);
            rset = pstmt.executeQuery();
            /* 8. ResultSet에 존재하는 모든 결과값을 객체에 담아 배열에 추가 */
            empList = new ArrayList<>();
            while (rset.next()){
                eto = new EmployeeDTO();
                eto.setEmpId(rset.getString("EMP_ID"));
                eto.setEmpName(rset.getString("EMP_NAME"));
                eto.setEmpNo(rset.getString("EMP_NO"));
                eto.setEmail(rset.getString("EMAIL"));
                eto.setPhone(rset.getString("PHONE"));
                eto.setDeptCode(rset.getString("DEPT_CODE"));
                eto.setJobCode(rset.getString("JOB_CODE"));
                eto.setSalLevel(rset.getString("SAL_LEVEL"));
                eto.setSalary(rset.getInt("SALARY"));
                eto.setBonus(rset.getDouble("BONUS"));
                eto.setManagerId(rset.getString("MANAGER_ID"));
                eto.setHireDate(rset.getDate("HIRE_DATE"));
                eto.setEntDate(rset.getDate("ENT_DATE"));
                eto.setEntYn(rset.getString("ENT_YN"));
                empList.add(eto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /* 9. 자원 반납 */
            close(con);
            close(pstmt);
            close(rset);
        }
        /* 10. 조회한 직원 정보 오버라이딩된 toString으로 출력  */
        for(EmployeeDTO e : empList)
            System.out.println(empList);
    }

}