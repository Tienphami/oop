package pws;

public class Alpha { // tạo một tập hợp kí tự dựa trên các tham sô dầu vào
    // khởi tạo các biến hằng
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQSTUWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
    private final StringBuilder pool;


    public Alpha(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numbersIncluded, boolean specialCharactersIncluded) {

        pool = new StringBuilder();

        if (uppercaseIncluded) pool.append(UPPERCASE_LETTERS);

        if (lowercaseIncluded) pool.append(LOWERCASE_LETTERS);

        if (numbersIncluded) pool.append(NUMBERS);

        if (specialCharactersIncluded) pool.append(SYMBOLS);

    }

    public String getAlpha() {
        return pool.toString();
    }
}


