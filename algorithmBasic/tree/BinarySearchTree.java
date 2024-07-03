package algorithmBasic.tree;

class Node{
    int key;
    Node left;
    Node right;

    Node(int key, Node left, Node right){
        this.key = key;
        this.left = left;
        this.right = right;
    }

}
public class BinarySearchTree {
    Node head;

    BinarySearchTree(int key){
        this.head = new Node(key, null, null);
    }

    public void addNode(int key){
        if(this.head == null){
            this.head = new Node(key, null, null);
        }else{
            Node cur = this.head;

            while(true){
                Node pre = cur;

                if(key < cur.key) {
                    cur = cur.left;

                    if (cur == null) {
                        pre.left = new Node(key, null, null);
                        break;
                    }
                }
                else{
                    cur = cur.right;

                    if(cur == null){
                        pre.right = new Node(key, null, null);
                        break;
                    }
                }
            }
        }
    }

    public void removeNoe(int key){
        Node parent = null;
        Node successor = null;
        Node predecessor = null;
        Node child = null;

        Node cur = this.head;
        while(cur != null){
            if(key == cur.key){
                break;
            }
            parent = cur; //cur위치 변환 위에 있으므로 종료시 cur의 부모노드를 가진다.

            if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        if(cur == null){
            System.out.println("key에 해당하는 노드가 없습니다.");
            return;
        }

        // Leaf 노드 인 경우
        if(cur.left == null && cur.right == null){
            if(parent == null){ // 사실상 트리에 노드가 한 개인 케이스
                this.head = null;
            }else{
                if(parent.left == cur){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }
        }
        // 자식 노드가 한 개인 경우
        else if((cur.left != null && cur.right == null)
            || (cur.left == null && cur.right != null)){
            if(cur.left != null){
                child = cur.left;
            }else{
                child = cur.right;
            }
            if(parent == null){ // cur이 루트노드이고, 루트노드에 자식이 하나 있는 경우
                this.head = child;
            }else{
                if(parent.left == cur){
                    parent.left = child;
                }else{
                    parent.right = child;
                }
            }
        }
        // 자식 노드가 둘 인 경우 (제일 복잡한)
        else{
            predecessor = cur;
            successor = cur.left; // 삭제 대상 노드기준 왼쪽에서 제일 오른쪽에 있는 것 빼오기

            while(successor.right != null){
                predecessor = successor;
                successor = successor.right;
            }
            predecessor.right = successor.left;
            successor.left = cur.left;
            successor.right = cur.right;

            if(parent == null){
                this.head = successor;
            }else{
                if(parent.left == cur){
                    parent.left = successor;
                }else{
                    parent.right = successor;
                }
            }
        }
    }

}
