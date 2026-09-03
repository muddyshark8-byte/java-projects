class Student
{
    String name;
    int score;

    public void Printreport()
    {
        System.out.println(name  + " You have the following score in biology" +" : " + " " +  score);
    }
    
}







public class Reportcard {
    public static void main(String[] args) 
    {
     Student student1 = new Student();
     student1.name = "Obiajulu";
     student1.score = 85;
     student1.Printreport();

     Student student2= new Student();
     student2.name = "Emeka";
     student2.score= 90;

    student2.Printreport();

    Student student3 = new Student();
    student3.name = "Amina";
    student3.score = 95;
    student3.Printreport();

    Student student4 = new Student();
    student4.name = "Kofi";
    student4.score = 88;
    student4.Printreport();

    Student student5 = new Student();
    student5.name = "Amara";
    student5.score = 92;
    student5.Printreport();
    }
}
