 public class OrderTotalCalc
{                                          // A SMALL ONLINE SHOP NEEDS A PROGRAM THAT CALCULATES A CUSTOMER'S FINAL ORDER
    public static void main(String[] args)
    {
       double totalAmount= 90;
       double Discountpercent= 0;
       if (totalAmount > 200)
       {
         Discountpercent = 20;
       } 
       else if (totalAmount > 100)
       {
         Discountpercent = 10;
       }
        else if (totalAmount> 50)
        {
            Discountpercent = 5;
        }
         double DiscountAmount= totalAmount * Discountpercent /100;
         double finalTotal= totalAmount - DiscountAmount;

         System.out.println ("Initial Amount: " + totalAmount);
         System.out.println ("Discount Offered: " + Discountpercent + "%");
         System.out.println ("Discount Amount: " + DiscountAmount);
         System.out.println ("Final total: " + finalTotal);
            
            
       
    }   


}