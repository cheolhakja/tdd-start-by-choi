package tddstart.ch2.stringmeter;


import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordMeterTest {

    private void checkStrength(String passwordThatWillBeChecked, PasswordStrength expectedStrength) {
        PasswordMeter meter = new PasswordMeter();
        PasswordStrength strength = meter.meter(passwordThatWillBeChecked);
        assertThat(strength).isEqualTo(expectedStrength);
    }
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

        PasswordStrength strength_2 = meter.meter("Ab12!c");
        assertThat(strength_2).isEqualTo(PasswordStrength.NORMAL);
    }

    @Test
    void containsCapitalAndLongerThanEight_Then_Normal() {
        checkStrength("ab!@ABqwer", PasswordStrength.NORMAL);

    }

    @Test
    void inputNull_Then_Invalid() {
        checkStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void inputEmptyString_Then_Invalid() {
        checkStrength("", PasswordStrength.INVALID);
    }
}
