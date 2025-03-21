package section01.xmlconfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        MenuController menuController=new MenuController();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do{
            // region 메뉴 출력
            System.out.println("====== 메뉴 관리 ======");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 관리 번호를 입력하세요: ");       
            // endregion
            int no= Integer.parseInt(br.readLine());
            // region 메뉴 선택
            switch (no) {
                case 1:
                    menuController.findAllMenus();
                    break;
                case 2:
//                    menuController.findMenuByMenuCode(inputMenuCode());
                    break;
                case 3:
//                    menuController.registMenu(inputMenu());
                    break;
                case 4:
//                    menuController.modifyMenu(inputModifyMenu());
                    break;
                case 5:
//                    menuController.removeMenu(inputMenuCode());
                    break;
                case 9:
                    System.out.println("프로그램을 종료하겠습니다.");
                    return;
                default:
                    System.out.println("번호를 잘 확인하고 입력해 주세요");
            }
            // endregion

        }while(true);
    }
}
