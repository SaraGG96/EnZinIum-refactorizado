package enzinium;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InsufficientTokensExceptionTest {

    private Address rick = null;
    private TokenContract contract = null;

    @Before
    public void setupContract() {
        rick = new Address();
        rick.generateKeyPair();
        contract = new TokenContract(rick);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void InsufficientTokensExceptionThrowTest() {
        contract.require(false);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void InsufficientTokensExceptionMessageTest() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("No dispones de tokens suficientes para completar la transaccion.");
        contract.require(false);
    }
}
