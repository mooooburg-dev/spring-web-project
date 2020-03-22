package org.zrock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:49161:XE",
				"book_ex",
				"book_ex"
				)){
			log.info(con);	
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}


