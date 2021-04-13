//2021.04.10 오름차순 정렬코드 작성, 출력
//2021.04.12 while문 미완성 출력 이상하게 나옴...우선순위큐로 다시 짜야 할 듯
//2021.04.13 수정 필요할 듯 하다.

import java.util.Arrays;
import java.util.PriorityQueue;

public class JobScheduling {


    public static void main(String[] args) {

      int L [][] = {
                {7,8},{3,7},{1,5},{5,9},{0,2},{6,8},{1,6}
                //{시작시간,종료시간}
        };

        //이차원배열을 오름차순으로 정렬하는 코드
        Arrays.sort(L, (a1, a2) -> { //정렬이 목적이 아니기 때문에 Arrays 함수를 이용..
            if (a1[0] == a2[0]){
                return a1[1] - a2[1]; //같은 시작시간일 경우 종료시간도 오름차순
            }
            else {
                return a1[0] - a2[0]; //시작시간 순 정렬
            }
        });

        System.out.println("주어진 작업들을 정렬 후 출력\n---------------");

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //우선순위큐를 만들어준다.
        pq.add(L[0][1]); //큐에 첫작업의 종료시간을 넣는다.


        for(int i = 0; i< L.length;i++) {
            System.out.println(L[i][0]+ " "+ L[i][1]);
        }

        //peek은 첫번째 값을 반환
        //poll은 첫번째 값을 반환하고 버림 -> peek하고 remove해버린다

        int i = 1;
        while( i < L.length) {

            if(pq.peek() <= L[i][0]){
                pq.poll(); //작업의 시작시간이 큐의 peek 값보다 작거나 같으면, pq에서 하나 빼서 버린다.
            }
            pq.add(L[i][1]); //현재 종료시간을 다시 pq에 넣어준다.

            i++;// 루프횟수를 알맞게 돌리기 위한 i 1증가

        }

        System.out.println("필요한 기계 대수는\n----------------");
        System.out.println(pq.size());//pq에 남아있는 것들의 개수가 필요한 기계의 대수이다.




    }

}
