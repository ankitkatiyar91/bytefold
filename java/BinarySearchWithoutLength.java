import static java.lang.Math.pow;

public class BinarySearchWithoutLength {

  public static Integer binarySearch(final Integer[] elements, final Integer find) {
    /*
     * Start looking for element at the 0th position and move in multiple of 2. like 2^0, 2^1, 2^2,
     * 2^3
     */
    Integer index = 0;
    Integer exp = 0; // initial exponent value will be 0
    try {
      while (true) {
        // check if we found the element at 2^exp index
        if (elements[index] == find) {
          return index;
        }
        if (elements[index] < find) {
          index = (int) pow(2, exp);
          exp += 1;
        } else {
          break;
        }
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      /*
       * ignore this exception as we expect it to happen if we go beyond the size of the array
       * without finding element at position 2^exp
       */
    }
    int mid; // it will represent mid value where lookup will happen
    int left = (index / 2) + 1;
    int right = index - 1;
    /*
     * we will start our lookup from the middle of the array and then shift towards other half of
     * the array.
     */
    while (left <= right) {
      mid = ((right + left) / 2);
      try {
        if (elements[mid] == find) {
          /*
           * As we have found one matching element. Stop
           */
          return mid;
        } else {
          if (elements[mid] > find) {
            /* whenever you find and element which is greater than the find */
            right = mid - 1;
          } else {
            left = mid + 1;
          }
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        /*
         * we got this because we reached beyond the size, shift our right index to one place left
         * of the mid
         */
        right = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Integer[] sample_1 = new Integer[] {-3, -2, 3, 4, 7};
    Integer[] sample_2 = new Integer[] {-3, -2, -1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    Integer[] sample_3 = new Integer[] {1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    System.out.println("Index of 4: " + binarySearch(sample_1, 4));
    System.out.println("Index of 4: " + binarySearch(sample_2, 4));
    System.out.println("Index of 4: " + binarySearch(sample_3, 10));
    System.out.println("Index of 4: " + binarySearch(sample_3, 0));
  }
}
