package ua.sirkostya009.shoeservice.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoeSize {
    /**
     * European shoe size
     */
    @Id
    @Column(nullable = false, updatable = false)
    private int size;
}
