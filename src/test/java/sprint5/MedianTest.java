package sprint5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
@RunWith(Parameterized.class)
public class MedianTest {
//    List<String> median = new ArrayList<>();
    private final int expected;
    private final int a;
    private final int b;
    private final int c;

    public MedianTest(int expected, int a, int b, int c) {
        this.expected = expected;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static int med(int a, int b, int c){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        int sum = 0;
        for (Integer num: numbers) {
            sum += num;
        }
        //возвращает среднее из них [1, 2, 3] -> 2; [2, 4, 3] -> 3
        return Math.round(sum/numbers.size());
    }

    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][] {
                { 2, 1, 2, 3},
                { -2, -1, -2, -3},
                { 0, 0, 0, 0},
        };
    }

    // реализовать метод
    // написать список проверок для него
    // написать тесты по этим проверкам

    @Test
    public void shouldSeeMed(){
        assertThat("Среднее арифметическое рассчитано неверно", med(a, b, c), is(expected));
        //хэппи кейс
        assertThat("Среднее арифметическое рассчитано неверно", med(1, 2, 3), is(2));
        //кейс с отрицательными значениями
        assertThat("Среднее арифметическое рассчитано неверно", med(-1, -2, -3), is(-2));
        //кейс с нулями
        assertThat("Среднее арифметическое рассчитано неверно", med(0, 0, 0), is(0));
    }
}
