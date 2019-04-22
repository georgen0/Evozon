import java.io.IOException;

public class Controller {

    Repo repo;

    Controller (Repo r)
    {
        repo = r;
    }

    public void Add(Item i) {
        repo.Add(i);
    }
    public void Remove(String temp){
        repo.Remove(temp);
    }
    public void Update(String searchString, Item item2)
    {
        repo.Update(searchString, item2);
    }
    public void Read(){
        repo.Read();
    }
    public String Search(String str){
        return repo.Search(str);
    }
}
