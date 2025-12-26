package myboard.client;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myboard.VO.BoardVO;
import myboard.util.myBatisUtil;

public class BoardTest {
	public static void main(String[] args) {
		
//		try (SqlSession session = myBatisUtil.getSqlSession()){
//			BoardVO vo = new BoardVO();
//			vo.setBrdTitle("마이바티스 테스트");
//			vo.setBrdWriter("작성자A");
//			vo.setBrdContent("게시글 내용");
//			
//			int cnt = session.insert("board.brdWrite", vo);
//			
//			if (cnt > 0){
//				System.out.println("게시글 등록 완료");
//			} else {
//				System.out.println("게시글 등록 실패");
//			}
//			
//			session.commit();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//			
		try (SqlSession session = myBatisUtil.getSqlSession()){
			List<BoardVO> boardList = session.selectList("board.displayAll");
            
            System.out.println("--------------------------------------------------");
            System.out.println("번호 \t 제목 \t 작성자 \t 날짜");
            System.out.println("--------------------------------------------------");
            
            if(boardList == null || boardList.isEmpty()) {
                System.out.println("게시글이 하나도 없습니다.");
            } else {
                for(BoardVO vo2 : boardList) {
                    System.out.print(vo2.getBrdNo() + "\t");
                    System.out.print(vo2.getBrdTitle() + "\t");
                    System.out.print(vo2.getBrdWriter() + "\t");
                    System.out.print(vo2.getBrdContent() + "\t");
                    System.out.println(vo2.getBrdDate());
                }
            }
		}catch(Exception e) {
			e.printStackTrace();
		}

	}	
}
