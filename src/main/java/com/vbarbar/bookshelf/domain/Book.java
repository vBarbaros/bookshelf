package com.vbarbar.bookshelf.domain;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

@XmlRootElement
public class Book {

	@Pattern(regexp="B[0-9]+", message="{Pattern.Book.bookId.validation}")
	private String bookId;
	
	@Size(min=4, max=50, message="{Size.Book.bookTitle.validation}")
	@NotNull(message= "{NotNull.Book.bookTitle.validation}")
    private String bookTitle;
	
    private String author;
    
    @Min(value=0, message="Min.Book.pricePerUnit.validation}") 
    @Digits(integer=8, fraction=2, message="{Digits.Book.pricePerUnit. validation}")
    @NotNull(message= "{NotNull.Book.pricePerUnit.validation}")
    private BigDecimal pricePerUnit;
    
    private String review;
    private String genre;
    private String editor;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean presentEBook;
    private String condition;
    
    @JsonIgnore
    private MultipartFile bookImage;
    
    
    public Book() {
    	super();
    }
    
    public Book(String bookId, String bookTitle, BigDecimal pricePerUnit) {
    	this.bookId = bookId;
    	this.bookTitle = bookTitle;
    	this.pricePerUnit = pricePerUnit;
    }
    
    public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public long getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
    
    @Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj == null)
    		return false;
    	if (getClass() != obj.getClass())
    		return false;
    	Book other = (Book) obj;
      	if (bookId == null) {
      		if (other.bookId != null)
      			return false;
      	} else if (!bookId.equals(other.bookId))
      		return false;
      	return true;
    }
    
    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result
          + ((bookId == null) ? 0 : bookId.hashCode());
      return result;
    }
    
    @Override
    public String toString() {
      return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + "]";
    }

	public boolean isPresentEBook() {
		return presentEBook;
	}

	public void setPresentEBook(boolean presentEBook) {
		this.presentEBook = presentEBook;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	@XmlTransient
	public MultipartFile getBookImage() {
		return bookImage;
	}

	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}
}
