package section02.xmlconfig;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Application {
    public static void main(String[] args) {
        String resourcePath = "example-mybatis-config.xml";
        SqlSession sqlSession=null;
        try{
            InputStream inputStream = Resources.getResourceAsStream(resourcePath);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession=sqlSessionFactory.openSession(false);
            String result=sqlSession.selectOne("mapper.exampleSelectNow");
            System.out.println("result = " + result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
