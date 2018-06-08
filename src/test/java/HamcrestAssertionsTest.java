import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class HamcrestAssertionsTest {

    private UserAccount userAccount;

    @Before
    public void setUp() {
        userAccount = new UserAccount("pevange", "Pedro Evangelista");
    }

    @Test
    public void testDifferentHamcrestAssertions() {
        assertThat("Meu nome é Pedro", containsString("Pedro"));
        assertThat("um texto", is("um texto"));
        assertThat(userAccount, hasProperty("username", equalTo("pevange")));
        assertThat(asList(1, 2, 3), hasSize(3));
    }
}
