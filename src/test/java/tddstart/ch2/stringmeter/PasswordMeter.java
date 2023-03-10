package tddstart.ch2.stringmeter;

public class PasswordMeter {

    public PasswordStrength meter(String s) {
        if(s == null) {
            return PasswordStrength.INVALID;
        }

        if(s.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        if(containsNumber(s) == false) {
            return PasswordStrength.NORMAL;
        }

        if(s.length() >= 8) {
            return PasswordStrength.STRONG;
        }

        return PasswordStrength.NORMAL;
    }

    private boolean containsNumber(String s) { //로직이 길어지니까 메서드로 추출하기
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
            return false;
        }

        return true;
    }
}
