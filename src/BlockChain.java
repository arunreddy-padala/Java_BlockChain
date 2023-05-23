import com.google.gson.GsonBuilder;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/*
Basic blockchain class to add all the blocks together.
*/

public class BlockChain {

  public static int difficulty = 5;

  static ArrayList<Block> blockArrayList = new ArrayList<>();

  public  static void main(String[] args) throws NoSuchAlgorithmException {


    Block firstBlock = new Block("This is the first block", "0");
    Block secondBlock = new Block("This is the second block", firstBlock.hash);

    Block thirdBlock = new Block("This is the third block", secondBlock.hash);

    blockArrayList.add(firstBlock);
    System.out.println("Trying to mine first block");
    blockArrayList.get(0).mineBlock(difficulty);

    blockArrayList.add(secondBlock);
    System.out.println("Trying to mine second block");
    blockArrayList.get(1).mineBlock(difficulty);

    blockArrayList.add(thirdBlock);
    System.out.println("Trying to mine third block");
    blockArrayList.get(2).mineBlock(difficulty);

    System.out.println("\n");
    System.out.println("Block chain is valid? " + isValidChain());


    String blockChainJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockArrayList);
    System.out.println("The block chain: \n");
    System.out.println(blockChainJSON);

  }

  /*
  A method to test the integrity of the blocks within the blockchain by comparing their hash values.
   */
  public static boolean isValidChain() throws NoSuchAlgorithmException {

    Block currentBlock;
    Block previousBlock;

    for(int i=1; i<blockArrayList.size(); i++) {

      currentBlock = blockArrayList.get(i);
      previousBlock = blockArrayList.get(i-1);

      if(!currentBlock.hash.equals(currentBlock.calculateHash())) {

        System.out.println("Current Block hash values are not equal");
        return false;

      }

      if(!previousBlock.hash.equals((previousBlock.calculateHash()))) {

        System.out.println("Previous Block hash values are not equal");
        return false;

      }
    }

  return true;

  }
}
