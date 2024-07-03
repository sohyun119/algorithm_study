package algorithmBasic.tree;

public class BinarySearchTree2 {
    Node head;

    BinarySearchTree2(int key){
        this.head = new Node(key, null, null);
    }

    public Node addNodeRecursive(Node cur, int key){
        if(cur == null){
            return new Node(key, null, null);
        }
        if(key < cur.key){
            cur.left = addNodeRecursive(cur.left, key);
        }else{
            cur.right = addNodeRecursive(cur.right, key);
        }

        return cur;
    }

    public Node removeNodeRecursive(Node cur, int key){
        if(cur == null){
            return null;
        }
        if(key < cur.key){
            cur.left = removeNodeRecursive(cur.left, key);
        }else if(key > cur.key){
            cur.right = removeNodeRecursive(cur.right, key);
        }else{
            if(cur.left == null){ // 자식노드가 하나 있거나, 없는 경우
                return cur.right;
            }else if(cur.right == null){
                return cur.left;
            }else{
                Node predecessor = cur;
                Node successor = cur.left;

                while(successor.right != null){
                    predecessor = successor;
                    successor = successor.right;
                }
                predecessor.right = successor.left;
                cur.key = successor.key;
            }
        }
        return cur;
    }

    // levelOrder : Queue 이용해서 출력
}
