public class Exams 
{
    public static void main(String[] args) 
    {    
    

        int scores [] = {45, 72, 91, 38, 64, 50, 83, 27, 76, 88};
        int total = 0;
        int highest = scores [0];
        int lowest = scores [0];
        int passed = 0;
        // go through every score
        for (int score : scores)
        {
            System.out.println("Score: " + score);
            // add the score to the total
            total = total + score;

            if (score > highest)
            {
                highest = score;
            }
            if (score < lowest)
            {
                lowest = score;
            }
            if (score >= 50)
            {
                passed++;
            }
        }

        System.out.println("The average is as follows: " + (double) total / scores.length);
        System.out.println("The highest score is as follows: " + highest);
        System.out.println("The lowest score is as follows: " + lowest);
        System.out.println("The number of students who passed is as follows: " + passed);
    } 

        




}
