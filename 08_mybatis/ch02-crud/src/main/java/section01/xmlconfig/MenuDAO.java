package section01.xmlconfig;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuDAO {
    public List<MenuDTO> selectAllMenus(SqlSession sqlSession) {
        return sqlSession.selectList("menuMapper.selectAllMenus");
    }
}
