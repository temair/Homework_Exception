import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataApplication {
    public static void main(String[] args) {
        try {
            String userData = getUserData();
            String[] dataParts = userData.split(" ");
            validateDataCount(dataParts);
            String lastName = dataParts[0];
            String firstName = dataParts[1];
            String middleName = dataParts[2];
            String dateOfBirth = dataParts[3];
            String phoneNumber = dataParts[4];
            String gender = dataParts[5];
            validateDataFormats(dateOfBirth, phoneNumber, gender);
            String formattedData = formatUserData(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
            writeUserDataToFile(lastName, formattedData);
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

    public static void validateDataCount(String[] dataParts) throws InvalidDataFormatException {
        int expectedDataCount = 6;
        if (dataParts.length != expectedDataCount) {
            throw new InvalidDataFormatException("Неверное количество данных. Ожидается " + expectedDataCount + ".");
        }
    }

    public static void validateDataFormats(String dateOfBirth, String phoneNumber, String gender) throws InvalidDataFormatException {
        if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new InvalidDataFormatException("Неверный формат даты рождения. Ожидается dd.mm.yyyy.");
        }
        if (!phoneNumber.matches("\\d+")) {
            throw new InvalidDataFormatException("Неверный формат номера телефона. Ожидается целое беззнаковое число.");
        }
        if (!gender.matches("[mf]")) {
            throw new InvalidDataFormatException("Неверный формат пола. Ожидается символ 'm' или 'f'.");
        }
    }

    public static String formatUserData(String lastName, String firstName, String middleName,
                                        String dateOfBirth, String phoneNumber, String gender) {
        return lastName + " " + firstName + " " + middleName + " " + dateOfBirth + " " + phoneNumber + " " + gender;
    }

    public static void writeUserDataToFile(String lastName, String formattedData) throws IOException {
        String fileName = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(formattedData);
            writer.newLine();
        }
    }

    public static class InvalidDataFormatException extends Exception {
        public InvalidDataFormatException(String message) {
            super(message);
        }
    }
}
