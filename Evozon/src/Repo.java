import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repo {

    void Read() {
        File input = new File("Input.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(input));) {
            String line;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                //String[] item = line.split(",");
                System.out.println(line);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String Search(String str) {
        File input = new File("Input.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(input));
            String line;
            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");
                if (item[0].contains(str))
                    return line;
            }
            throw new IOException();
        } catch (IOException e) {
            System.out.println("Item not found");
            return null;
        }
    }

    void Add(Item i) {
        File output = new File("Input.txt");

        try (FileWriter fw = new FileWriter("Input.txt", true);) {
            String str = i.getProductName() + "," + i.getPrice() + "," + i.getQuantity();
            fw.write(str + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void Remove(String temp) {
        try {
            File file = new File("Input.txt");
            List<String> out = Files.lines(file.toPath())
                    .filter(line -> !line.contains(Search(temp)))
                    .collect(Collectors.toList());

            Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException | NullPointerException e) {
            System.out.println("Something went wrong");
        }
    }

    void Update(String searchString, Item i) {

        String str = i.getProductName() + "," + i.getPrice() + "," + i.getQuantity();

        Path FILE_PATH = Paths.get("Input.txt");
        List<String> fileContent = null;
        try {
            fileContent = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
            for (int k = 0; k < fileContent.size(); k++) {
                if (fileContent.get(k).equals(Search(searchString))) {
                    fileContent.set(k, str);
                    break;
                }
            }
            Files.write(FILE_PATH, fileContent, StandardCharsets.UTF_8);
        } catch (IOException e) {
        }
    }
}
