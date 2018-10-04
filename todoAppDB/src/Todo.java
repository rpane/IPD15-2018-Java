
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 0639300
 */
public class Todo {

    long id;
    String task;
    Date dueDate;
    boolean isDone;

    public Todo(long id, String task, Date dueDate, boolean isDone) {
        this.id = id;
        this.task = task;
        this.dueDate = dueDate;
        this.isDone = isDone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    //Todo Generate Setters and Getters
    @Override
    public String toString() {
        return id + "," + task + "," + dueDate + "," + isDone;
    }

}
