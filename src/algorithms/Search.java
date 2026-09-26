package algorithms;

import bookHandling.Book;
import java.util.List;
/*
 *
 * To utilize these search algorithms
 *
 * ARRAYLIST
 * 1. Binary Search....call both as an individual button
 * by book_id = one search parameter and by isbn = another search selection
 *
 * ex on how I tested it....
 *
 * List<Book> bookArrayList = new ArrayList<>();
 *        ImportCSV.readFile("books.csv", bookArrayList);
 *
 * int [] testIds = {25, 1, 99, 500};
 *        for (int id : testIds) {
 *            Book found = Search.binarySearchBooks(bookArrayList, id);
 *
 *            if (found == null) {
 *                System.out.println(id + " not found");
 *            } else {
 *                System.out.println(id + ". " + found.getTitle() + " || " + found.getAuthors());
 *            }
 *       }
 *
 *
 *LINKEDLIST
 *1. same method as the binary search. each search option gets its own button
 *
 */
public class Search {

    /*
     *
     * Binary Search for book_id...int
     *
     */

    public static Book binarySearchBooks(List<Book> books, int book_ID) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int middleID = books.get(mid).getBook_id();

            if (book_ID == middleID) {
                return books.get(mid);
            }
            if (book_ID < middleID) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    /*
     *
     * Binary Search for isbn...string
     *
     */

    public static Book binarySearchBooks(List<Book> books, String isbn) {
        int  low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String middleISBN = books.get(mid).getIsbn();
            int result = isbn.compareTo(middleISBN);

            if (result == 0) {
                return books.get(mid);
            }
            if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }




    /*
     *
     * FOR LINKEDLIST
     *
     * Linear Search book_id
     *
     */
    public static Book linearSearchBooks(List<Book> books, int book_ID) {
        for (int i = 0; i < books.size(); i++) {
            if (book_ID == books.get(i).getBook_id()) {
                return books.get(i);
            }
        }
        return null;
    }
    /*
     *
     *
     * FOR LINKEDLIST
     *
     * Linear Search isbn.
     *
     */
    public static Book linearSearchBooks(List<Book> books, String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (isbn.compareTo(books.get(i).getIsbn()) == 0) {
                return books.get(i);
            }
        }
        return null;
    }
}
