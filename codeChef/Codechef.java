import java.util.*;
import java.util.Map.Entry;
import java.lang.*;

import java.io.*;

class Codechef
{
    static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{
        int t=sc.nextInt();
        while(t-->0){
            solve();
        }

        
	}
    public static void solve(){
        int n=sc.nextInt();
        int c=sc.nextInt();
        String s=sc.next();

        Map<Character,Integer> map=new HashMap<>();
        for(int i=0 ; i<n ; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        map=sortByValue(map);
        int ans=0;
        int count=1;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            int ifLearn=c;
            int ifHoreTranslat=0;
            int val=entry.getValue();
            while (val>0) {
                ifHoreTranslat+=count;
                count++;
                val--;
            }
            //System.out.println(ifLearn+"  "+ifHoreTranslat+    "       hehhe");
            ans+=Math.min(ifLearn, ifHoreTranslat);
        }

        System.out.println(ans);
    }
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    
}

/*
 1 0 0 2 1 1 0
 */