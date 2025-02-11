import java.util.PriorityQueue;

public class MergeKSortedArrays {
    static class Node implements Comparable<Node> {
        int value, arrayIndex, elementIndex;

        Node(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static int[] mergeKSortedArrays(int[][] arrays) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        int totalSize = 0;

        // 初始化最小堆，加入每个数组的第一个元素
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.add(new Node(arrays[i][0], i, 0));
                totalSize += arrays[i].length;
            }
        }

        int[] result = new int[totalSize];
        int index = 0;

        while (!minHeap.isEmpty()) {
            Node min = minHeap.poll();
            result[index++] = min.value;

            // 如果当前数组还有元素，加入下一个元素
            if (min.elementIndex + 1 < arrays[min.arrayIndex].length) {
                minHeap.add(new Node(arrays[min.arrayIndex][min.elementIndex + 1], min.arrayIndex, min.elementIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}
        };

        int[] mergedArray = mergeKSortedArrays(arrays);
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}
