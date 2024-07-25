import java.util.Scanner;
public class BTree{
    int data;
    BTree left;
    BTree right;

    public BTree(int data){
        this.data=data;
    }
}

class  BinaryTree{
    static BTree root;
    public BinaryTree(){
        this.root=null;
    }

void inOrder(BTree root){
    if(root!=null){
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
}

void preOrder(BTree root){
    if(root!=null){
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
}
void postOrder(BTree root){
    if(root!=null){
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
}



void insertData(int val){
    BTree newNode = new BTree(val);
    if (root==null){
        root=newNode;
        System.out.println("sccessfully root was created");
    }else if(root.data==val){
        System.out.println("The root value already exists");
    }
    else
    {
        while(val<root.data)
        {
            if (root.left == null)
            {
                root.left = newNode;
                System.out.println("sccessfully added in left");
                break;
            }else{
                if (root.data == val){
                    System.out.println("the value already Exists");
                }else{
                    root = root.left;
                    
                }
            }
        }

        while(root.data < val){
            if (root.right == null)
            {
                root.right = newNode;System.out.println("sccessfully added in right");
                break;
            }
            else
            {
                if (root.data == val){
                    System.out.println("the value already Exists");
                }else{
                    root = root.right;
                }
            }
        }
    }
}

void delete(int val){
    if(root.data == val){
        root=null;
    }
}
    
    
    public static void main(String[] args) {
        BinaryTree B1 = new BinaryTree();
        int userInput;
        Scanner textFeild = new Scanner(System.in);
        do 
        { 
            System.out.println("---------------Binary Tree----------------");
            System.out.println("1 -> Insert Data");
            System.out.println("2 -> Show Inorder");
            System.out.println("3 -> Show Preorder");
            System.out.println("4 -> Show Postorder");
            System.out.println("5 -> Delete Data");
            System.out.println("6 -> Exit");
            System.out.print("Enter Your Option : ");

            userInput = textFeild.nextInt();

            switch (userInput) {
                case 1:
                    System.out.print("Enter the insert value : ");
                    int insertValue = textFeild.nextInt();
                    B1.insertData(insertValue);
                    break;
                case 2:
                    B1.inOrder(root);
                    break;
                case 3:
                    B1.preOrder(root);
                    break;
                case 4:
                    B1.postOrder(root);
                    break;
                case 5:
                if(root==null)
                {
                    System.err.println("Root is empty");
                }
                else
                {
                    System.out.print("Enter the insert value : ");
                    int deleteValue = textFeild.nextInt();
                    B1.delete(deleteValue);
                }
                break;
                default:
                    throw new AssertionError();
            }
        } while (userInput!=6);

        
        
    }
}