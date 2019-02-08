package pay.one.faster.issuer.infra.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author claudioed on 2019-02-07.
 * Project credit-card-issuer
 */
public class Hashing {

  public static String hash(String data){
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA3_256");
      final byte[] hashBytes = digest.digest(
          data.getBytes(StandardCharsets.UTF_8));
      return bytesToHex(hashBytes);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Error hash");
    }
  }

  private static String bytesToHex(byte[] hash) {
    StringBuilder hexString = new StringBuilder();
    for (int i = 0; i < hash.length; i++) {
      String hex = Integer.toHexString(0xff & hash[i]);
      if(hex.length() == 1) hexString.append('0');
      hexString.append(hex);
    }
    return hexString.toString();
  }

}
