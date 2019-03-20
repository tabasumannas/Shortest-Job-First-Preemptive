import java.util.ArrayList;
import java.util.Scanner;
class data{
    private Scanner s=new Scanner(System.in);
    public int pId;
    public int pBt;
    public int pAt;
    public int pCt;
    public int theBt;
    public void getProcesses(){
        System.out.println("Enter the Process Id,Process Arrival Time &Process Burst Time");
        pId=s.nextInt();
        pAt=s.nextInt();
        pBt=s.nextInt();
    }
}
public class SjfPreemptive {
    private static int n=6;
    private static int tab=0;//number of CPU executions;
    private static void initialiseDataArray(data ex[]){
        for(int i=1;i<=n;i++){
            ex[i]=new data();
        }
    }
    private static void processData(data ex[]){//get the process data
        for(int i=1;i<=n;i++){
            ex[i].getProcesses();//'ex' can be for any object array of the class 'data';this line collects the attributes
            ex[i].theBt=ex[i].pBt;
        }
    }

    private static ArrayList<Integer> sac=new ArrayList<Integer>();
    private static void collector(data ex[]){
        for(int i=0;i<=n;i++){
            sac.add(i,0);
        }
        for(int i=1;i<=n ;i++){
            if(ex[i].pAt<=tab && ex[i].theBt>0) {
                System.out.println("Yes the " + ex[i].pId + "th process has met the requirements");
                sac.set(i, ex[i].theBt);
            }
        }

        data variable=new data();// here i don't need a data array cos variable is going to hold a single object for a while
        int var;
        for (int i=1;i<=n;i++){
            for (int j=i+1;j<=n;j++){
                if (sac.get(i)>sac.get(j)){
                    if(sac.get(i)==sac.get(j)){
                        if(ex[i].pAt<ex[i].pAt){

                        }
                    }
                    variable = ex[i];//sac.get(i);
                    var =sac.get(i);
                    ex[i]=ex[j];//sac.set(i,sac.get(j));
                    sac.set(i,sac.get(j));
                    ex[j]=variable;
                    sac.set(j,var);
                }
            }
        }
    }
    private static void completionTime(data ex[]){
        int k = 1;
        boolean flag=true;
        boolean ff=false;
        int count=0;
        for (; k <= n;) {
            data backup[]=new data[100];
            for(int q=1;q<=n;q++){
                backup[q]=ex[q];
            }

            collector(ex);
            for (int h = 1; h <= n; h++){
//                if(sac.get(h-1)!=0){
//                    if(sac.get(h-1).equals(sac.get((h))) && ex[h-1].pAt>ex[h].pAt){
//                        ff = true;
//                        count = ex[h].pId;
//                        ex[h].theBt = (ex[h].theBt - 1);//Decrementing the Burst Time of the ith process whose pId is ex[i].pId;
//                        backup[count].theBt=ex[h].theBt;
//                        tab=tab+1;
//                        System.out.println(ex[h].pId + " th process used CPU by one unit");
//                        if (ex[h].theBt == 0) {
//                            k++;
//                            ex[h].pCt = tab;
//                            backup[count].pCt=tab;
//                            System.out.println("\n\nCompletion Time of " + ex[h].pId + " is " + ex[h].pCt);
//                        }
//                    }
//                }
                if (sac.get(h) != 0) {
                    flag = false;
                    ff = true;
                    count = ex[h].pId;
                    ex[h].theBt = (ex[h].theBt - 1);//Decrementing the Burst Time of the ith process whose pId is ex[i].pId;
                    backup[count].theBt=ex[h].theBt;
                    tab=tab+1;
                    System.out.println(ex[h].pId + " th process used CPU by one unit");
                    if (ex[h].theBt == 0) {
                        k++;
                        ex[h].pCt = tab;
                        backup[count].pCt=tab;
                        System.out.println("\n\nCompletion Time of " + ex[h].pId + " is " + ex[h].pCt);
                    }
                }
                if (ff) {
                    ff = false;
                    break;
                }
            }
            for(int q=1;q<=n;q++){
                ex[q]=backup[q];
            }
         }
    }
    public static void main(String [] args){
        data taba[]=new data[100];
        initialiseDataArray(taba);
        processData(taba);
        completionTime(taba);
    }
}
/*All Rights Reserved
Nongjaimayum Annas khan
Husband of Ph Tabasum Sahani
*/