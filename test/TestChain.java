import java.security.NoSuchAlgorithmException;

/*
Basic test class to test the functionality of Block, EncryptString class.
*/

public class TestChain {

  public  static void main(String[] args) throws NoSuchAlgorithmException {

    Block firstBlock = new Block("This is the first block", "0");
    System.out.println("Hash for first block is: " + firstBlock.hash);

    Block secondBlock = new Block("This is the first block", firstBlock.hash);
    System.out.println("Hash for second block is: " + secondBlock.hash);

    Block thirdBlock = new Block("This is the first block", secondBlock.hash);
    System.out.println("Hash for third block is: " + thirdBlock.hash);


  }


}
