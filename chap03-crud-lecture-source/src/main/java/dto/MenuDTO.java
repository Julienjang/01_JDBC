package dto;


/* DTO(Data Transfer Object)
 * : 여러 계층간 데이터 전송을 위해 다양한 타입의 데이터를 하나로 묶어 전송할 용도의 클래스
 *   유사한 말로 VO, Bean, Entity, (DO, Domain, Row) 등이 있음
 * */

/* DTO 클래스의 조건
 * 1. 모든 필드는 private
 * 2. 기본생성자와 모든 필드를 초기화하는 생성자
 * 3. 모든 필드에 대한 setter/getter
 * 4. toString Overriding을 이용한 필드 값 반환용 메소드
 * 5. 직렬화 처리
 * */

import java.sql.Date;

public class MenuDTO implements java.io.Serializable {
    private int code;
    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;

    public MenuDTO(){

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    public MenuDTO(int code, String name, int price, int categoryCode, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }
}
