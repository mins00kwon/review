package section01.practice;

import java.util.Date;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/menudb";
    private static String user = "root";
    private static String pwd = "hosp0316!!";

    public static void main(String[] args) {
        Environment environment=new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, url, user, pwd)
        );
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(PracticeMapper.class);
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession=sessionFactory.openSession();

        PracticeMapper practiceMapper=sqlSession.getMapper(PracticeMapper.class);
        String result=practiceMapper.now();
        System.out.println("result = " + result);
        sqlSession.close();
    }
}