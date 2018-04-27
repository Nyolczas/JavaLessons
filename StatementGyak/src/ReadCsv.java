import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCsv {

    public static void main(String[] args) throws FileNotFoundException {
        // .csv file
        String fileName = "D:\\8I\\Code\\JavaLessons\\StatementGyak\\AUDUSD_M5_Zoom.csv";
        File file = new File(fileName);
        Scanner inputStream;
        try (Scanner scanner = inputStream = new Scanner(file)) {
            while (inputStream.hasNext()){
                String data = inputStream.next();
                System.out.println(data);
            }
            inputStream.close();
        }

    }
}
