import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CoffeeScriptTest {

    @Test
    public void should_run_some_coffeeScriptCode() {
        CoffeeScript coffeeScript = new CoffeeScript();
        Object result = coffeeScript.execute("print(count for count in [1..2])");
//        assertThat(output).isEqualTo("1,2");
        System.out.println(result);
    }
}
