package jdbc;
import java.sql.*;
import java.util.Vector;

import javax.sql.*;
import javax.naming.*;
/**
 *ConnectionPool�� ����Ͽ� �����ͺ��̽��� �����ϴ� �����Դϴ�.(����: �ּ�ó������)
 * @author master
 *
 */
public class tempMemberDAO {
   //private ConnectionPool pool = null;
   
   public tempMemberDAO() {//������
      /*
      try {
         pool = ConnectionPool.getInstance();
      }catch(Exception e) {
         System.out.println("Error: Ŀ�ؼ� ������ ����!");
      }
      */
   }
   //�޼��� - �����ͺ��̽� ������ �����ϴ� �޼��� �ۼ� : ������ �ʿ��� ��� �ϳ� �ϳ��� �޼���� ����
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