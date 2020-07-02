package a.b.c.tut.security.umata.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public final class NoOpPasswordEncoder implements PasswordEncoder {
    private static final PasswordEncoder INSTANCE = new NoOpPasswordEncoder();

    public String encode(CharSequence rawPassword) {
        // throw new RuntimeException("got encoder check: " + rawPassword.toString());
        return rawPassword.toString();
        // return "1234";
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // throw new RuntimeException("got match check raw:" + rawPassword.toString() + " encoded:" + encodedPassword);
        return rawPassword.toString().equals(encodedPassword);
    }

    public static PasswordEncoder getInstance() {
        return INSTANCE;
    }

    private NoOpPasswordEncoder() {
    }
}
