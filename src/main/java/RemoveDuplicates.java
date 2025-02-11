public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] array) {
        if (array.length == 0) return new int[0];

        int writeIndex = 0;
        for (int readIndex = 1; readIndex < array.length; readIndex++) {
            if (array[readIndex] != array[writeIndex]) {
                writeIndex++;
                array[writeIndex] = array[readIndex];
            }
        }

        int[] result = new int[writeIndex + 1];
        System.arraycopy(array, 0, result, 0, writeIndex + 1);
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int[] uniqueArray = removeDuplicates(array);

        for (int num : uniqueArray) {
            System.out.print(num + " ");
        }
    }
}
