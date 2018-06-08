import lombok.Value;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.groups.Tuple;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {
    @Test
    public void testSoftAssertions() {

        final SoftAssertions soft = new SoftAssertions();

        soft.assertThat(10).isGreaterThan(11);
        soft.assertThat("12345").hasSize(4);
        soft.assertThat(true).isFalse();

        soft.assertAll();
    }

    @Test
    public void testIterable() {
        final List<String> strings = Arrays.asList("Um", "Dois", "Três");


        assertThat((Iterable<String>) strings).containsSequence("Um", "Dois", "Três");
    }

    @Test
    public void testAssertCallMethodInIterable() {
        final List<String> strings = Arrays.asList("x", "xx", "xxx");

        assertThat(strings).extractingResultOf("length").contains(1, 2, 3);
    }

    @Test
    public void testAssertExtractTupleData() {
        final List<Person> people = Arrays.asList(
                new Person("Pedro", 32, "Dev"),
                new Person("Johnny", 30, "Dev"),
                new Person("Renata", 30, "BA")
        );

        assertThat(people).extracting("name", "age", "profession").contains(
                Tuple.tuple("Pedro", 32, "Dev")
        );
    }

    @Value
    private static class Person {
        String name;
        Integer age;
        String profession;
    }
}
