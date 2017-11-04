package hu.elte.alkfejl.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class BookOrder extends BaseEntity {

    @Column(nullable = false)
    @OneToMany( mappedBy="id" )
    private List<Book> book;
    
   	@ManyToOne
   	@JoinColumn(name="orderuserid", nullable=false)
    private User user;
    
    @Column(nullable = false)
    private Date orderDate;
   
    @Column
    @Enumerated(EnumType.STRING)
    private State state;

    public enum State {
        UNPROCESSED, PROCESSING, DELETED, DELIVERY, COMPLETE
    }

    
}
