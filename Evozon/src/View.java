import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    private Controller ctrl;

    View(Controller ctrl) {
        this.ctrl = ctrl;
    }

    public void Run() {
        int cmd;
        while (true) {
            displayMenu();
            try {
                cmd = readInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid command, please try again");
                continue;
            }
            if (cmd == 1)
                Add();
            else if (cmd == 2)
                Update();
            else if (cmd == 3)
                Remove();
            else if (cmd == 4)
                Display();
            else if (cmd == 0)
                break;
            else System.out.println("Invalid input.");
        }
    }

    private void Display() {
        ctrl.Read();
    }

    private void Add() {
        Item i = readItem();
        ctrl.Add(i);
    }

    private void Update() {
        System.out.println("Enter the product name to be updated: ");
        String str = readString();
        if (ctrl.Search(str) != null)
        {
            System.out.println("Please enter the updated item: ");
            Item item = readItem();
            ctrl.Update(str, item);
        }
    }

    private void Remove() {

        System.out.println("Enter the product name to be removed: ");
        String str = readString();
        String temp = ctrl.Search(str);
        ctrl.Remove(temp);
    }

    private Item readItem() {
        System.out.println("Product name: ");
        String pn = readString();
        Item i = null;
        try {
            System.out.println("Quantity: ");
            int q = readInt();
            System.out.println("Price: ");
            int p = readInt();
            i = new Item(pn, q, p);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            return null;
        }
        return i;
    }

    private void displayMenu() {
        System.out.println("0.Exit");
        System.out.println("1.Add");
        System.out.println("2.Update");
        System.out.println("3.Delete");
        System.out.println("4.Display all");
    }

    private int readInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private String readString() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            return buffer.readLine();
        }
        catch (IOException e)
        {
            System.out.println("Invalid input");
        }
        return null;
    }

}
