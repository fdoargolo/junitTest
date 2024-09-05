package packageTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IdentifierMainTest {

    static private ByteArrayOutputStream baOut;
    static private PrintStream psOut;
    
    @BeforeAll
    public static void beforeClassInit() {
        baOut = new ByteArrayOutputStream();
        psOut = new PrintStream(baOut);
        System.setOut(psOut);
    }    
    
    @AfterAll
    public static void afterClassFinalize() {
        System.setOut(System.out); // Reset System.out to its original state
        psOut.close();
    }
    
    @BeforeEach
    public void setUp() {
        baOut.reset();
    }
    
    @Test
    public void validTest01() {
        IdentifierMain.main(new String [] {"a1"});
        String output = baOut.toString().trim(); // Trim to handle newlines
         
        assertEquals("Valido", output);
    }
    
    @Test
    public void invalidTest02() {
        IdentifierMain.main(new String [] {"2b3"});
        String output = baOut.toString().trim();
         
        assertEquals("Invalido", output);
    }
    
    @Test
    public void invalidTest03() {
        IdentifierMain.main(new String [] {"z-12"});
        String output = baOut.toString().trim();
         
        assertEquals("Invalido", output);
    }
    
    @Test
    public void invalidTest04() {
        IdentifierMain.main(new String [] {"a1b2c3d4"});
        String output = baOut.toString().trim();
         
        assertEquals("Invalido", output);
    }
}
