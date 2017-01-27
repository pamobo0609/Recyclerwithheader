package manager;

import java.util.ArrayList;

import model.Item;

/**
 * Created by pamobo0609 on 1/26/17.
 */

public class ContentManager {

    private static ContentManager instance;

    private ArrayList<String> mItems;

    private ContentManager() {
        mItems = new ArrayList<>();
        mItems.add("asdf");
        mItems.add("asdf");
        mItems.add("asdf");
        mItems.add("asdf");
        mItems.add("asdf");
        mItems.add("asdf");
        /*mItems.add(new Item("1", "John Doe 1", 0));
        mItems.add(new Item("2", "John Doe 2", 0));
        mItems.add(new Item("3", "John Doe 3", 0));
        mItems.add(new Item("4", "John Doe 4", 0));
        mItems.add(new Item("5", "John Doe 5", 0));
        mItems.add(new Item("6", "John Doe 6", 0));
        mItems.add(new Item("7", "John Doe 7", 0));
        mItems.add(new Item("8", "John Doe 8", 0));
        mItems.add(new Item("9", "John Doe 9", 0));
        mItems.add(new Item("10", "John Doe 10", 0));*/
    }

    public static ContentManager getInstance() {
        if (null == instance) {
            instance = new ContentManager();
        }
        return instance;
    }

    public ArrayList<String> getItems() {
        return mItems;
    }
}
