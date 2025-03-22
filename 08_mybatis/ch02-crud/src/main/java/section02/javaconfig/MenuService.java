package section02.javaconfig;


import static section02.javaconfig.Factory.getSqlSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuService {
    private MenuMapper menuMapper;

    public List<MenuDTO> findAllMenus() {
        System.out.println("start::MenuService.findAllMenus");
        SqlSession sqlSession=getSqlSession();
        menuMapper=sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> resultMenuList=menuMapper.selectAllMenus();
        sqlSession.close();
        return resultMenuList;
    }

    public MenuDTO findByMenuCode(int menuCode) {
        SqlSession sqlSession=getSqlSession();
        menuMapper=sqlSession.getMapper(MenuMapper.class);
        MenuDTO resultMenu = menuMapper.selectMenu(menuCode);
        sqlSession.close();
        return resultMenu;
    }

    public int registMenu(MenuDTO menu) {
        SqlSession sqlSession=getSqlSession();
        menuMapper=sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menu);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public int modifyMenu(MenuDTO menu) {
        SqlSession sqlSession=getSqlSession();
        menuMapper=sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menu);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public int removeMenu(int menuCode) {
        SqlSession sqlSession=getSqlSession();
        menuMapper=sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenu(menuCode);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }
}
