package section01.javaconfig;

import java.util.Date;
import org.apache.ibatis.annotations.Select;

public interface ExampleMapper {
    @Select("SELECT NOW()")
    Date selectNow();
}
