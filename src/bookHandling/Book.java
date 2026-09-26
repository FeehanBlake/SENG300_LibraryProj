package bookHandling;

public class Book {
    private int book_id;
    private int goodreads_book_id;
    private int best_book_id;
    private int work_id;
    private int books_count;
    private String isbn;
    private String isbn13;
    private String authors;
    private float original_publication_year;
    private String original_title;
    private String title;
    private String language_code;
    private float average_rating;
    private int ratings_count;
    private int work_ratings_count;
    private int work_text_reviews_count;
    private int ratings_1;
    private int ratings_2;
    private int ratings_3;
    private int ratings_4;
    private int ratings_5;
    private String image_url;
    private String small_image_url;



    public Book(int book_id, int goodreads_book_id, int best_book_id, int work_id, int books_count, String isbn,
                String isbn13, String authors, float original_publication_year, String original_title, String title,
                String language_code, float average_rating, int ratings_count, int work_ratings_count,
                int work_text_reviews_count, int ratings_1, int ratings_2, int ratings_3, int ratings_4, int ratings_5,
                String image_url, String small_image_url) {
        super();
        this.book_id = book_id;
        this.goodreads_book_id = goodreads_book_id;
        this.best_book_id = best_book_id;
        this.work_id = work_id;
        this.books_count = books_count;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.authors = authors;
        this.original_publication_year = original_publication_year;
        this.original_title = original_title;
        this.title = title;
        this.language_code = language_code;
        this.average_rating = average_rating;
        this.ratings_count = ratings_count;
        this.work_ratings_count = work_ratings_count;
        this.work_text_reviews_count = work_text_reviews_count;
        this.ratings_1 = ratings_1;
        this.ratings_2 = ratings_2;
        this.ratings_3 = ratings_3;
        this.ratings_4 = ratings_4;
        this.ratings_5 = ratings_5;
        this.image_url = image_url;
        this.small_image_url = small_image_url;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getGoodreads_book_id() {
        return goodreads_book_id;
    }

    public void setGoodreads_book_id(int goodreads_book_id) {
        this.goodreads_book_id = goodreads_book_id;
    }

    public int getBest_book_id() {
        return best_book_id;
    }

    public void setBest_book_id(int best_book_id) {
        this.best_book_id = best_book_id;
    }

    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    public int getBooks_count() {
        return books_count;
    }

    public void setBooks_count(int books_count) {
        this.books_count = books_count;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public float getOriginal_publication_year() {
        return original_publication_year;
    }

    public void setOriginal_publication_year(float original_publication_year) {
        this.original_publication_year = original_publication_year;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public float getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(float average_rating) {
        this.average_rating = average_rating;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public int getWork_ratings_count() {
        return work_ratings_count;
    }

    public void setWork_ratings_count(int work_ratings_count) {
        this.work_ratings_count = work_ratings_count;
    }

    public int getWork_text_reviews_count() {
        return work_text_reviews_count;
    }

    public void setWork_text_reviews_count(int work_text_reviews_count) {
        this.work_text_reviews_count = work_text_reviews_count;
    }

    public int getRatings_1() {
        return ratings_1;
    }

    public void setRatings_1(int ratings_1) {
        this.ratings_1 = ratings_1;
    }

    public int getRatings_2() {
        return ratings_2;
    }

    public void setRatings_2(int ratings_2) {
        this.ratings_2 = ratings_2;
    }

    public int getRatings_3() {
        return ratings_3;
    }

    public void setRatings_3(int ratings_3) {
        this.ratings_3 = ratings_3;
    }

    public int getRatings_4() {
        return ratings_4;
    }

    public void setRatings_4(int ratings_4) {
        this.ratings_4 = ratings_4;
    }

    public int getRatings_5() {
        return ratings_5;
    }

    public void setRatings_5(int ratings_5) {
        this.ratings_5 = ratings_5;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getSmall_image_url() {
        return small_image_url;
    }

    public void setSmall_image_url(String small_image_url) {
        this.small_image_url = small_image_url;
    }

    /*

     CONVERTING STRINGS TO CORRECT VALUES

     */

    public Book(String[] values) {
        this(
                toInt(values[0]),
                toInt(values[1]),
                toInt(values[2]),
                toInt(values[3]),
                toInt(values[4]),
                values[5],
                values[6],
                values[7],
                toFloat(values[8]),
                values[9],
                values[10],
                values[11],
                toFloat(values[12]),
                toInt(values[13]),
                toInt(values[14]),
                toInt(values[15]),
                toInt(values[16]),
                toInt(values[17]),
                toInt(values[18]),
                toInt(values[19]),
                toInt(values[20]),
                values[21],
                values[22]
        );
    }
    private static int toInt(String s) {
        return s.isEmpty() ? 0 : (int) Double.parseDouble(s);
    }
    private static float toFloat(String s) {
        return s.isEmpty() ? 0 : (float) Double.parseDouble(s);
    }
}
