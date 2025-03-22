package section02.javaconfig;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MenuMapper {

    @Results(id = "menuResultMap", value = {
            @Result(id = true, property = "menuCode", column = "menu_code"),
            @Result(property = "menuName", column = "MENU_NAME"),
            @Result(property = "menuPrice", column = "MENU_PRICE"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "orderableStatus", column = "ORDERABLE_STATUS")
    })
    @Select("SELECT"
            + "        menu_code"
            + "      , menu_name"
            + "      , menu_price"
            + "      , category_code"
            + "      , orderable_status"
            + "   from tbl_menu")
    List<MenuDTO> selectAllMenus();

    @ResultMap("menuResultMap")
    @Select("SELECT"
            + "        menu_code"
            + "      , menu_name"
            + "      , menu_price"
            + "      , category_code"
            + "      , orderable_status"
            + "   from tbl_menu"
            + "  where menu_code=#{menuCode}")
    MenuDTO selectMenu(int menuCode);

    @Insert("""
            INSERT
                      INTO TBL_MENU
                    (
                      MENU_NAME
                    , MENU_PRICE
                    , CATEGORY_CODE
                    , ORDERABLE_STATUS
                    )
                    VALUES
                    (
                      #{menuName}
                    , #{menuPrice}
                    , #{categoryCode}
                    , 'Y'
                    )
            """)
    int insertMenu(MenuDTO menu);

    @Update("""
            UPDATE
                    tbl_menu
                set menu_name=#{menuName}
                  , menu_price=#{menuPrice}
              where menu_code=#{menuCode}
            """)
    int updateMenu(MenuDTO menu);

    @Delete("""
            DELETE
                    FROM tbl_menu
                   WHERE menu_code=#{menuCode}
            """)
    int deleteMenu(int menuCode);
}
