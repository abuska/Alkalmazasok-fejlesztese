package hu.elte.alkfejl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Author extends BaseEntity {

    @Column(nullable = false)
    private String name;
    
    @Column
    @OneToMany( mappedBy="author" )
    private List<Book> books;
    
}
