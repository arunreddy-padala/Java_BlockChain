import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
A class that takes a plain text string and returns an SHA-256 encrypted string.
 */
public class EncryptString {

  public static String applySha256(String plainText) throws NoSuchAlgorithmException {

    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    byte[] hash = messageDigest.digest(plainText.getBytes());
    StringBuffer hexString = new StringBuffer();

    for(int i=0; i<hash.length; i++) {

      String hex = Integer.toHexString(0xff & hash[i]);
      if(hex.length() == 1) hexString.append('0');
      hexString.append(hex);

    }

    return hexString.toString();

  }

}
