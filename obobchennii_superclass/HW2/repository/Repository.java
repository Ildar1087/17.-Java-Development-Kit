package HW2.repository;

import java.io.IOException;

public interface Repository {
    void save(String text);
    String load();
}
