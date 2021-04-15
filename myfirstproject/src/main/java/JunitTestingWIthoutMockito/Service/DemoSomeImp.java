package JunitTestingWIthoutMockito.Service;

class Q{

    public int num;
}

class Producer{

    public Q q;

        public Producer(Q q){
        this.q=q;
        q.num = 10;
        this.q.num = 20;

        }

        public void someOtherFunc(int num){

            num = 500;
            System.out.println("Number changes in the function to " + num);
        }

}

public class DemoSomeImp {

    public static void main(String[] args) {

        Q q = new Q();
        q.num = 5;
        System.out.println("In main before function call q.num = " + q.num);
        Producer p = new Producer(q);

        int myNewNum = 850;
        System.out.println("nyNewNum before fucntion = " + myNewNum);
        p.someOtherFunc(myNewNum);
        System.out.println("nyNewNum after fucntion = " + myNewNum);

        System.out.println("In main after function call q.num = " + q.num);
    }

}
