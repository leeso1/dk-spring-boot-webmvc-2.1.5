package me.learning.domain.model;

public class Book {

    private String id;
    private String title;
    private String author;

    public static Book getSampleInstance() {
        return BookBuilder.aBook()
                .withId("1000")
                .withTitle("mongodb guide")
                .withAuthor("leesoch")
                .build();
    }

    public static final class BookBuilder {
        private String id;
        private String title;
        private String author;

        private BookBuilder() {
        }

        public static BookBuilder aBook() {
            return new BookBuilder();
        }

        public BookBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public BookBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public Book build() {
            Book book = new Book();
            book.id = this.id;
            book.author = this.author;
            book.title = this.title;
            return book;
        }
    }
}
