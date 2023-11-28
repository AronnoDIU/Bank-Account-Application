import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class CSV {
    public static List<String[]> read(String file) {
        List<String[]> data = new LinkedList<>();
        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((dataRow = br.readLine()) != null) {
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(CSV.class.getName()).severe("COULD NOT FIND FILE");
            Logger.getLogger(CSV.class.getName()).throwing("CSV", "read", e);
        } catch (IOException e) {
            Logger.getLogger(CSV.class.getName()).severe("COULD NOT READ FILE");
            Logger.getLogger(CSV.class.getName()).throwing("CSV", "read", e);
        }
        return data;
    }
}