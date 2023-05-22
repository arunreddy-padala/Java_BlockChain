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

  public Block(String Data, String PreviousHash) {

    this.data = Data;
    this.previousHash = PreviousHash;
    this.timeStamp = new Date().getTime();

  }


  public String getHash() {
    return hash;
  }

  public String getPreviousHash() {
    return previousHash;
  }

  public String getData() {
    return data;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public void setHash(String hash) {

    this.hash = hash;
  }

  public void setPreviousHash(String previousHash) {
    this.previousHash = previousHash;
  }

  public void setData(String data) {
    this.data = data;
  }

  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }
}
