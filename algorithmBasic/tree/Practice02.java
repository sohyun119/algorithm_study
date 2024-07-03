package algorithmBasic.tree;
/*
* 각각의 에지에 가중치가 있는 포화 이진 트리가 있다.
* 루트에서 각 리프까지의 경로 길이를 모두 같게 설정하고,
* 이 때, 모든 가중치들의 총 합이 최소가 되도록 하는 프로그램을 작성하세요.
*
* idea) 가중치들의 총 합이 최소가 되려면 최대한 위 레벨을 수정하는게 좋다.!!
* // 코드 설명 : 밑단부터 재귀를 불러와서 각 노드의 가중치 더하고 옆에 있는 노드와 비교시
* // 큰 것에서 작은 것의 차를 더하고 위로 올려서 또 부모노드 더하고 또 옆과 비교
* // 그 총 합끼리의 차를 또 더한다
* */

class BinaryTree{
    int h;
    int[] arr;
    int res;

    public BinaryTree(int h, int[] w){
        this.h = h;
        arr = new int[(int)Math.pow(2,h+1)];
        res = 0;

        for(int i=2; i<(int)Math.pow(2,h+1); i++){
            arr[i] = w[i - 2];
        }
    }

    public int dfs(int idx, int h){

        if(this.h == h){
            res += arr[idx];
            return arr[idx];
        }
        int left = dfs(idx*2, h+1);
        int right = dfs(idx*2+1, h+1);
        res += arr[idx] + Math.abs(left - right);
        return arr[idx] + Math.max(left, right);
    }
}
public class Practice02 {

    public static void solution(int h, int[] w){
        BinaryTree bt = new BinaryTree(h, w);
        bt.dfs(1, 0);
        System.out.println(bt.res);
    }
    public static void main(String[] args) {

        // Test code
        int h = 2;
        int[] w = {2,2,2,1,1,3};
        solution(h, w);
        System.out.println();

        h = 3;
        w = new int[]{1,2,1,3,2,4,1,1,1,1,1,1,1,1,};
        solution(h, w);

    }
}
