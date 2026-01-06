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
		BoardVO vo = new BoardVO();
		List<BoardVO> blist;
		int cnt;

		while (true) {
			System.out.println("메뉴");
			System.out.println("1. 모든 게시글 보기\n2. 글쓰기\n3. 게시글 검색\n4. 게시글 편집\n5. 게시글 삭제\n0. 종료");
			int menu = sc.nextInt();
			switch (menu) {
			case 0:
				System.exit(0);

			case 1:
				blist = service.showAll();
				for (BoardVO b : blist) {
					System.out.println(b.toString());
				}
				break;

			case 2:
				sc.nextLine();
				System.out.println("제목 입력 : ");
				vo.setBrdTitle(sc.nextLine());

				System.out.println("작성자 입력 : ");
				vo.setBrdWriter(sc.nextLine());

				System.out.println("내용 입력 : ");
				vo.setBrdContent(sc.nextLine());

				cnt = service.write(vo);
				if (cnt > 0)
					System.out.println("게시글 등록 성공");
				else
					System.out.println("실패");
				break;

			case 3:
				vo = new BoardVO();
				sc.nextLine();
				System.out.println("글 번호 입력 : ");
				String num = sc.nextLine().trim();
				if (!(num.isEmpty()))
					vo.setBrdNo(Integer.parseInt(num));

				System.out.println("제목 입력 : ");
				String title = sc.nextLine().trim();
				if (!title.isEmpty()) {
					vo.setBrdTitle(title);
				}

				System.out.println("작성자 입력 : ");
				String writer = sc.nextLine().trim();
				if (!writer.isEmpty()) {
					vo.setBrdWriter(writer);
				}

				System.out.println("내용 입력 : ");
				vo.setBrdContent(sc.nextLine().trim());

				blist = service.search(vo);

				if (blist == null || blist.isEmpty()) {
					System.out.println("검색 결과가 없습니다.");
				} else {
					for (BoardVO b : blist) {
						System.out.println(b.toString());
					}
				}
				break;

			case 4:
				vo = new BoardVO();
				sc.nextLine();
				System.out.println("수정할 글 번호 입력 : ");
				num = sc.nextLine().trim();
				if (!(num.isEmpty()))
					vo.setBrdNo(Integer.parseInt(num));
				else
					break;

				System.out.println("제목 입력 : ");
				title = sc.nextLine().trim();
				if (!title.isEmpty()) {
					vo.setBrdTitle(title);
				}

				System.out.println("작성자 입력 : ");
				writer = sc.nextLine().trim();
				if (!writer.isEmpty()) {
					vo.setBrdWriter(writer);
				}

				System.out.println("내용 입력 : ");
				vo.setBrdContent(sc.nextLine().trim());

				cnt = service.edit(vo);
				if (cnt > 0)
					System.out.println("게시글 편집 성공");
				else
					System.out.println("실패");
				break;

			case 5:
				vo = new BoardVO();
				sc.nextLine();
				System.out.println("삭제할 글 번호 입력 : ");
				num = sc.nextLine().trim();
				if (!(num.isEmpty()))
					vo.setBrdNo(Integer.parseInt(num));
				else
					break;

				cnt = service.erase(vo.getBrdNo());
				if (cnt > 0)
					System.out.println("게시글 삭제 성공");
				else
					System.out.println("실패");
				break;
			}
		}
	}
}
