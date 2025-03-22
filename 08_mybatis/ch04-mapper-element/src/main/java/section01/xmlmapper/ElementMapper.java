package section01.xmlmapper;

import java.util.List;

public interface ElementMapper {

    List<MenuDTO> selectResultMapTest();

    List<MenuDTO> selectResultMapAssociationTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();

    List<MenuAndCategoryDTO> selectMenuWithCategory();
}
