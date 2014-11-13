/* 페이징 처리
 * => DBMS마다 처리하는 방법이 다르다.    
 */
package java02.test19.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java02.test19.server.util.DBConnectionPool;

public class ProductDao {
  SqlSessionFactory sqlSessionFactory;
  DBConnectionPool dbConnectionPool;
  
  public void setDbConnectionPool(DBConnectionPool dbConnectionPool) {
    this.dbConnectionPool = dbConnectionPool;
  }
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }


  public ProductDao() {}

  public Product selectOne(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();   

    try {
      return sqlSession.selectOne(
              "java02.test19.server.ProductDao.selectList",no);

    } finally {
      sqlSession.close();
    }   
    
      
  }
  
  public void update(Product product) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement(
          "UPDATE PRODUCTS SET PNAME=?,QTY=?,MKNO=? WHERE PNO=?");
      stmt.setString(1, product.getName());
      stmt.setInt(2, product.getQuantity());
      stmt.setInt(3, product.getMakerNo());
      stmt.setInt(4, product.getNo());

      stmt.executeUpdate();
      
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {stmt.close();} catch (Exception ex) {}
      dbConnectionPool.returnConnection(con);
    }
  }
  
  public void delete(int no) {
    Connection con = null;
    Statement stmt = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.createStatement();
      stmt.executeUpdate("DELETE FROM PRODUCTS"
          + " WHERE PNO=" + no);
      
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {stmt.close();} catch (Exception ex) {}
      dbConnectionPool.returnConnection(con);
    }
  }
  
  public List<Product> selectList(int pageNo, int pageSize) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);

    try {
      return sqlSession
          .selectList(
              "java02.test19.server.ProductDao.selectList",
              paramMap);

    } finally {
      sqlSession.close();
    }
  }

  public void insert(Product product) {
    Connection con = null;
    PreparedStatement stmt = null;
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement(
          "INSERT INTO PRODUCTS(PNAME,QTY,MKNO) VALUES(?,?,?)");
      stmt.setString(1, product.getName());
      stmt.setInt(2, product.getQuantity());
      stmt.setInt(3, product.getMakerNo());
      stmt.executeUpdate();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    } finally {
      try {stmt.close();} catch (Exception ex) {}
      dbConnectionPool.returnConnection(con);
    }
  }
}