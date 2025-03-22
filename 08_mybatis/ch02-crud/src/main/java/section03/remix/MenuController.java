package section03.remix;

import java.util.List;
import java.util.Map;

public class MenuController {
    private final MenuService menuService;

    public MenuController() {
        menuService = new MenuService();
    }

    public void findAllMenus() {
        System.out.println("start::menuService.findAllMenus()");
        List<MenuDTO> menuList = menuService.findAllMenus();
        if (menuList.isEmpty()) {
            System.out.println("No menus found");
        }else {
            System.out.println("Found " + menuList.size() + " menus");
            menuList.forEach(System.out::println);
        }
    }

    public void findMenuByMenuCode(Map<String, String> stringStringMap) {
        System.out.println("start::menuService.findMenuByMenuCode(stringStringMap)");
        int menuCode = Integer.parseInt(stringStringMap.get("menuCode"));
        MenuDTO menu = menuService.findByMenuCode(menuCode);
        System.out.println("menu = " + menu);
    }

    public void registMenu(Map<String, String> stringStringMap) {
        System.out.println("start::menuService.registMenu(stringStringMap)");
        String menuName = stringStringMap.get("menuName");
        int menuPrice = Integer.parseInt(stringStringMap.get("menuPrice"));
        int categoryCode = Integer.parseInt(stringStringMap.get("categoryCode"));
        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);
        int result = menuService.registMenu(menu);
    }

    public void modifyMenu(Map<String, String> stringStringMap) {
        System.out.println("start::menuService.modifyMenu(stringStringMap)");
        int menuCode = Integer.parseInt(stringStringMap.get("menuCode"));
        String menuName = stringStringMap.get("menuName");
        int menuPrice = Integer.parseInt(stringStringMap.get("menuPrice"));
        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setMenuCode(menuCode);
        int result = menuService.modifyMenu(menu);
    }

    public void removeMenu(Map<String, String> stringStringMap) {
        System.out.println("start::menuService.removeMenu(stringStringMap)");
        int menuCode = Integer.parseInt(stringStringMap.get("menuCode"));
        int result = menuService.removeMenu(menuCode);
        System.out.println(result==1?"success":"fail");
    }
}
