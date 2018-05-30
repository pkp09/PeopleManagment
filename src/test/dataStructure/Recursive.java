package test.dataStructure;

public class Recursive {
   int iCount = 0;

   int printNumber(int i) {
      if (i == 0) {
         return 0;
      } else {
         System.out.println(" " + i);
         printNumber(i - 1);
      }
      return 0;
   }

   int factorial(int i) {
      if (i == 0)
         return 1;
      else
         return i * factorial(i - 1);
   }
int isArraySorted(int[]a, int index){
   if(a.length == 1)
      return 1;
   return(a[index -1 ] < a[index -2]?0:isArraySorted(a, index-1));
}
   int sortArray(int[] a, int count) {
      if (count == 1)
         return a[count];
      // descending { 1, 2, 3, 4, 5 }
      else if (a[count - 1] > a[count - 2]) {
         int temp = a[count - 1];
         a[count - 1] = a[count - 2];
         a[count - 2] = temp;
         printArrayWithFor(a, a.length - 1);
         sortArray(a, (count - 1));
      }
      count--;
      return (sortArray(a, count));
   }

   void printArray(int[] a, int length) {
      if (length == 1) {
         System.out.print(a[length - 1]);
      } else {
         System.out.print(a[length - 1]);
         printArray(a, (length - 1));
      }
      System.out.print("\t");
   }

   void printArrayWithFor(int[] a, int length) {
      for (int index = 0; index < a.length; index++)
         System.out.print(a[index] + " ");
      System.out.println();
   }

   public static void main(String[] args) {
      Recursive objRecursive = new Recursive();
      // Print numbers in descending order
      // objRecursive.printNumber(10);

      // Factorial Example
      // int factorial = objRecursive.factorial(4);
      // System.out.println(factorial);

      // sort an array
      // int[] a = { 10, 1, 9, 2, 8 };
      int a1[] = { 1, 2, 3, 4, 5 };
      objRecursive.isArraySorted(a1, a1.length);
      for (int i = 0; i < a1.length; i++)
         System.out.print(a1[i] + "\t");
      // Print an array
      //objRecursive.printArray(a1, a1.length);
      System.out.println();
   }
}