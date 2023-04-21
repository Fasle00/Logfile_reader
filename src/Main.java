import sun.util.calendar.BaseCalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> logFile = readLogFile();

        int errors = countErrors(logFile);
        System.out.println(errors);

        ArrayList<String> gitActivity = getGitActivity(logFile);
        for (String line:gitActivity){
            System.out.println(line);
        }

        // ArrayList<String> error = getErrors(logFile, "2022-11-02", )
        
    }

    public static ArrayList<String> readLogFile() throws FileNotFoundException {
        Scanner input = new Scanner(new File("ideaold.log"));
        ArrayList<String> list = new ArrayList<>();
        while (input.hasNext()){
            list.add(input.nextLine());
        }
        return list;
    }

    public static int countErrors(ArrayList<String> list){
        int errors = 0;
        for (String line:list) {
            if (line.contains("ERROR")){
                errors++;
            }
        }
        return errors;
    }

    public static ArrayList getGitActivity(ArrayList<String> list){
        ArrayList<String> git = new ArrayList<>();
        String info;
        for (String line:list) {
            if (line.contains("github ")){
                info = "Date: [" + line.substring(0,10) + "] Description: " + line.substring(78);
                git.add(info);
            }
        }
        return git;
    }

    public static ArrayList getErrors(ArrayList<String> list, String begin, String end){
        ArrayList<String> errors = new ArrayList<>();
        return errors;
    }

}