package model;

/**
 * Created by yurik on 16.11.16.
 */
public class ListTasks {

    private int id;
    private String listName;

    public ListTasks(int id, String listName) {
        this.id = id;
        this.listName = listName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
