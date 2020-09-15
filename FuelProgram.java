/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class FuelProgram {
   public static void main(String args[] ) throws Exception {

	Scanner in = new Scanner(System.in);
	String elevations[] = in.nextLine().split(",");
	String fuels[] = in.nextLine().split("#");
	int cong_spaces = 0;
	int k = 0;
	for(k=0;k<elevations.length && Integer.parseInt(elevations[k]) == 0;k++);
	int start = Integer.parseInt(elevations[k]);
	StringBuilder ind = new StringBuilder("[");
	List<String> cong = new ArrayList<String>();
	for(int i=k+1;i<elevations.length;i++){
	    int el = Integer.parseInt(elevations[i]);
	    if(el < start){
	        cong_spaces += start - el;
	        ind.append(i+","); 
	        
	    }else if(el == start){
	        if(Integer.parseInt(elevations[i-1]) > el)
	            continue;
	        ind.deleteCharAt(ind.length()-1);
	        ind.append("]");
	        cong.add(cong_spaces+""+ind);
	        cong_spaces = 0;
	        ind = new StringBuilder("[");
	    }else{
	        ind.deleteCharAt(ind.length()-1);
	        ind.append("]");
	        cong.add(cong_spaces+""+ind);
	        cong_spaces = 0;
	        ind = new StringBuilder("[");
	    }
	}
	cong.sort(Collections.reverseOrder());
	for(int i=0;i<fuels.length;i++){
	    int f_quant = Integer.parseInt(fuels[i].substring(fuels[i].indexOf(":")+1,fuels[i].length()));
	    int f_quant_sum = 0;
	    StringBuilder sb = new StringBuilder();
	    boolean flag = false;
	    String output = "";
	   for(String s : cong){
	       
	       int least_csp = Integer.parseInt(s.substring(0,s.indexOf("[")));
	       if(least_csp == f_quant){
	            output = s.substring(s.indexOf("["),s.length());
	            cong.remove(s);
	            flag = true;
	            break;
	        }else if(least_csp < f_quant){
	            f_quant_sum += least_csp;
	            sb.append(s.substring(s.indexOf("[")+1,s.indexOf("]"))+",");
	            
	        }
	        if(f_quant_sum == f_quant){
	            sb.insert(0,"[");
	            sb.deleteCharAt(sb.length()-1);
	            sb.append("]");
	            output = sb.toString();
	            flag = true;
	            cong.remove(s);
	            break;
	        }
	   }
	   if(!flag){
	        output += "[]";
	   }
	    if(i == fuels.length - 1)
	        System.out.print(output);
	       else
	        System.out.print(output+",");
	}
   }
}
