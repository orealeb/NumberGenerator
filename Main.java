import java.io.*;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    generateRandomNumbers();
  }

  static void generateRandomNumbers() {
    // open file with try block
    try (PrintStream file = new PrintStream("test.output")) {
      Random rand = new Random();

      // set upper bound in loop to 997940
      int upperBound = 997940;
      int previousNum = 0;
      int lineIndex = 0;
      for (int i = 0; i < upperBound; i++) {
        int num = rand.nextInt(20) + 1; // random number returns value from 0 to 19 so increment by 1

        // if previous number is same as current number then do not print to console or add to file
        // increment upperBound by 1
        if(previousNum == num){
          upperBound++;
          continue;
        }


        // if value is 20 print index plus 1 in console because loop starts with '0'
        if (num == 20) {
          System.out.println(lineIndex + 1);
        }

        // write to output file
        file.println(Integer.toString(num));

        //update previous number and incrememnt lineIndex
        previousNum = num;
        lineIndex++;
      }

    } 
    catch (IOException e) { // handle IO exception
      System.out.println("Can't read File");
    }
  }
}