package section03.remix;

import java.util.List;
import java.util.Map;

public class MenuController {
    private final MenuService menuService;

    public MenuController() {
        menuService = new MenuService();
    }

    public void findAllMenus() {
        List<MenuDTO> result=menuService.findAllMenus();
        result.forEach(System.out::println);
    }

    public void findMenuByMenuCode(Map<String, String> stringStringMap) {
        int menuCode=Integer.parseInt(stringStringMap.get("menuCode"));
        MenuDTO result=menuService.findMenuByMenuCode(menuCode);
        System.out.println(result);
    }

    public void registMenu(Map<String, String> stringStringMap) {
        String menuName = stringStringMap.get("menuName");
        int menuPrice = Integer.valueOf(stringStringMap.get("menuPrice"));
        int categoryCode = Integer.valueOf(stringStringMap.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        int result = menuService.registMenu(menu);
        System.out.println(result==1?"success":"fail");
    }

    public void modifyMenu(Map<String, String> parameter) {
        int menuCode = Integer.valueOf(parameter.get("menuCode"));
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(menuCode);
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);

        int result = menuService.modifyMenu(menu);
        System.out.println(result==1?"success":"fail");
    }

    public void removeMenu(Map<String, String> stringStringMap) {
        int menuCode = Integer.parseInt(stringStringMap.get("menuCode"));
        int result = menuService.removeMenu(menuCode);
        System.out.println(result==1?"success":"fail");
    }
}
