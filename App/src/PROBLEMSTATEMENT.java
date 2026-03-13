import java.util.*;

class Plagiarism {

    HashMap<String,Set<String>> index=new HashMap<>();

    List<String> ngrams(String text){

        String[] w=text.split(" ");
        List<String> list=new ArrayList<>();

        for(int i=0;i<w.length-2;i++)
            list.add(w[i]+" "+w[i+1]+" "+w[i+2]);

        return list;
    }

    void addDoc(String id,String text){

        for(String g:ngrams(text)){
            index.putIfAbsent(g,new HashSet<>());
            index.get(g).add(id);
        }
    }

    int check(String text){

        int match=0;

        for(String g:ngrams(text))
            if(index.containsKey(g))
                match++;

        return match;
    }

    public static void main(String[] args){

        Plagiarism p=new Plagiarism();

        p.addDoc("doc1","java is a programming language");

        int m=p.check("java is a powerful programming language");

        System.out.println("Matching ngrams: "+m);
    }
}