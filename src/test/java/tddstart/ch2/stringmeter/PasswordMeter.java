package tddstart.ch2.stringmeter;

public class PasswordMeter {

    public PasswordStrength meter(String s) {
        boolean containsNumber = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 48 && c<=57) {
                //숫자이면
                containsNumber = true;
                break;
            }
        }
        if(containsNumber == false) {
            return PasswordStrength.NORMAL;
        }

        if(s.length() >= 8) {
            return PasswordStrength.STRONG;
        }

        return PasswordStrength.NORMAL;
    }
}
