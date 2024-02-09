package hr.uniri.molapi.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FingerprintsRequest {

    private String fp1;
    private String fp2;
}
