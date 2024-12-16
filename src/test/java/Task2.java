import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.io.*;

public class Task2 {


    private String tempFilePath = "empFile.txt";

    // Метод, который выполняется перед каждым тестом
    @BeforeEach
    void setUp() throws IOException {
        // Создаем временный файл
        File tempFile = new File(tempFilePath);
        if (!tempFile.exists()) {
            tempFile.createNewFile();
            // Записываем данные в файл (например, строку)
            try (FileWriter writer = new FileWriter(tempFile)) {
                writer.write("Пример содержимого файла");
            }
        }
       // System.out.println("Временный файл создан: " + tempFilePath);
    }

    // Метод, который выполняется после каждого теста
    @AfterEach
    void tearDown() {
        // Удаляем временный файл
        new File(tempFilePath).delete();
        //System.out.println("Временный файл удален: " + tempFilePath);
    }

    // 1. Подбрасывание исключения
    @Test
    void throwExceptionTest() {
        try {
            // Подбрасываем непроверяемое исключение
            throw new RuntimeException("Это непроверяемое исключение");
        } catch (RuntimeException e) {
            Assertions.assertEquals("Это непроверяемое исключение", e.getMessage());
            System.out.println("Тест throwExceptionTest пройден");
        }
    }

    // 2. Вызов метода, который подбрасывает проверяемое исключение
    @Test
    void throwCheckedExceptionTest() {
        try {
            // Вызываем метод, который подбрасывает проверяемое исключение
            throwCheckedException();
        } catch (IOException e) {
            Assertions.assertEquals("Это проверяемое исключение", e.getMessage());
            System.out.println("Тест throwCheckedExceptionTest пройден");
        }
    }

    // Метод, который подбрасывает проверяемое исключение
    public void throwCheckedException() throws IOException {
        throw new IOException("Это проверяемое исключение");
    }

    // 3. Использование блока finally
    @Test
    void finallyBlockTest() {
        boolean flag = false;

        try {
            // Подбрасываем исключение
            throw new Exception("Это исключение");
        } catch (Exception e) {
            Assertions.assertEquals("Это исключение", e.getMessage());
            System.out.println("Тест finallyBlockTest пройден");
        } finally {
            // Блок finally выполняется всегда
            flag = true;
            Assertions.assertTrue(flag);
        }
    }
}