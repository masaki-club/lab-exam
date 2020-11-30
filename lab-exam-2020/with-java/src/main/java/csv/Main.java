package csv;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var users = new UserCsvReader().readUserCsv("users.csv");
            users.stream()
                    .filter(user -> user.getCode().startsWith("m"))
                    .map(user -> user.getName().toLowerCase() + ":" + user.getCode() + ":" + user.getGrade())
                    .sorted()
                    .forEach(System.out::println);
        }
}
