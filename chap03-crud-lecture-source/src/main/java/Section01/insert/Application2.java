package Section01.insert;

import dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        Connection con= getConnection();

        PreparedStatement pstmt= null;
        int result=0;

        Properties prop =new Properties();
        try {
            prop.loadFromXML(new FileInputStream("chap03-crud-lecture-source/src/main/java/mapper/menu-query.xml"));
            String query = prop.getProperty("insertMenu");
            System.out.println(query);

            Scanner sc= new Scanner(System.in);
            System.out.println("메뉴의 이름을 입력하세요 :");
            String menuName =sc.nextLine();
            System.out.println("메뉴의 가격을 입력하세요 :");
            int price= sc.nextInt();
            System.out.println("메뉴의 코드를 입력하세요 :");
            int categoryCode= sc.nextInt();
            System.out.println("판매 여부를 결정하세요(Y/N) :");
            sc.nextLine();
            String orderableStatus= sc.nextLine().toUpperCase();

            MenuDTO menu = new MenuDTO(0, menuName, price, categoryCode, orderableStatus);

            pstmt = con.prepareStatement(query);

            pstmt.setString(1, menu.getName());
            pstmt.setInt(2, menu.getPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderableStatus());

            result = pstmt.executeUpdate();



        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }
        if(result>0){
            System.out.println("메뉴 등록 성공!!");
        }else{
            System.out.println("메뉴 등록 실패 ㅠㅠ");
        }

    }
}
