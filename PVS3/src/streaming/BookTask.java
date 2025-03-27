package streaming;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookTask {
    static class Book{
        private int bookId;
        private String title;
        private String author;
        private List<Chapter> chapters = new ArrayList<>();


        public Book(int bookId, String title, String author, List<Chapter> chapters) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.chapters = chapters;
        }

        public void setChapters(List<Chapter> chapters) {
            this.chapters = chapters;
        }

        @Override
        public String toString() {
            return "BookID: " + bookId + ", title: " + title + ", autor" + author + " " + chapters;
        }

        public int getTotalPages() {
            int toReturn = 0;
            for (Chapter chapter : chapters){
                if (bookId == chapter.getBookID()) {
                    toReturn += chapter.getPages();
                }
            }
            return toReturn;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public List<Chapter> getChapters() {
            return chapters;
        }
    }

    static class Chapter {
        // TODO: 26.03.2025 Dodelat vse potrebne
        private int bookID;
        private int pages;

        public Chapter(int bookID, int pages) {
            this.bookID = bookID;
            this.pages = pages;
        }

        @Override
        public String toString() {
            return "Book ID: " + bookID + ", pages: " + pages;
        }

        public int getPages() {
            return pages;
        }

        public int getBookID() {
            return bookID;
        }
    }



    public static int authorPages (String author, List<Book> bookList){
        if (bookList.contains(author)){

        }
        return 0;
    }
    public static void main(String[] args) {
        try {
            List<Chapter> chapters = Files.lines(Paths.get("chapters.csv"))
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(parts -> new Chapter(
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[3])
                    ))
                    .toList();

            List<Book> books = Files.lines(Paths.get("books.csv"))
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(parts -> new Book(
                            Integer.parseInt(parts[0]),
                            parts[1],
                            parts[2],
                            chapters
                    ))
                    .toList();

            System.out.println(books);
            System.out.println("-------------");
            System.out.println(chapters);

            Map<String, Long> autorsBooks = books.stream()
                    .collect(Collectors.groupingBy(Book::getAuthor, Collectors.mapping(Book::getBookId, Collectors.counting())));
            System.out.println(autorsBooks);


            Map<String, Integer> top5ByPages = books.stream()
                    .collect(Collectors.groupingBy(Book::getTitle, Collectors.mapping(Book::getTotalPages, Collectors.summingInt(Integer::intValue))));

            Map<String, Integer> top5 = top5ByPages.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(5)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            System.out.println(top5);








        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
