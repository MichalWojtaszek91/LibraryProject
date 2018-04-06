package UtilTools;

import java.io.*;


public class UtilTools {

    public static Long idGenerator(String filePath) {
        Long lastId = 0L;
        String nextLane;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            while ((nextLane = bufferedReader.readLine()) != null) {
                lastId = Long.parseLong(nextLane);
            }
            lastId += 1;
            bufferedWriter.write(lastId.toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Io Exception detected");
        }
        return lastId;
    }


}
