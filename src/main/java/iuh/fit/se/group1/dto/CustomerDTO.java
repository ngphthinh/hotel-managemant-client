package iuh.fit.se.group1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerDTO implements Serializable {
    private Long customerId;
    private String fullName;
    private String phone;
    private String email;
    private String citizenId;
    private boolean gender;
    private LocalDate dateOfBirth;
    private LocalDate createdAt;

}
