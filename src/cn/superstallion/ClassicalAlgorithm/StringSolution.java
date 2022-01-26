package cn.superstallion.ClassicalAlgorithm;

public class StringSolution {
    //1446. 连续字符
    static public int maxPower(String s) {
        int length=0;
        int temp=0;
        for (int i = 0; i +1< s.length(); i++) {
            if (s.charAt(i+1)==s.charAt(i)){
                temp++;
            }else {
                if (temp>length){
                    length=temp;
                }
                temp=0;
            }
        }
        if (temp>length){
            length=temp;
        }
        return length+1;
    }

    //1816. 截断句子
    static public String truncateSentence(String s, int k) {
        int temp=0;
        int index=0;
        for (; index<k&&index+1<s.length(); ) {
            temp=s.indexOf(' ',temp+1);
            index++;
        }
        if (temp==-1){
            return s;
        }else {
            return s.substring(0,temp);

        }
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("chopper is not a tanuki",5));
    }
}
