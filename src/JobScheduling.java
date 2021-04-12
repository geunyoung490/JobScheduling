//2021.04.10 오름차순 정렬코드 작성, 출력
//2021.04.12 while문 미완성 출력 이상하게 나옴...

import java.util.Arrays;

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

        for(int i = 0; i< L.length;i++) {
            System.out.println(L[i][0]+ " "+ L[i][1]);
        }

        int counts = 1;
        int i = 0;
        int s = 0; // 강의시작시간 저장변수
        while(i <L.length){//L배열의 길이만큼 while문 돌린다.

            if(L[s][1] <= L[i][0]) {//만약 종료시간보다 지금의 시작시간이 더 뒤의 일 일 경우.
                counts++;
                // 처음 작업의 종료시간보다 다음 작업의 시작 시간이 같거나 크면 작업 가능
                s = i;
            }

            i++; // 루프 돌아갈 때마다 올림
        }


        System.out.println("필요한 기계 대수는\n----------------");
        System.out.println(counts);




    }

}
