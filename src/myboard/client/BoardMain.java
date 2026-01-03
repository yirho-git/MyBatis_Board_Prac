package myboard.client;

import java.util.List;
import java.util.Scanner;

import myboard.VO.BoardVO;
import myboard.service.BoardServiceImpl;
import myboard.service.IBoardService;

public class BoardMain {
	public static void main(String[] args) {
		IBoardService service = BoardServiceImpl.getInstance();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴");
		System.out.println("1. 모든 게시글 보기\n2. 글쓰기\n3. 게시글 검색\n4. 게시글 편집\n5. 게시글 삭제\n0. 종료");
		int menu = sc.nextInt();
		switch (menu) {
		case 0:
			System.exit(0);
			
		case 1:
			List<BoardVO> blist = service.showAll();
			for(BoardVO b : blist) {
				System.out.println(b.toString());
			}
			break;
		
		case 2:
			sc.nextLine();
			BoardVO vo = new BoardVO();
			System.out.println("제목 입력 : ");
			break;
			
		}
	}
}
