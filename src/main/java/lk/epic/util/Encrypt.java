package lk.epic.util;

import java.util.Base64;

public class Encrypt {
    public static String encrypt(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes());
    }

    public static String decrypt(String s) {
        return new String(Base64.getDecoder().decode(s));
    }
}
