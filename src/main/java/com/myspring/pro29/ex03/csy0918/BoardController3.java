package com.myspring.pro29.ex03.csy0918;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/boards3")
public class BoardController3 {
	static Logger logger = LoggerFactory.getLogger(BoardController3.class);
/* 클라이언트 주소 : /pro29/boards3/all */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	// ResponseEntity : 데이터만 전달하면 상태 확인도 O , 헤더에 특정 속성도 추가 가능
	public ResponseEntity<List<memberVO3>> listMembers() {
		// 로그 기록 기능을 더 잘 구현한 라이브러리 이용
		logger.info("listMembers 호출");
		
		List<memberVO3> list = new ArrayList<memberVO3>(); 
		// MemberVO3 타입으로만 박스에 담아서 전달
		
		for (int i = 0; i < 10; i++) {
			memberVO3 vo = new memberVO3();
			vo.setId("csy"+i);
			vo.setPwd(""+i);
			vo.setName(""+i);
			vo.setEmail(""+i);
			list.add(vo);
		}
		/* 서버 -> 클라이언트 : 박스 + 데이터 + 상태코드 전달 */
		return new ResponseEntity(list,HttpStatus.OK);
	}

/* 클라이언트 주소 : /pro29/boards3/{memberVO3} */
	@RequestMapping(value = "/{memberVO3}", method = RequestMethod.GET)
	public ResponseEntity<memberVO3> findArticle (@PathVariable("memberVO3") Integer memberVO3) { 
		// @PathVariable("memberVO3") Integer articleNO 클라이언트 주소 요청 시, 주소 뒤에 매개변수처럼 전달 
		logger.info("findMember 호출");
		memberVO3 vo = new memberVO3();
		vo.setId(memberVO3);
		vo.setPwd("1");
		vo.setName("ㅊ");
		vo.setEmail("s");
		
		return new ResponseEntity(vo,HttpStatus.OK);
	}	

	
/* POST-추가, PUT-업데이트, GET: 조회, PATCH: 부분 수정, DELETE: 삭제 */

/* REST 방식으로 , 멤버 메서드 명세표 연습
	1. 회원 추가. POST
	2. 회원 조회. GET
	3. 회원 수정. PUT
	4. 회원 삭제. DELETE */ 
	
	// 클라이언트 주소 : /pro29/boards33/ , POST
	@RequestMapping(value = "", method = RequestMethod.POST) 
	public ResponseEntity<String> addMember (@RequestBody memberVO3 memberVO3) { 
		// @RequestBody : 클라이언트 전달된 데이터를 서버에서 자동으로 모델 클래스 매핑
		ResponseEntity<String>  resEntity = null; 
		// 참조형 변수 타입으로 선언만
		try {
			logger.info("addMember 호출");
			logger.info(memberVO3.toString());
			logger.info(memberVO3.getName());
			// 서버 -> 클라이언트 : 메세지 + 상태 코드 전달
			resEntity =new ResponseEntity("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			// 오류 발생 시, 오류 메세지 + 상태 코드 전달
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	
	// PUT 수정 확인
	// 클라이언트 주소 : /pro29/boards33/777
	@RequestMapping(value = "/{memberNO}", method = RequestMethod.PUT)
	/* memberNO 입력받는 번호 자동 객체화 */
	public ResponseEntity<String> modMember (@PathVariable("memberNO") Integer memberNO, @RequestBody memberVO3 articleVO) {
		ResponseEntity<String>  resEntity = null;
		try {
			logger.info("modMember  확인");
			logger.info(memberNO.toString());
			resEntity =new ResponseEntity("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	
	// 클라이언트 주소 : /pro29/boards33/777
	@RequestMapping(value = "/{memberNO}", method = RequestMethod.DELETE) // DELETE 삭제 : 레스트 형식으로 CRUD 

	public ResponseEntity<String> removeMember (@PathVariable("memberNO") Integer memberNO) {
		// @PathVariable("memberNO") Integer memberNO : 주소의 매개변수 서버에서 가져오기
		// 클라이언트 주소 : /pro29/boards3/777 , PUT
		ResponseEntity<String>  resEntity = null;
		try {
			logger.info("removeArticle 호출");
			System.out.println("반드시 클라이언트로부터 넘어온 정보를 확인하는 습관");
			logger.info(memberNO.toString());
			resEntity =new ResponseEntity("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	

}
