package section01.xml;

import static section01.xml.Factory.getSqlSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuService {
    private static MenuMapper menuMapper;

    public void findMenuByPrice(int maxPrice) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> resultList = menuMapper.seletMenuByPrice(maxPrice);
        sqlSession.close();
        resultList.forEach(System.out::println);
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> resultList = menuMapper.searchMenu(searchCriteria);
        sqlSession.close();
        resultList.forEach(System.out::println);
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        System.out.println("searchMenuBySupCategory");
        List<MenuDTO> resultList = menuMapper.searchMenuBySupCategory(searchCriteria);
        sqlSession.close();
        if (resultList.size() > 0) {
            resultList.forEach(System.out::println);
        }else{
            System.out.println("0");
        }
    }

    public void searchMenuByRandomMenuCode(List<Integer> inputList) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        System.out.println("searchMenuByRandomMenuCode");
        List<MenuDTO> resultList=menuMapper.searchMenuByRandomMenuCode(inputList);
        sqlSession.close();
        resultList.forEach(System.out::println);

    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        System.out.println("searchMenuByCodeOrSearchAll");
        List<MenuDTO> resultList=menuMapper.searchMenu(searchCriteria);
    }
}
