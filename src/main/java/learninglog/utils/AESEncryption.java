package learninglog.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AESEncryption {

    public static final String ALGORITHM = "AES";
    public static final String KEY = "qwertyuiopasdfgh";

    public static String encrypt(String plainText) {
        String encryptedPassword = plainText;

        try {

            SecretKey keySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE,keySpec);
            byte [] cipherText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            encryptedPassword = Base64.getEncoder().encodeToString(cipherText);

        } catch (Exception e) {
            e.printStackTrace();
        }
         return encryptedPassword;
    }

    public static String decrypt(String cipherText) {
        String decryptedData = cipherText;
        try {
            SecretKey keySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8),ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte [] decryptedPassword = cipher.doFinal(Base64.getDecoder().decode(cipherText));
            decryptedData = new String(decryptedPassword,StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
         return decryptedData;
    }
}
