package com.company.chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    public static byte NOT_FOUND = -1;
    public static void main(String[] args) {
        List<Integer> sortedList = new ArrayList<>();
        Collections.addAll(sortedList,1,2,3,4,5,7,8,9,10,11,12,13);
        System.out.println(binarySearch(sortedList,30)); // -1
        System.out.println(binarySearch(sortedList,-20)); // -1
        System.out.println(binarySearch(sortedList,1)); // 0
        System.out.println(binarySearch(sortedList,13)); // 11
        System.out.println(binarySearch(sortedList,7)); // 5
        
    }

    static int binarySearch(List<Integer> sortedList, int item)
    {
        // low and high to keep track which part of the list contain the item
        int low = 0;
        int high = sortedList.size() - 1;

        int mid,guess;

        // While you haven't narrowed it down to one element ...
        while (low <= high)
        {
            // check the middle element
             mid = (low + high) / 2;
             guess = sortedList.get(mid);

             /*
               1  2  3  4  5  6  7  8  9
               ▲          ▲           ▲
               L           M           H
             */

            // Found the item
            if(guess == item) {
                return mid;
            }

            // the guess was too low ...
            else if(guess < item)
                low = mid + 1; //the lowest number in the side

                /*
                because of "guess" is lower than "item" we are sure of the "item"
                is not on the left side of the list maybe we can find item on the
                right side of the list, so we have to change "low" to the index next to "mid"

                                       1  2  3  4  5  6  7  8  9
                                                   ▲ ▲        ▲
                                                   M  L        H
               */



            // the guess was too high ...
            else
                high = mid - 1; //the lowest number in the side
                /*
                because of "guess" is greater than "item" we are sure of the "item"
                is not on the right side of the list maybe we can find item on the
                left side of the list, so we have to change "high" to the index before to "mid"

                                       1  2  3  4  5  6  7  8  9
                                       ▲        ▲ ▲
                                       L         H M

               */




        }

        return NOT_FOUND;
    }

}
