import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;

public class csvDemo {

        public static void main(String[] args) {

            try{

                CSVReader reader = new CSVReader(new FileReader("C:/Users/User/Documents/Tozsde/MT4ek/XM1/MQL4/Files/XM_19061180.csv"));
                String[]nextline;
                while((nextline = reader.readNext()) != null)
                {
                    if(nextline != null)
                    {
                        System.out.println(Arrays.toString(nextline));
                    }
                }
            }catch(Exception e)
            {
                System.out.println(e);
            }
            System.out.println("CSV Read complete");
        }
}
