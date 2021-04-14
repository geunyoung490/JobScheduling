import java.util.*;


class Job {
    int s;
    int f;
    public Job(int i, int i1) {
        this.s = s;
        this.f = f;
    }

    //Line 1. 시작시간의 오름차순으로 정렬한 작업리스트 L
    static Comparator<Job> comparator = new Comparator<Job>() {
        @Override
        public int compare(Job o1, Job o2) {
            if(o1.s==o2.s) return Integer.compare(o1.f,o2.f);
            else return Integer.compare(o1.s,o2.s);
        }
    };

}


/*
class machine {
    int machine(){


    }
}

 */

public class JobScheduling {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //몇개 입력할 것인지
        
        Job[] L = new Job[n]; // L이름의 Job형태 배열 생성
        for(int i=0;i<n;i++)
            L[i] = new Job(sc.nextInt(),sc.nextInt()); // 각 작업의 시작시간, 종료시간 입력

        Arrays.sort(L,Job.comparator); // 오름차순으로 정렬


        System.out.println(L);



        /*

        while(L != ){

        }



       (a1, a2) -> { //정렬이 목적이 아니기 때문에 Arrays 함수를 이용..
            if (a1.s == a2.s){
                return a1.f - a2.f; //같은 시작시간일 경우 종료시간도 오름차순
            }
            else {
                return a1.s - a2.s; //시작시간 순 정렬
            }




 List<Job> L = Arrays.asList(
                new Job(7,8),
                new Job(3,7),
                new Job(1,5),
                new Job(5,9),
                new Job(0,2),
                new Job(6,8),
                new Job(1,6)
        );





        7
7 8
3 7
1 5
5 9
0 2
6 8
1 6


         */



    }

}
