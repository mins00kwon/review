package section01.practice;

import java.util.Date;
import org.apache.ibatis.annotations.Select;

public interface PracticeMapper {
    @Select("SELECT NOW()")
    String now();
}
