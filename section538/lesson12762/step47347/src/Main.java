class Main {
//Stepik code: start

    /**
     * Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.
     *
     * Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий массив.
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] res;
        int i, j, k, lenRes;
        i = j = k = 0;
        lenRes = a1.length + a2.length;
        res = new int[lenRes];

            for (; k < lenRes; k++) {
                    if (i > a1.length - 1) {
                        res[k] = a2[j++];
                    }
                    else if (j > a2.length - 1) {
                        res[k] = a1[i++];
                    }
                    else if (a1[i] < a2[j]) {
                        res[k] = a1[i++];
                    } else {
                        res[k] = a2[j++];
                    }
            }
        return res; // your implementation here
    }
//Stepik code: end
}
