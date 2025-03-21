package section01.xmlconfig;

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
        MenuDTO resultMenu=menuService.findMenuByMenuCode(menuCode);
        if (resultMenu == null) {
            System.out.println("No menu found");
        }
        else {
            System.out.println("Found " + resultMenu);
        }
    }

    public void registMenu(Map<String, String> stringStringMap) {
        System.out.println("start::menuService.registMenu(stringStringMap)");
        String menuName = stringStringMap.get("menuName");
        int menuPrice= Integer.parseInt(stringStringMap.get("menuPrice"));
        int categoryCode=Integer.parseInt(stringStringMap.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        int result = menuService.registMenu(menu);
        System.out.println(result==1?"Insert success":"Insert failed");
    }

    public void modifyMenu(Map<String, String> stringStringMap) {
        System.out.println("start::menuService.modifyMenu(stringStringMap)");
        int menuCode= Integer.parseInt(stringStringMap.get("menuCode"));
        String menuName = stringStringMap.get("menuName");
        int menuPrice= Integer.parseInt(stringStringMap.get("menuPrice"));
        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setMenuCode(menuCode);
        int result=menuService.modifyMenu(menu);
        System.out.println(result==1?"Update success":"Update failed");
    }

    public void removeMenu(Map<String, String> stringStringMap) {
        System.out.println("start::menuService.removeMenu(stringStringMap)");
        int menuCode= Integer.parseInt(stringStringMap.get("menuCode"));
        int result = menuService.removeMenuByMenuCode(menuCode);
        System.out.println(result==1?"Remove success":"Remove failed");
    }
}
