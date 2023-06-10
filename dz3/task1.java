import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataApplication {
    public static void main(String[] args) {
        try {
            String userData = getUserData();
            String lastName = extractLastName(userData);
            writeUserDataToFile(lastName, userData);
            System.out.println("Данные успешно записаны в файл.");
        } catch (InvalidDataFormatException e) {
            System.out.println("Ошибка формата данных: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка чтения/записи файла: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getUserData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные пользователя:");
        String userData = scanner.nextLine();
        return userData;
    }

    public static String extractLastName(String userData) throws InvalidDataFormatException {
        String[] dataParts = userData.split(" ");
        if (dataParts.length != 6) {
            throw new InvalidDataFormatException("Неверное количество данных.");
        }
        return dataParts[0];
    }

    public static void writeUserDataToFile(String lastName, String userData) throws IOException {
        String fileName = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(userData);
            writer.newLine();
        }
    }

    public static class InvalidDataFormatException extends Exception {
        public InvalidDataFormatException(String message) {
            super(message);
        }
    }
}
