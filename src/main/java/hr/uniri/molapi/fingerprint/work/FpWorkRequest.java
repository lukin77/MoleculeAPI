package hr.uniri.molapi.fingerprint.work;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FpWorkRequest {
    String fp1;
    String fp2;
    String similarity;
    String operation;
}
