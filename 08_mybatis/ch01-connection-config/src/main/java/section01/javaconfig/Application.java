package section01.javaconfig;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    // jdbc 드라이버 설정 (java와 db의 통신)
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/menudb";
    private static String user = "root";
    private static String password = "hosp0316!!";

    public static void main(String[] args) {
        Environment environment = new Environment(
                "dev",                                              // 환경에 부여되는 id
                new JdbcTransactionFactory(),                           // 트랜잭션 관리 방식 (자동 커밋 / 수동 커밋)
                new PooledDataSource(driver, url, user, password)       // 데이터베이스 연결 정보 (+Pool / Unpool)
        );

        /* 설명: Mybatis의 설정 객체
        *   Configuration은 Mybatis만을 위한 클래스임*/
        Configuration configuration=new Configuration(environment);
        /* 설명:
        *   ExampleMapper 인터페이스를 configuration에 등록
        *   ExampleMapper에 등록되어있는 SQL을 사용 가능하게 됨. */
        configuration.addMapper(ExampleMapper.class);                      // Mapper 인터페이스를 등록

        // Configuration <- environment <- (id, Factory, PooledDataSource)
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session=sqlSessionFactory.openSession(false);        // false는 수동 커밋을 의미

        ExampleMapper exampleMapper = session.getMapper(ExampleMapper.class);   // 세션에 ExampleMapper(와 그 안에 있는 쿼리) 등록
        java.util.Date date=exampleMapper.selectNow();
        System.out.println("date = " + date);
        session.close();
    }
}
