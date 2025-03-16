package microunit;

import microunit.framework.Assertions;
import microunit.framework.Test;

public class AddterTest {
    @Test
    public void shoudAddZeroPlusZeroCorrectly(){
        final var adder = new Adder();

        final int actual = adder.add(0,0);

        Assertions.equals(actual,1);
    }

    @Test
    public void shouldAddOnePlusOneCorrectly() {
        // Given (Arrange)
        final var sut = new Adder(); // sut-nak hívjuk amit tesztelünk
        final var expected = 2;

        // When (Act)
        final int actual = sut.add(1,1);

        //Then (Assert)
        Assertions.equals(actual,expected);
    }

}
