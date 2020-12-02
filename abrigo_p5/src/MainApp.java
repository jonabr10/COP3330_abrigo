import java.io.*;
import java.util.*;

public class MainApp {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = mainAppMenu();

        while (choice != 3) {

            if (choice == 1) {
                TaskApp taskLists = new TaskApp();
                taskLists.mainMenuChoice();

            }

            else if (choice == 2) {
                ContactApp contactLists = new ContactApp();
                contactLists.mainMenuChoice();
            }

            choice = mainAppMenu();
        }
        System.exit(0);

    }
    private static int mainAppMenu() {
        System.out.println("\nSelect Your Application");
        System.out.println("-----------------------");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");

        return isMainAppMenuValid();
    }
    private static int isMainAppMenuValid() {
        int ans = input.nextInt();

        if (ans == 1 || ans == 2 || ans == 3) {
            return ans;
        } else {
            System.out.println("Please choose a valid choice.");
            return mainAppMenu();
        }
    }



}
