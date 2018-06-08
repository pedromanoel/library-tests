import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

public class AssertjCollectionsAssertionsTest {

    private List<UserAccount> userAccounts;

    @Before
    public void setUp() {
        userAccounts = Arrays.asList(
                new UserAccount("aleite", "André Leite"),
                new UserAccount("bpereir", "Bruna Pereira"),
                new UserAccount("jrichard", "Johnny Richard"),
                new UserAccount("mballonin", "Marcelo Balloni"),
                new UserAccount("pevange", "Pedro Evangelista"),
                new UserAccount("raguiar", "Renata Aguiar"),
                new UserAccount("ralves", "Raony Alves")
        );
    }

    @Test
    public void testDifferentAssertjAssertions() {
        assertThat(userAccounts)
                .extracting("username")
                .contains("pevange");

        assertThat(userAccounts)
                .extracting("username", "displayName")
                .contains(tuple("ralves", "Raony Alves"))
                .doesNotContain(tuple("mfowler", "Martin Fowler"));
    }
}
