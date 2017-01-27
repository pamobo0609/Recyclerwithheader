package model;

/**
 * Created by pamobo0609 on 1/26/17.
 */

public class Item {

    private String id;
    private String name;
    private int userImage;

    public Item() {
    }

    public Item(String id, String name, int userImage) {
        this.id = id;
        this.name = name;
        this.userImage = userImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }
}
