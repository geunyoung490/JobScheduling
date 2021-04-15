import java.util.*;

class Job{
    int start;
    int finished;
}
public class JobScheduling {
    public static int L[][] = {{7,8},{3,7},{1,5},{5,9},{0,2},{6,8},{1,6}};
    public static ArrayList<Job>[] list = new ArrayList[5];
    public static int M=0;// 기계 수
    public static int Operating(int start){
        int i =0;
        //업무가 할당된 기계가 존재하는 경우
        if(M>0){
            for( i=0;i<M;i++){
                //업무를 수행하고 있는 기계가 있고
                //그 기계가 다음 업무를 수행할 수 있는 경우 해당 기계 배치
                if(list[i].size()>0 && list[i].get(list[i].size()-1).finished<=start){
                    return i;
                }
            }
            //업무를 수행할만한 기계가 없으면 새 기계 배치
            M++;
            return i;
        }
        //업무가 할당된 기계가 존재하지 않은 경우
        else{
            M++;
            return 0;
        }
    }
    public static void Scheduling(int n) {
        for(int j =0; j<5 ;j++){
            list[j] = new ArrayList<Job>();
        }

        int i = 0;
        while (i < n) {
            //기계번호를 할당 받고, 해당 기계에 업무 배정
            int machineNum = Operating(L[i][0]);
            list[machineNum].add(new Job());
            list[machineNum].get(list[machineNum].size()-1).start = L[i][0];
            list[machineNum].get(list[machineNum].size()-1).finished = L[i][1];
            i++;
        }
    }

    public static void main(String[] arg){
        int n = 7;
        Arrays.sort(L, (a,b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });// Line1: 오름차순 정렬
        Scheduling(n);
        System.out.println("작업의 수: "+n);
        System.out.println("기계의 수: "+M);

        for(int i =0;i<M;i++){
            if(list[i].size()!=0)
            {
                System.out.println("기계번호: "+i);
                for(int j =0;j<list[i].size();j++){
                    System.out.print("["+list[i].get(j).start+", "+list[i].get(j).finished+"]  ");
                }
                System.out.println();
            }
        }
    }
}
