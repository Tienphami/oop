package pws;
import java.util.Scanner;

public class Generator {
    Alpha alphabet;
    public static Scanner keyboard;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        alphabet = new Alpha(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
    }

    public void mainLoop() {
        System.out.println("Trình tạo mật khẩu :)");
        printMenu();

        String userOption = "-1";

        while (!userOption.equals("4")) {

            userOption = keyboard.next();

            switch (userOption) {
                case "1" -> {
                    requestPassword();
                    printMenu();
                }
                case "2" -> {
                    checkPassword();
                    printMenu();
                }
                case "3" -> {
                    printUsefulInfo();
                    printMenu();
                }
                case "4" -> printQuitMessage();
                default -> {
                    System.out.println();
                    System.out.println("Nhap sai! Nhap lai");
                    printMenu();
                }
            }
        }
    }

    private Password GeneratePassword(int length) {   // tạo mật khẩu
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlpha().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlpha().charAt(index));
        }

        return new Password(pass.toString());
    }

    private void printUsefulInfo() {
        System.out.println();
        System.out.println(" Mật khẩu tối thiểu 8 kí tự");
        System.out.println("Chữ cái thường, hoa, kí hiệu, chữ số");
        System.out.println("Tạo mật khẫu ngẫu nhiên");
        System.out.println("Không sử dụng một mật khẩu cho nhiều tài khoản");
        System.out.println("Không sử dụng:  lặp kí tự (aaaaa), chuỗi số, thông tin cá nhân");
        System.out.println("Không dùng thông tin mà người khác biết được");

    }

    private void requestPassword() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;

        boolean correctParams;

        System.out.println();
        System.out.println("Yes / No");

        do {
            String input;
            correctParams = false;

            do {
                System.out.println("Sử dụng chữ cái thường ?");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeLower = true;

            do {
                System.out.println("Sử dụng chữ cái in hoa ? ");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeUpper = true;

            do {
                System.out.println("Sử dụng chữ số ?");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeNum = true;

            do {
                System.out.println("Sử dụng các kí tự đặc biệt ? ");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeSym = true;

            //No Pool Selected
            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
                System.out.println("Mật khẩu ít nhất phải có một loại kí tự");
                correctParams = true;
            }

        } while (correctParams);

        System.out.println("Nhập độ dài mật khẩu: ");
        int length = keyboard.nextInt();

        final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
        final Password password = generator.GeneratePassword(length);

        System.err.println("Mật khẩu được tạo:  " + password);
    }

    private boolean isInclude(String Input) {
        if (Input.equalsIgnoreCase("yes")) {
            return true;
        }
        else {
            return false;
        }
    }

    private void PasswordRequestError(String i) {
        if (!i.equalsIgnoreCase("yes") && !i.equalsIgnoreCase("no")) {
            System.out.println("Nhập sai! Nhập lại \n");
        }
    }

    private void checkPassword() {
        String input;

        System.out.print("\nNhập mật khẩu");
        input = keyboard.next();

        final Password p = new Password(input);

        System.out.println(p.calculateScore());
    }

    private void printMenu() {
        System.out.println();
        System.out.println(" 1 - Tạo mật khẩu");
        System.out.println(" 2 - Kiểm tra mật khẩu");
        System.out.println(" 3 - Thông tin");
        System.out.println(" 4 - Thoát");
        System.out.print("Choice:");
    }

    private void printQuitMessage() {
        System.out.println("Thoát khỏi ứng dụng");
    }
}
