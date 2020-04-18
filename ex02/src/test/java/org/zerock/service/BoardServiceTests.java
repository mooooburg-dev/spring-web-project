package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@ContextConfiguration(classes = {org.zerock.config.RootConfig.class})
@Log4j
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
//	@Test
	public void testExist() {
		log.info(service);
		
		assertNotNull(service);
	}
	
//	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("service 새로 작성하는 글");
		board.setContent("service 새로 작성하는 내용");
		board.setWriter("service newbie");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBno());
	}
	
	@Test
	public void testGetList() {
//		log.info(service.getList());
//		service.getList().forEach(board -> log.info(board));
		
		service.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
	}
	
//	@Test
	public void testGet() {
		log.info(service.get(21L));
	}
	
//	@Test
	public void testDelete() {
		log.info("REMOVE RESULT : " + service.remove(9L));
	}
	
//	@Test
	public void testUpadte() {
		
		BoardVO board = service.get(21L);
		
		if( board == null ) {
			return;	
		}
		
		board.setTitle("service 제목 수정합니다");
		log.info("MODIFY RESULT : " + service.modify(board));
	}
}
