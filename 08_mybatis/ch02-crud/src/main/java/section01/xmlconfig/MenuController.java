package section01.xmlconfig;

import java.util.List;

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
}
