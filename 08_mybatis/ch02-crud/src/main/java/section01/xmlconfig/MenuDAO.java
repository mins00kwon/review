package section01.xmlconfig;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuDAO {
    public List<MenuDTO> selectAllMenus(SqlSession sqlSession) {
        return sqlSession.selectList("menuMapper.selectAllMenus");
    }

    public MenuDTO selecMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        return sqlSession.selectOne("menuMapper.selectMenuByMenuCode", menuCode);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("menuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("menuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("menuMapper.deleteMenu", menuCode);
    }
}
