package model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by yurik on 16.11.16.
 */
@Entity
@Table(name = "list_tasks")
public class ListTasks {

    @Id
    private int id;
    private String listName;
    private List<Task> tasks;

    public ListTasks(int id, String listName) {
        this.id = id;
        this.listName = listName;
    }

    public ListTasks() {
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listTasks")
    @JoinColumn(name = "listId", referencedColumnName = "id")
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
