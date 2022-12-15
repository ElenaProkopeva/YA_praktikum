package sprint6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

public class StabTest {
    @Mock // добавь аннотацию
    PayrollCalculator payrollCalculator;

    @Test
    public void calcSalaryTest() {
        Mockito.when(payrollCalculator.calcSalary(0, 0,0)).thenReturn(50000); // опиши стаб
        Assert.assertEquals(50000, payrollCalculator.calcSalary(0, 0, 0));
    }
}

@RunWith(MockitoJUnitRunner.class)
class PayrollCalculator {

    public int calcSalary(int hours, int rate, int bonus) {
        return hours * rate + bonus;
    }

}