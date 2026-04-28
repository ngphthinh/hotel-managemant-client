package iuh.fit.se.group1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AmenityDTO implements Serializable {
    private Long amenityId;
    private String nameAmenity;
    private BigDecimal price;
    private int quantity;

    @Override
    public String toString() {
        return nameAmenity;
    }
}
