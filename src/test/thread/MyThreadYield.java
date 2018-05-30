package test.thread;

import java.util.ArrayList;
import java.util.List;

public class MyThreadYield {
    public static void main(String a[]){
        List<ExmpThread> list = new ArrayList<ExmpThread>();
        String str ="Hello";
        for(int i=1;i<3;i++){
            ExmpThread et = new ExmpThread(i*5, str);
            list.add(et);
            et.start();
        }
        for(ExmpThread et:list){
            try {
                et.join();
            } catch (InterruptedException ex) { }
        }
    }
}
 
class ExmpThread extends Thread{
     String str ="";
    private int stopCount;
    public ExmpThread(int count, String str){
        this.stopCount = count;
        this.str=str;
    }
    public void run(){
    	synchronized(this){
        for(int i=0;i<50;i++){
            if(i%stopCount == 0){
                System.out.println("Stoping thread: "+getName() +" : " + stopCount +" "+i);
                //str = str + i;
                //yield();
                try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                System.out.println("Stoping thread: "+getName() +" : " + stopCount +" "+i +" In If");
            }
            System.out.println("Stoping thread: "+getName() +" : " + stopCount +" "+i +"In for");
        }
    	}
    }
}