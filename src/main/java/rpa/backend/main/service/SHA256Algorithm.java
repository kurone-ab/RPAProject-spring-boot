package rpa.backend.main.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Algorithm {
    public static String getHashedValue(String value) throws NoSuchAlgorithmException {
        byte[] bytes = value.getBytes();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(bytes);
        StringBuilder builder = new StringBuilder();
        for (byte aByte : digest.digest()) {
            builder.append(String.format("%02x", aByte));
        }
        return builder.toString();
    }
}
