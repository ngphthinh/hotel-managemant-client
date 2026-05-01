package iuh.fit.se.group1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AmenityDTO implements Serializable {
    private Long amenityId;
    private String nameAmenity;
    private BigDecimal price;
    private int quantity;
    private LocalDate createdAt;


    @Override
    public String toString() {
        return nameAmenity;
    }
}
