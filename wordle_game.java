import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class wordlegame2
{
    public static void main(String args[]) throws Exception
    {
        File text = new File("/Users/bsav/Library/CloudStorage/OneDrive-MaynoothUniversity/Java/Wordle/wordlewords.txt");
        try (Scanner sc = new Scanner(text)) 
        {
            List<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] words = lines.toArray(new String[0]);

            //String[] words = {"hello", "broke", "money", "drunk", "clamp"};

            Random r=new Random();        
            int randomNumber=r.nextInt(words.length);
            String word = words[randomNumber];
            Scanner input = new Scanner(System.in);
            int g = 6;
            System.out.println(" You have " +g +" guess remaining");
            String guess = "";
            while(!guess.equals(word)&&g>0)
            {
                guess = input.nextLine();
                if(guess.length()!=5)
                {
                    System.out.println("Must be 5 characters");
                    continue;
                }

                for(int i = 0; i < word.length(); i++)
                {
                    boolean didBreak = false;
                    for(int j = 0; j<word.length(); j++)
                    {
                        if(guess.charAt(i)==word.charAt(i))
                        {
                            System.out.print(guess.charAt(i));
                            didBreak=true;
                            break;
                        }
                        if(guess.charAt(i)==word.charAt(j))
                        {
                            System.out.print("[" + guess.charAt(i) + "]" );
                            didBreak = true;
                            break;
                        }
                    }
                    if(!didBreak)
                    {
                        System.out.print("X");
                    }
                }

                g--;
                System.out.println(" You have " +g+ " guesses left");
            }
            System.out.println("The word was " + word);
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

    }    

    /*public static int random()
        {
            Random random = new Random();
            int value = random.nextInt(190 + 1) + 1;
            return value;
        }*/

    /*public static int random(string[] array)
        {
            string rnd = new Random().nextLine(array.length);
            return array[rnd];
        }*/
}
