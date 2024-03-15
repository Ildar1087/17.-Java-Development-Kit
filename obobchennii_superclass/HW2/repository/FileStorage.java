package HW2.repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements Repository {
    private static final String LOG_PATH = "src/main/java/seminar/ui/history.txt";

    public void save(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public String load(){
            StringBuilder stringBuilder = new StringBuilder();
            try (FileReader reader = new FileReader(LOG_PATH);) {
                int c;
                while ((c = reader.read()) != -1) {
                    stringBuilder.append((char) c);
                }
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
                return stringBuilder.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
//    @Override
//    public String load() {
//        return null;
//    }
    }
