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

    public MenuDTO findMenuByMenuCode(int menuCode) {
        System.out.println("start::MenuService.findMenuByMenuCode");
        SqlSession sqlSession=getSqlSession();
        MenuDTO resultMenu = menuDAO.selecMenuByMenuCode(sqlSession, menuCode);
        return resultMenu;
    }

    public int registMenu(MenuDTO menu) {
        System.out.println("start::MenuService.registMenu");
        SqlSession sqlSession=getSqlSession();
        int result = menuDAO.insertMenu(sqlSession, menu);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public int modifyMenu(MenuDTO menu) {
        System.out.println("start::MenuService.modifyMenu");
        SqlSession sqlSession=getSqlSession();
        int result = menuDAO.updateMenu(sqlSession, menu);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public int removeMenuByMenuCode(int menuCode) {
        System.out.println("start::MenuService.removeMenuByMenuCode");
        SqlSession sqlSession=getSqlSession();
        int result = menuDAO.deleteMenu(sqlSession, menuCode);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }
}
