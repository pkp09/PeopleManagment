package test.exception;

class Exception1 {
   public void exceptionMethod() throws Exception {
      System.out.println("Exception1.exceptionMethod1()");
      throw new Exception("Exception1.exceptionMethod1()");
   }

   int getException(int iParam) {
Boolean b1 = new Boolean(false);
Boolean b2 = new Boolean(false);
if(b1.equals(b2)){
   System.out.println("boolean true");
}
if(b1 == b2){
   System.out.println(" ");
}

      int iCount = 1;
      try {
         iCount += iParam;
         exceptionMethod();
      } catch (Exception ex) {
         iCount -= iParam;
         System.out.println("Exception1.getException()");
      }
      return iCount;
   }
}

public class TestException {

   /**
    * @param args
    */
   public static void main(String[] args) {
      Exception1 objException1 = new Exception1();
      int i = objException1.getException(2);
      System.out.println("TestException.main()" + i);
   }
}