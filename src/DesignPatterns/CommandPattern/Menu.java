package DesignPatterns.CommandPattern;

import java.util.ArrayList;

/**
 * 菜单类
 */
public class Menu {

    private ArrayList<MenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public MenuItem getMenuItem(int i) {
        if (menuItems.get(i) != null)
            return menuItems.get(i);
        else {
            System.out.println("menu item does not exist");
            return null;
        }
    }

    public void removeMenuItem(int i) {
        menuItems.remove(i);
    }
}
