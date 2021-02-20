package jdbc;
import java.sql.*;
import java.util.Vector;

import javax.sql.*;
import javax.naming.*;
/**
 *ConnectionPool을 사용하여 데이터베이스와 연동하는 예제입니다.(수정: 주석처리했음)
 * @author master
 *
 */
public class tempMemberDAO {
   //private ConnectionPool pool = null;
   
   public tempMemberDAO() {//생성자
      /*
      try {
         pool = ConnectionPool.getInstance();
      }catch(Exception e) {
         System.out.println("Error: 커넥션 얻어오기 실패!");
      }
      */
   }
   //메서드 - 데이터베이스 연동을 수행하는 메서드 작성 : 웹에서 필요한 기능 하나 하나를 메서드로 구현
   private Connection getConnection() {
      Connection conn = null;
      try {
         Context init = new InitialContext();
         DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/myOracle");
         conn = ds.getConnection();
      }catch(NamingException e) {
         e.printStackTrace();
      }catch(SQLException e) {
         e.printStackTrace();
      }
      return conn;
   }

   public Vector<tempMemberVO> getMemberList(){
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      Vector<tempMemberVO> vecList =
            new Vector<>();
      try {
         conn = getConnection();
               //pool.getConnection();
         String strQuery = "select * from tempMember";
         stmt = conn.createStatement();
         rs = stmt.executeQuery(strQuery);
         while(rs.next()) {
            tempMemberVO vo = new tempMemberVO();
            vo.setId(rs.getString("id"));
            vo.setPasswd(rs.getString("passwd"));
            vo.setName(rs.getString("name"));
            vo.setMem_num1(rs.getString("mem_num1"));
            vo.setMem_num2(rs.getString("mem_num2"));
            vo.setEmail(rs.getString("e_mail"));
            vo.setPhone(rs.getString("phone"));
            vo.setZipcode(rs.getString("zipcode"));
            vo.setAddress(rs.getString("address"));
            vo.setJob(rs.getString("job"));
            vecList.add(vo);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         if(rs!=null) try {rs.close();} catch(SQLException e) {};
         if(stmt!=null) try {stmt.close();} catch(SQLException e) {};
         if(conn!=null) try {conn.close(); //pool.releaseConnection(conn);
                                 } catch(SQLException e) {};
      }
      return vecList;
   }

}