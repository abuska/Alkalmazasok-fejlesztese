package hu.elte.alkfejl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name="author", nullable = false)
    private Author author;

    @Column(nullable = false)
    private String Publisher;
    
    @Column(nullable = false)
    private Date Publish;

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    public enum Category {
        COMEDY, DRAMA, HOBBY
    }
    
    @Column
    private int Price;
    
    @Column
    private String ShortDesc;
    
    @Column
    private String LongDesc;
    
    @Column
    private State state;
    
    public enum State {
        FEATURED, NORMAL, UNAVAILABLE
    }
    
}
