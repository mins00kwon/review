package mk.review.ch01mybatisspring.section01.factorybean;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    private final SqlSessionTemplate sqlSession;

    @Autowired
    public MenuService(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<MenuDTO> findAllMenuByOrderableStatus(String orderableStatus) {
        return sqlSession.getMapper(MenuMapper.class).selectAllMenuByOrderableStatus(orderableStatus);
    }
}
