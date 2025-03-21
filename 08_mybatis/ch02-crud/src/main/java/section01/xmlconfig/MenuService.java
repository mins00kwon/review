package section01.xmlconfig;

import static section01.xmlconfig.Factory.getSqlSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuService {
    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO=new MenuDAO();
    }

    public List<MenuDTO> findAllMenus() {
        System.out.println("start::MenuService.findAllMenus");
        SqlSession sqlSession=getSqlSession();
        List<MenuDTO> resultMenuList = menuDAO.selectAllMenus(sqlSession);
        return resultMenuList;
    }
}
