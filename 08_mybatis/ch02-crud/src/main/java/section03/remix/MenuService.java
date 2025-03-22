package section03.remix;

import static section03.remix.Factory.getSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuService {
    private MenuMapper menuMapper;

    public List<MenuDTO> findAllMenus() {
        SqlSession sqlSession=getSession();
        menuMapper=sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> result=menuMapper.selectAllMenus();
        return result;
    }

    public MenuDTO findMenuByMenuCode(int menuCode) {
        SqlSession sqlSession=getSession();
        menuMapper=sqlSession.getMapper(MenuMapper.class);
        MenuDTO result = menuMapper.selectMenu(menuCode);
        return result;
    }

    public int registMenu(MenuDTO menu) {
        SqlSession sqlSession=getSession();
        menuMapper=sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menu);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public int modifyMenu(MenuDTO menu) {
        SqlSession sqlSession=getSession();
        menuMapper=sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menu);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public int removeMenu(int menuCode) {
        SqlSession sqlSession=getSession();
        menuMapper=sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenu(menuCode);
        sqlSession.commit();
        sqlSession.close();

        return result;
    }
}
