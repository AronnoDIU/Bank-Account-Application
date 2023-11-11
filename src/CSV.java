import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class CSV {

    // The CSV file reading utility
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
            /* The Logger class from the java.util.logging package is used
            to log the exception instead of using e.printStackTrace().*/
            Logger.getLogger(CSV.class.getName()).severe("COULD NOT FIND FILE");

            /*the throwing() method is called on the logger instance to log the exception itself
            and associate it with a specific method name (read()) and class name (CSV).
            This provides additional context about where the exception occurred.*/
            Logger.getLogger(CSV.class.getName()).throwing("CSV", "read", e);
            /*The Logger.getLogger() method is used to obtain a logger instance for the specified class
            (CSV in this case).The name of the logger is typically the fully qualified name of the class.
            The severe() method is then called on the logger instance to log a
            severe-level message indicating the nature of the exception.*/
        } catch (IOException e) {
            Logger.getLogger(CSV.class.getName()).severe("COULD NOT READ FILE");
            Logger.getLogger(CSV.class.getName()).throwing("CSV", "read", e);
            /*By using the Logger class, you can configure the logging framework to control the log
            output, log levels, and other settings.The logs can be directed to different outputs,
            such as the console or a log file.You can also configure different log levels
            (e.g., INFO, WARN, ERROR) to control the verbosity of the logs.

            Using a structured logging approach like this provides more flexibility and control over
            logging compared to simply calling printStackTrace().It allows you to log the exception
            in a consistent format and integrate it with your logging framework's
            configuration and log analysis tools.*/
        }

        return data;
    }

}