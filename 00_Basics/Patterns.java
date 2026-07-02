import java.util.Scanner;

public class Patterns {
  
  public static void holloRectangle(int r,int c) {
    for(int i = 1 ; i<=r ; i++ ) {
      for(int j = 1 ; j<=c ; j++ ) {
        if(i==1 || i==r || j==1 ||  j==c ) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }

  public static void invertedHPyramid(int n) {
    int stars = 1;
    int spaces = n-1;
    int current_line = 1;

    while (current_line<=n) {
      for(int i = 1 ; i<=spaces ; i++ ) {
        System.out.print(" ");
      }
      for(int i  = 1 ; i<=stars ; i++ ) {
        System.out.print("*");
      }
      stars++;
      spaces--;
      current_line++;
      System.out.println();
    }
  }

  public static void numPyramid(int n) {
    int stars = n;
    int current_line = 1;

    while (current_line<=n) {
      for(int i=1 ; i<=stars ; i++ ) {
        System.out.print(i);
      }
      System.out.println();
      stars--;
      current_line++;
    }
  }

  public static void fluidsTriagle(int n) {
    int counter=1;
    for(int i = 1 ; i<=n ; i++ ) {
      for(int j= 1 ; j<=i ; j++ ) {
        System.out.print(counter+" ");
        counter++;
      }
      System.out.println();
    }
  }

  public static void zeroone(int n) {
    for(int i = 1 ; i<=n ; i++ ) {
      for(int j= 1 ; j<=i ; j++ ) {
        if((i+j)%2==0) {
          System.out.print("1");
        } else {
          System.out.print("0");
        }
      }
      System.out.println();
    }
  }

  public static void butterfly(int n ) {
    for(int i = 1 ; i<=n ; i++ ) {
      for(int j=1 ; j<=i; j++ ) {
        System.out.print("*");
      }
      for(int j = 1 ; j<=2*(n-i); j++ ) {
        System.out.print(" ");
      }
      for(int j=1 ; j<=i; j++ ) {
        System.out.print("*");
      }
      System.out.println();
    }
    for(int i = n ; i>=1 ; i-- ) {
      for(int j=1 ; j<=i; j++ ) {
        System.out.print("*");
      }
      for(int j = 1 ; j<=2*(n-i); j++ ) {
        System.out.print(" ");
      }
      for(int j=1 ; j<=i; j++ ) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void solidRhombus(int n) {
    for( int i= 1 ; i<=n ; i++ ) {
      for(int j=1 ; j<=n-i ; j++ ) {
        System.out.print(" ");
      }
      for(int j = 1 ; j<=n ; j++ ) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void holloRhombus(int n) {
    for(int i = 1 ; i<=n ; i++ ) {
      for(int j=1 ; j<=n-i ; j++ ) {
        System.out.print(" ");
      }
      for(int j=1 ; j<=n ; j++ ) {
        if(i==1 || i==n || j==1 || j==n ) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void newbutterfly(int n) {
    int spaces = 2*n-2;
    for(int i = 1 ; i<=2*n ; i++ ) {
      for(int j = 1 ; j<= i ; j++ ) { 
        System.out.print("*");
      }

      for(int j = 1 ; j<=spaces ; j++ ) {
        System.out.print(" ");
      }

      for(int j = 1 ; j<=i ; j++ ) {
        System.out.print("*");
      }
      System.out.println();
      if(i<=n) {
        spaces--;
      } else {
        spaces++;
      }
    }
  }

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("1.Hollow Rectangle");
      System.out.println("2.Inverted Hollow Pyramid");
      System.out.println("3.Number in Inverted Pyramid");
      System.out.println("4.Fluid's Triangle");
      System.out.println("5.Zero one Pyramid");
      System.out.println("6.Butterfly");
      System.out.println("7.Solid Rhombus");
      System.out.println("8.Hollow Rhombus");
      System.out.print("Enter Choice : ");
      int n = sc.nextInt();
      switch (n) {
        case 1 : System.out.print("Enter rows and columns : ");
                 int r = sc.nextInt();
                 int co = sc.nextInt();
                 holloRectangle(r, co);          
                break;
        case 2 : System.out.print("Enter number : ");
                 int a = sc.nextInt();
                 invertedHPyramid(a);
                break;
        case 3 : System.out.print("Enter number : ");
                 int b = sc.nextInt();
                 numPyramid(b);
                break;
        case 4 : System.out.print("Enter number : ");
                 int c = sc.nextInt();
                 fluidsTriagle(c);
                break;        
        case 5 : System.out.print("Enter number : ");
                 int d = sc.nextInt();
                 zeroone(d);
                break;
        case 6 : System.out.print("Enter number : ");
                 int e = sc.nextInt();
                 butterfly(e);
                break;
        case 7 : System.out.print("Enter number : ");
                 int f = sc.nextInt();
                 solidRhombus(f);
                break;
        case 8 : System.out.print("Enter number : ");
                 int g = sc.nextInt();
                 holloRhombus(g);
                break;
        default: System.out.println("Invalid");
      }
      sc.close();
  }
}