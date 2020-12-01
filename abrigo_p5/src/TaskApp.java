import java.io.*;
import java.util.*;

public class TaskApp {
    private static Scanner input = new Scanner(System.in);
    private TaskList taskLists;

    public void mainMenuChoice() {
        int choice = mainMenu();

        while (choice != 3) {

            if (choice == 1) {
                taskLists = new TaskList();
                System.out.println("new task list has been created");
                tasksMenuChoice();
            }

            else if (choice == 2) {
                taskLists = new TaskList();
                input.nextLine();
                String fileName = getFileNameForLoading();
                try {
                    taskLists.load(fileName);
                    System.out.println("task list has been loaded");
                    tasksMenuChoice();
                } catch (FileNotFoundException e) {
                    System.out.println("File Name Inputted: " + fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            choice = mainMenu();
        }
    }
    private int mainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("---------");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");

        return isMainMenuValid();
    }
    private int isMainMenuValid() {
        int ans = input.nextInt();

        if (ans == 1 || ans == 2 || ans == 3) {
            return ans;
        } else {
            System.out.println("Please choose a valid choice.");
            return mainMenu();
        }
    }

    private void tasksMenuChoice() {
        int choice = listOpMenu();

        while (choice != 8) {
            if (choice == 1) {
                viewList();
            } else if (choice == 2) {
                addItem();
            } else if (choice == 3) {
                editItem();
            } else if (choice == 4) {
                removeItem();
            } else if (choice == 5) {
                markItemAsComplete();
            } else if (choice == 6) {
                markItemAsNotComplete();
            } else if (choice == 7) {
                saveList();
            }

            choice = listOpMenu();
        }
    }
    private int listOpMenu() {
        System.out.println("\n\nList Operation Menu");
        System.out.println("---------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) un-mark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");

        return isListOpMenuValid();
    }
    private int isListOpMenuValid() {

        int ans = input.nextInt();

        if (ans == 1 || ans == 2 || ans == 3
                || ans == 4 || ans == 5|| ans == 6
                || ans == 7 || ans == 8) {
            return ans;
        } else {
            System.out.println("Please choose a valid choice.");
            return listOpMenu();
        }
    }

    private void viewList() {
        System.out.println("\nCurrent Tasks");
        System.out.println("-------------");
        for (int i = 0; i < taskLists.getSize(); i++) {
            System.out.println(i + ") " + taskLists.getItem(i));
        }
    }
    private void addItem() {
        input.nextLine();
        String title = getTitle();
        String description = getDescription();
        String date = getDate();

        try {
            TaskItem data = new TaskItem(title, description, date);
            taskLists.addTask(data);

        } catch (InvalidTitleException e ) {
            System.out.println("Warning: Title was invalid");
        } catch (InvalidDescriptionException e) {
            System.out.println("Warning: Description was invalid");
        } catch (InvalidDateException e) {
            System.out.println("Warning: Date was invalid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void editItem() {
        viewList();
        try {
            int index = getIndex();
            input.nextLine();
            String title = getTitle();
            String description = getDescription();
            String date = getDate();

            taskLists.editTask(index, title, description, date);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Warning: index was invalid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void removeItem() {
        viewList();
        System.out.println("\nDeleting a task...");

        try {
            int index = getIndex();
            taskLists.removeTask(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Warning: index was invalid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void markItemAsComplete() {
        viewList();
        System.out.println("\nMarking an item as complete...");

        try {
            int index = getIndex();
            taskLists.editTaskCompletionStatusToDone(index);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Warning: index was invalid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void markItemAsNotComplete() {
        viewList();
        System.out.println("\nMarking an item as not complete...");

        try {
            int index = getIndex();
            taskLists.editTaskCompletionStatusToNotDone(index);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Warning: index was invalid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void saveList() {
        input.nextLine();
        String fileName = getFileNameForSaving();
        try {
            taskLists.write(fileName);
            System.out.println("task list has been saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getIndex() {
        System.out.print("\nPlease input which task you would like to select: ");
        return input.nextInt();
    }
    public String getTitle() {
        System.out.print("Task Title: ");
        return input.nextLine();
    }
    public String getDescription() {
        System.out.print("Task description: ");
        return input.nextLine();
    }
    public String getDate() {
        System.out.print("Task due date (MM/DD/YYYY): ");
        return input.nextLine();
    }
    private String getFileNameForLoading() {
        System.out.print("Enter the filename to load: ");
        return input.nextLine();
    }
    private String getFileNameForSaving() {
        System.out.print("Enter the filename to save: ");
        return input.nextLine();
    }



}
