
import java.util.Scanner;
public class OilSpillSkillenza{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for(int t=1;t<=test;t++){
            int num = in.nextInt();
            int cap[] = new int[num];
            int filled[] = new int[num];
            for(int n=0;n<num;n++){
                cap[n] = in.nextInt();
            }
            System.out.println();
            for(int n=0;n<num;n++){
                filled[n] = in.nextInt();
            }
            System.out.println();
            int split = 0;
            int stored = 0;
            int splitSum  = 0;
            for(int n=1;n<num;n++){
                stored = filled[n-1] + filled[n];
                if(stored > cap[n]){
                    split = stored - cap[n];
                    stored -= split;
                    splitSum += split;
                }
                filled[n] = stored;
            }
            System.out.println(stored+" "+splitSum);
        }
    }
}
