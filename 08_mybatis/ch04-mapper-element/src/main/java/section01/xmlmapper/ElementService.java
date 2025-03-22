package section01.xmlmapper;

import static section01.xmlmapper.Factory.getSqlSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class ElementService {
    private ElementMapper elementMapper;
    public void selectResultMapTest() {
        SqlSession sqlSession=getSqlSession();
        elementMapper=sqlSession.getMapper(ElementMapper.class);
        List<MenuDTO> menus=elementMapper.selectResultMapTest();
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession=getSqlSession();
        elementMapper=sqlSession.getMapper(ElementMapper.class);
        List<MenuDTO> menus=elementMapper.selectResultMapAssociationTest();
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {
        SqlSession sqlSession=getSqlSession();
        elementMapper=sqlSession.getMapper(ElementMapper.class);
        List<CategoryAndMenuDTO> categoryAndMenus=elementMapper.selectResultMapCollectionTest();
        categoryAndMenus.forEach(System.out::println);
        sqlSession.close();
    }

    public void selectMenuCategoryTest() {
        SqlSession sqlSession=getSqlSession();
        elementMapper=sqlSession.getMapper(ElementMapper.class);
        List<MenuAndCategoryDTO> menusAndCategory=elementMapper.selectMenuWithCategory();
        menusAndCategory.forEach(System.out::println);
        sqlSession.close();
    }
}
