import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {

    public static ArrayList<Country> countryList = new ArrayList<>();
    public static HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();

    static String key;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String letter = "@";

        ArrayList<String> keyList = new ArrayList<>();

        //read file in
        File f = new File("Countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            //assign key value
            key = columns[1];
            key = key.substring(0, 1);
            keyList.add(key);

            Country country = new Country(columns[0], columns[1]);

            if (country.getName().startsWith(letter)) {
                countryList.add(country);
                countryMap.put(letter, countryList);
            } else {
                letter = country.getName().substring(0, 1);
                countryList = new ArrayList<>();
                countryList.add(country);
                countryMap.put(letter, countryList);
            }
        }
        fileScanner.close();

        boolean check = true;
        while (check) {
            System.out.println("Please enter a single letter:");
            String keyLetter = scanner.nextLine();
            if (keyLetter.length() == 1) {
                ArrayList newFile = countryMap.get(keyLetter);
                writeFile(keyLetter.toUpperCase() + "_Countries.txt", newFile.toString());
                check = false;
            } else {
                System.out.println("Input not valid. Please enter a single letter");
            }
        }
    }

    static void writeFile(String fileName, String fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(fileContent);
        fw.close();
    }
}
