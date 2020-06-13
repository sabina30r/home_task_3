package nix.edu.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book extends AbstractEntity {

    @Column(name = "name")
    private String bookName;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_author"))
    private List<Author> authorList;

    @OneToOne (optional = true, cascade=CascadeType.ALL)
    @JoinColumn (name="review_id")
    private Review review;

    @Entity
    @Table (name = "review")
    class Review extends AbstractEntity {

        @Column(name = "review_author")
        private String reviewAuthor;

        @Column(name = "review_content")
        private String reviewContent;

        @OneToOne (optional = true, mappedBy="review")
        private Book book;


        String getReviewAuthor(){
            return reviewAuthor;
        }

        String getReviewContent(){
            return reviewContent;
         }

         void setReviewAuthor(String reviewAuthor){
            this.reviewAuthor = reviewAuthor;
         }

         void setReviewContent(String reviewContent){
            this.reviewContent = reviewContent;
         }

    }

    public Review getReview(){
         return review;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
