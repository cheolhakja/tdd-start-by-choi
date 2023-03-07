package tddstart.ch2.stringmeter;


import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordMeterTest {

    @Test
    void meetsAllConditions_Then_Strong() {
        PasswordMeter meter = new PasswordMeter();
        PasswordStrength strength = meter.meter("ab12!@AB");
        assertThat(strength).isEqualTo(PasswordStrength.STRONG);

        PasswordStrength strength_2 = meter.meter("abc1!@Add");
        assertThat(strength).isEqualTo(PasswordStrength.STRONG);
    }

    @Test
    void containsNumberAndCapitalLetter_Then_Normal() {
        PasswordMeter meter = new PasswordMeter();
        PasswordStrength strength = meter.meter("ab12!@A");
        assertThat(strength).isEqualTo(PasswordStrength.NORMAL);

    }


}
