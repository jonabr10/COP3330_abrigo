import java.util.*;
import java.io.*;

public class TaskList {
    ArrayList<TaskItem> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(TaskItem data) {
        tasks.add(data);
    }

    public void removeTask(int index) {
        try {
            tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editTask(int index, String newTitle, String newDesc, String newDate) {
        try {
            TaskItem temp = tasks.get(index);

            //System.out.print("Enter a new title for task " + index + ": ");
            temp.setTitle(newTitle);

            //System.out.println("Enter a new description for task " + index + ": ");
            temp.setDescription(newDesc);

            //System.out.println("Enter a new task due date (MM/DD/YYYY) for task " + index + ": ");
            temp.setDate(newDate);

            tasks.set(index, temp);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editTaskCompletionStatusToDone(int index) {
        try {
            TaskItem temp = tasks.get(index);
            temp.setCompletionStatusToDone();
            tasks.set(index, temp);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editTaskCompletionStatusToNotDone(int index) {
        try {
            TaskItem temp = tasks.get(index);
            temp.setCompletionStatusToNotDone();
            tasks.set(index, temp);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editTaskTitle(int index, String newTitle) {
        try {
            TaskItem temp = tasks.get(index);
            temp.setTitle(newTitle);
            tasks.set(index, temp);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editTaskDescription(int index, String newDesc) {
        try {
            TaskItem temp = tasks.get(index);
            temp.setDescription(newDesc);
            tasks.set(index, temp);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editTaskDate(int index, String newDate) {
        try {
            TaskItem temp = tasks.get(index);
            temp.setDate(newDate);
            tasks.set(index, temp);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return tasks.size();
    }
    public boolean getItemCompletionStatus(int index) {
        if (isItemValid(index)) {
            TaskItem temp = tasks.get(index);
            return temp.getCompletionStatus();
        } else {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        }
    }
    public String getItemTitle(int index) {
        if (isItemValid(index)) {
            TaskItem temp = tasks.get(index);
            return temp.getTitle();
        } else {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        }
    }
    public String getItemDescription(int index) {
        if (isItemValid(index)) {
            TaskItem temp = tasks.get(index);
            return temp.getDescription();
        } else {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        }
    }
    public String getItemDate(int index) {
        if (isItemValid(index)) {
            TaskItem temp = tasks.get(index);
            return temp.getDate();
        } else {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        }
    }
    public TaskItem getItem(int index) {
        if (isItemValid(index)) {
            return tasks.get(index);
        } else {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        }
    }
    public boolean isItemValid(int index) {
        return index <= tasks.size();
    }

    public void write(String fileName) {
        try (Formatter output = new Formatter(fileName)) {
            for (int i = 0; i < tasks.size(); i++) {
                TaskItem temp = tasks.get(i);
                output.format("%b %s %s %s%n", temp.getCompletionStatus(), temp.getTitle(), temp.getDescription(), temp.getDate());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: unable to find the file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) throws FileNotFoundException {
        try {
            File fileText = new File(fileName);
            Scanner input = new Scanner(fileText);
            tasks.clear();

            while (input.hasNext()) {
                boolean status = input.nextBoolean();
                String title = input.next();
                String desc = input.next();
                String date = input.next();

                TaskItem temp = new TaskItem(status, title, desc, date);
                tasks.add(temp);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: unable to find the file.");
            throw new FileNotFoundException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
