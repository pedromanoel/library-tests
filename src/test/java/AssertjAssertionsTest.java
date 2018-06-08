import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertjAssertionsTest {

    private UserAccount userAccount;

    @Before
    public void setUp() {
        userAccount = new UserAccount("pevange", "Pedro Evangelista");
    }

    @Test
    public void testDifferentAssertjAssertions() {
        assertThat("Meu nome é Pedro").contains("Pedro");
        assertThat("um texto").isEqualTo("um texto");
        assertThat(userAccount).hasFieldOrPropertyWithValue("username", "pevange");
        assertThat(asList(1, 2, 3)).hasSize(3);
    }
}
