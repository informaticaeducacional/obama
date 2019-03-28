package br.ufrn.imd.obama.util;

import com.google.common.base.Strings;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 2,
                    hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
    }

    public static String criptografar(String senha) {
        if(!Strings.isNullOrEmpty(senha)) {
            if (md != null) {
                return new String(hexCodes(md.digest(senha.getBytes())));
            }
        }
        return null;
    }
}
