package algorithms;

import bookHandling.Book;
import java.util.Collections;
import java.util.List;

public class SelectionSort {
    // Sorts books by top ten
    public static void selection(List<Book> books) {

        for (int i = 0; i < 10 && i < books.size(); i++) {
            int top = i;

            for (int j = i + 1; j < books.size(); j++) {
                if (books.get(j).getAverage_rating() > books.get(top).getAverage_rating()) {
                    top = j;
                }
            }
            Collections.swap(books, i, top);
        }
    }
    // Prints out top ten
    public static void topTen(List<Book> books) {
        for (int i = 0; i < 10 && i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println((i + 1) + ". " + b.getTitle() + " || " + b.getAverage_rating());
        }
    }

    /*
     *
     * SELECTION SORT JUST FOR THE ISBN
     *
     *
     */
    public static void selectionISBN(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            int top = i;

            for (int j = i + 1; j < books.size(); j++) {
                if (books.get(j).getIsbn().compareTo(books.get(top).getIsbn()) < 0) {
                    top = j;
                }
            }
            Collections.swap(books, i, top);
        }
    }
}
