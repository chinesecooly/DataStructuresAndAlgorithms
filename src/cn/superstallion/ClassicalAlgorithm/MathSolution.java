package cn.superstallion.ClassicalAlgorithm;

public class MathSolution {
    //372. 超级次方
    static public int superPow(int a, int[] b) {
        double temp=0d;
        int result=0;
        for (int i = 0; i <b.length; i++) {
            if (b[i]!=0){
                temp=b[i]*Math.pow(10,b.length-1-i);
                if (Double.isInfinite(Math.pow(a,temp))){
                    int count=0;
                    while (Double.isInfinite(Math.pow(a,temp))){
                        temp/=2;
                        count++;
                    }
                    for (int j = 0; j <Math.pow(2,count); j++) {
                        result+=(int)(Math.pow(a,temp)%1337);
                    }
                }else {
                    result+=(int)(Math.pow(a,temp)%1337);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(superPow( 2147483647, new int[]{2,0,0}));
        System.out.println(3%2d);
    }
}
