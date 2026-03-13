import java.util.*;

class AutoComplete{

    HashMap<String,Integer> freq=new HashMap<>();

    void add(String q){
        freq.put(q,freq.getOrDefault(q,0)+1);
    }

    List<String> search(String prefix){

        List<String> res=new ArrayList<>();

        for(String s:freq.keySet())
            if(s.startsWith(prefix))
                res.add(s);

        return res;
    }

    public static void main(String[] args){

        AutoComplete a=new AutoComplete();

        a.add("java tutorial");
        a.add("javascript");
        a.add("java download");

        System.out.println(a.search("jav"));
    }
}