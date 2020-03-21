package org.zrock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.concurrent.ExecutionException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// Java 설정을 사용하는 경우
//@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class DataSourceTest {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMyBatis() {
		try(
			SqlSession session = sqlSessionFactory.openSession();
			Connection con = session.getConnection();
		){
			
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	
//	@Test
//	public void testConnection() {
//		try (Connection con = dataSource.getConnection()){
//			log.info(con);
//		} catch(Exception e) {
//			fail(e.getMessage());;
//		}
//	}
	
	
	
}
