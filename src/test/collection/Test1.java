package test.collection;

import static java.lang.System.out;

public class Test1 {
   int age;
   String name;
   static Test1 t3;

   Test1(int a, String s) {
      age = a;
      name = s;
   }

   @Override
   public String toString() {
      return age + " & " + name;
   }

   @Override
   public boolean equals(Object obj1) {
      // Correct Argument Type
      if ((obj1 == null) || !(obj1 instanceof Test1) || (obj1.getClass() != this.getClass()))
         return false;

      // Reflexive test
      if (obj1 == this)
         return true;

      // Argument Casting
      Test1 test = (Test1) obj1;

      // Field Comparisons
      if (this.name != null && !"".equals(this.name) && this.name.equals(test.name) && this.age == test.age)
         return true;

      return false;
   }

   /**
    * @param args
    */
   public static void main(String[] args) {
      Test1 test1 = new Test1(21, "Prashant");
      Test1 test2 = new Test1(21, null);

      if (t3 instanceof Test1) {
         System.out.println(test1);
      } else {
         System.out.println(t3);
      }
      out.println(test1);
      out.println(test2);
      out.println(test1.equals(test1));

      out.println(test1.equals(test2));
      out.println(test1 == test2);
      out.println(test1 == (new Test1(21, "Prashant")));
      out.println(test1.equals(new Test1(21, "Prashant")));

      Object test4 = test2;
      out.println(test1.equals(test4));
      // String s1 = "Aanchal";
      // String s2 = "Aanchal";
      // out.println(s1 == s2);
   }
}