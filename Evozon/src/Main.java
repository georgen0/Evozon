public class Main {
    public static void main(String[] args) {
        Repo r = new Repo();
        Controller ctrl = new Controller(r);
        View view = new View(ctrl);
        view.Run();
    }
}
