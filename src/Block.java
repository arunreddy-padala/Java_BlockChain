import java.security.NoSuchAlgorithmException;
import java.util.Date;

/*
A class for single block within a blockchain that contains the blocks hash, previous block's hash,
it's data and the timestamp when the block is created.
*/

public class Block {

  public String hash;
  public String previousHash;
  private String data;
  private long timeStamp;

  public Block(String Data, String PreviousHash) throws NoSuchAlgorithmException {

    this.data = Data;
    this.previousHash = PreviousHash;
    this.timeStamp = new Date().getTime();
    this.hash = calculateHash();

  }

  public String calculateHash() throws NoSuchAlgorithmException {

    String calculatedHash = EncryptString.applySha256(
            previousHash +
                    Long.toString(timeStamp) +
                    data
    );

    return calculatedHash;

  }

}


