import java.util.*;

class Entry{
    String ip;
    long expiry;

    Entry(String ip,long ttl){
        this.ip=ip;
        expiry=System.currentTimeMillis()+ttl;
    }
}

class DNSCache{

    HashMap<String,Entry> cache=new HashMap<>();

    String resolve(String domain){

        Entry e=cache.get(domain);

        if(e!=null && e.expiry>System.currentTimeMillis())
            return "Cache HIT "+e.ip;

        String ip="172.217.14."+new Random().nextInt(200);

        cache.put(domain,new Entry(ip,5000));

        return "Cache MISS -> "+ip;
    }

    public static void main(String[] args){

        DNSCache d=new DNSCache();

        System.out.println(d.resolve("google.com"));
        System.out.println(d.resolve("google.com"));
    }
}