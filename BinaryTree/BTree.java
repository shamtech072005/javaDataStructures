import java.util.Scanner;
public class BTree{
    int data;
    int height;
    BTree left;
    BTree right;


    public BTree(int data)
    {
        this.data = data ;
        this.height = 1;
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
        
        System.out.println("height of "+root.data+" is "+root.height);

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
        System.out.println("successfully root was created");
    }else if(root.data==val){
        System.out.println("The root value already exists");
    }
    else
    {
        BTree curr = root;
        while(val<curr.data || val>curr.data)
        {
            if (val < curr.data)
            {
                
                if (curr.left == null)
                {
                    if(curr.right == null){
                        curr.height++;
                    }
                    curr.left = newNode;
                    System.out.println("the value of added in left");
                    break;
                }else
                {
                    if(curr.right==null || root.left!=null && root.right!=null){
                        curr.height++;
                    }
                    curr = curr.left;
                }
            }
            else
            {
                
                if (curr.right == null)
                {
                    if(curr.left == null){
                        curr.height++;
                    }
                    curr.right = newNode;
                    System.out.println("the value of added in right");
                    break;
                }else{
                    if(curr.left==null || root.left!=null && root.right!=null){
                        curr.height++;
                    }
                    
                    curr = curr.right;
                }
                
            }
        }
    }
}

 
    


BTree delete(BTree root,int val){
    if(root==null)
    {
        System.err.println("the value does not exists");          
        return null;
    }
    if(val<root.data)
    {
       root.left = delete(root.left,val);
    }
    else if(val>root.data) 
    {
        root.right = delete(root.right,val);
    }
    else
    {
        //value == root.data;
        if (root.left == null)
        {
            root = root.right;
        }
        else if (root.left != null)
        {
            root = root.left;
        }
        else
        {
            //handle two parent
                    BTree tempNode = root.right;
                    while(tempNode.left!=null)
                    {
                        tempNode = tempNode.left;
                    }
                    root.data = tempNode.data;
                    delete(root.right, tempNode.data);
            
        }
    }
    return root;
 } 
 boolean search(int searchVal){
    BTree temp = root;
    if (temp.data < searchVal){
        temp = temp.right;
    }
    else if(temp.data > searchVal)
    {
        temp = temp.left;
    }
    else
    {
        return true;
    }
    return  false;
 }  
void update(int newVal,int deleteVal)
{
    if (!search(deleteVal))
    {
        System.out.println("unable to update because old value not found");
    }
    else if(search(newVal))
    {
        System.out.println("unable to update because new value already exists");
    }else{
        delete(root, deleteVal);
        insertData(newVal);
        System.out.println("successfully updated");
    }
}
//  BTree update(BTree root,val){
//     return root;
//  }
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
            System.out.println("6 -> Update");
            System.out.println("7 -> Exit");
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
                        System.out.print("Enter the delete value : ");
                        int deleteValue = textFeild.nextInt();
                        root = B1.delete(root,deleteValue);    
                    
                    break;
                case 6:
                    System.out.print("Enter the update value : ");
                    int newValue = textFeild.nextInt();
                    System.out.print("Enter the delete value : ");
                    int delValue = textFeild.nextInt();
                    if(root==null)
                    {
                        B1.insertData(newValue);
                        System.err.println("Go and create a tree first");
                    }
                    else{
                        
                        B1.update(newValue, delValue);
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } while (userInput!=7);

        
        
    }
}