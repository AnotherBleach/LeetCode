    package WeBank;

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {

            int n, m;
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            m = scanner.nextInt();
            if(n==1){
                System.out.println(1);
                return;
            }
            int[]data = new int[1001];
            for(int i=0;i<n;i++)
                data[i] = i+1;


            int count=n;
            int index = -1;
            while(count>1)
            {
                for(int i=0;i<m;i++)
                {
                    index = (index+1)%n;
                    while(data[index]==-1)
                        index=(index+1)%n;

                }
                count--;
                System.out.print(data[index]+" ");
                data[index]=-1;


            }
            System.out.println();
            while(data[index]==-1)
                index=(index+1)%n;
            System.out.println(data[index]);

        }

    }
