package tsweb;

import org.junit.Test;

import com.techsen.tsweb.core.util.ObjectUtil;

public class ObjectUtilTest {
    
    @Test
    public void testToString() {
        Book book = new Book();
        book.setName("Java Program");
        
        
        User user = new User();
        user.setName("Hayden");
        user.setBook(book);
        
        System.out.println(ObjectUtil.toString(user));
        
    }
    
    public static class User {
        private String name;
        private Book book;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Book getBook() {
            return book;
        }

        public void setBook(Book book) {
            this.book = book;
        }
    }

    public static class Book {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    
}
