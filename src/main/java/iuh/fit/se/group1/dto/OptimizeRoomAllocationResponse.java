package iuh.fit.se.group1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptimizeRoomAllocationResponse implements java.io.Serializable {

    private long usedSingleRooms;
    private long usedDoubleRooms;
    private long totalRoomsUsed;

    private long accommodatedAdults;
    private long accommodatedChildren;

    private long unaccommodatedAdults;
    private long unaccommodatedChildren;
    private long unaccommodatedGuests;
}