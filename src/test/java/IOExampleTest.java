
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.io.*;


public class IOExampleTest {
//Задание 1.
private String sourcePath = "source.txt";
    private String destinationPath = "destination.txt";

    // Метод, который выполняется перед каждым тестом
    @BeforeEach
    void setUp() throws IOException {
        // Создаем файл source.txt
        File sourceFile = new File(sourcePath);
        if (!sourceFile.exists()) {
            sourceFile.createNewFile();
            // Записываем данные в файл (например, строку)
            try (FileWriter writer = new FileWriter(sourceFile)) {
                writer.write("Пример содержимого файла");
            }
        }

        // Создаем файл destination.txt
        File destinationFile = new File(destinationPath);
        if (!destinationFile.exists()) {
            destinationFile.createNewFile();
        }
    }

    // Метод, который выполняется после каждого теста
    @AfterEach
    void tearDown() {
        // Удаляем файлы после выполнения тестов
        new File(sourcePath).delete();
        new File(destinationPath).delete();
    }

    @Test
    void fileTest() {
        File file = new File(sourcePath);

        // Проверяем, существует ли файл
        Assertions.assertTrue(file.exists());
        System.out.println("Файл существует: " + file.getAbsolutePath());
        System.out.println("Имя файла: " + file.getName());

        // Проверяем, является ли это файлом
        Assertions.assertTrue(file.isFile());
        Assertions.assertFalse(file.isDirectory());
    }

    @Test
    void copyFileWithStreamsTest() {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            // Проверяем, что файл скопирован
            File destinationFile = new File(destinationPath);
            Assertions.assertTrue(destinationFile.exists());
            Assertions.assertTrue(destinationFile.isFile());
            System.out.println("Все прошло успешно!");

        } catch (IOException e) {
            Assertions.fail("Ошибка при копировании файла: " + e.getMessage());
        }
    }

}