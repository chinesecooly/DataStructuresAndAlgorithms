package cn.superstallion.DataStructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class HuffmanTree {

    class Node {
        private int weight;
        private int parentIndex;
        private int leftIndex;
        private int rightIndex;

        public Node() {
        }

        public Node(int weight, int parentIndex, int leftIndex, int rightIndex) {
            this.weight = weight;
            this.parentIndex = parentIndex;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }

        @Override
        public String toString() {
            return "{" +
                    "weight=" + weight +
                    ", parentIndex=" + parentIndex +
                    ", leftIndex=" + leftIndex +
                    ", rightIndex=" + rightIndex +
                    '}' + "\n";
        }
    }

    private Node[] nodes;

    public HuffmanTree(int[] weights) {
        this.nodes = new Node[2 * weights.length - 1];
        //构造森林全是根
        for (int i = 0; i < weights.length; i++) {
            nodes[i] = new Node(weights[i], 0, 0, 0);
        }

        //选用两小造新树,删除两小添新人,重复2、3剩单根
        int end = weights.length - 1;
        for (int i = 0; i < end; i += 2) {
            Optional<Node> min1 = Arrays.stream(nodes)
                    .filter((node) -> {
                        return node!=null&&node.parentIndex == 0;
                    })
                    .min(Comparator.comparingInt((node) -> node.weight));
            int minIndex1=-1;
            for (int j = 0; j < end + 1; j++) {
                if (nodes[j]==min1.get()){
                    minIndex1=j;
                    break;
                }
            }
            Optional<Node> min2 = Arrays.stream(nodes)
                    .filter((node) -> {
                        return node!=null&&node.parentIndex == 0&&!node.equals(min1.get());
                    })
                    .min(Comparator.comparingInt((node) -> node.weight));
            int minIndex2=-1;
            for (int j = 0; j < end + 1; j++) {
                if (!min2.isPresent()){
                    return;
                }
                if (nodes[j]==min2.get()){
                    minIndex2=j;
                    break;
                }
            }
            nodes[++end] = new Node(min1.get().weight + min2.get().weight, 0, minIndex1, minIndex2);
            min1.get().parentIndex = end;
            min2.get().parentIndex = end;
        }
    }

    @Override
    public String toString() {
        return "HuffmanTree" + "\n" + Arrays.toString(nodes);
    }

    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree(new int[]{7, 19, 2, 6, 32, 3, 21, 10});
        System.out.println(huffmanTree);
    }
}
