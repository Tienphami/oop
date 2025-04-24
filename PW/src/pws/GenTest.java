package pws;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GenTest {
    private final Password password= new Password("Secret");
    private final Alpha firstAlphabet = new Alpha(true,false,false,false);
    private final Alpha secondAlphabet = new Alpha(false,true,true,true);
    private final Generator generator = new Generator(true,false,false,false);
//	private final Password generatedPassword = generator.GeneratePassword(4);

    @Test
    void test1() {
        assertEquals("Secret", password.toString());
    }

    @Test
    void test2() {
        assertEquals(firstAlphabet.getAlpha(), Alpha.UPPERCASE_LETTERS);
    }

    @Test
    void test3() {
        assertEquals(secondAlphabet.getAlpha(), Alpha.LOWERCASE_LETTERS + Alpha.NUMBERS + Alpha.SYMBOLS);
    }

    @Test
    void test4() {
        assertEquals(generator.alphabet.getAlpha(), Alpha.UPPERCASE_LETTERS);
    }

    @Test
    void test5() {
        assertEquals(generator.alphabet.getAlpha().length(), 26);
    }
}
