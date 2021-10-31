// Van Eck (Don't Know) Sequence implementation in java
// Don't Know (the Van Eck Sequence) - Numberphile
// https://www.youtube.com/watch?v=etMJxB-igrc

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class VanEck{

	static void solve(){
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		list.add(0);
		for(int num=0;;){
			if(set.contains(num)){
				for(int k=list.size()-2, backstep=0;k>=0;k--){
					backstep++;
					if(list.get(k)==num){
						list.add(backstep);
						num=backstep;
						break;
					}
				}
			}else{
				list.add(0);
				set.add(num);
				num=0;
			}
			System.out.println(list);
			
		}
	}
	public static void main(String args[]){
		solve();
	}
}	
