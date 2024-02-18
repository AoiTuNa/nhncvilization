package nhn.academy.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "family_realationship")
public class FamilyRelationship {
    @EmbeddedId
    private Pk pk;

    @Column(name = "family_relationship_code")
    private Integer familyRelationshipCode;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    public static class Pk implements Serializable {
        @Column(name = "family_resident_serial_number")
        private Integer familyResidentSerialNumber;

        @ManyToOne
        @JoinColumn(name = "resident_serial_number")
        private Resident baseResidentSerialNumber;
    }

}
