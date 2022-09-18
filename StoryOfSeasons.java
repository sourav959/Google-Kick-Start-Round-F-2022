import java.util.*;
class ListCom implements Comparator{
    public int compare(Object o1,Object o2){
        List<Integer> f1=(List<Integer>) o1;
        List<Integer> f2=(List<Integer>) o2;

        return f1.get(2) - f2.get(2);
    }
}
class Solution{
    private static int solve(int d, int n, int x, List<List<Integer>> arr) {
        Map<Integer,Integer> hm=new HashMap<>();
        int profit=0;
        for(int i=1;i<d;i++){
            hm.put(i,-1);
        }
        Collections.sort(arr,new ListCom().reversed());
        for (int i=0;i<n;i++){
            int q= arr.get(i).get(0);
            int l= arr.get(i).get(1);
            int v= arr.get(i).get(2);
            int Z=d-l;
            if(hm.containsKey(Z)){
                if(hm.get(Z)==-1){
                    hm.put(Z,i);
                    if(Z+l<=d)
                        profit+=v;
                }else{
                    Z--;
                    while(Z!=0){
                        if(hm.get(Z)==-1){
                            hm.put(Z,i);
                            if(Z+l<=d)
                                profit+=v;
                            break;
                        }
                        Z--;
                    }
                }
            }

        }
        return profit;
    }
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),x=1;
        while(t>0){
            int d=sc.nextInt();
            int n=sc.nextInt();
            int X= sc.nextInt();
            List<List<Integer>> arr=new ArrayList<>();
            for(int i=0;i<n;i++){
                int q= sc.nextInt();
                int l= sc.nextInt();
                int v= sc.nextInt();
                List<Integer> li=new ArrayList<>();
                li.add(q);
                li.add(l);
                li.add(v);
                arr.add(li);
            }
            int ans=solve(d,n,X,arr);
            System.out.println("Case #"+x+": "+ans);
            x++;
            t--;
        }
    }


}
