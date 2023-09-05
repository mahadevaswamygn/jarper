package com.example.InvetoryDetailsProject.Dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrancheDisbursementDetails {
    public String trancheNo;
    public String trancheAmount;
    public String dateOfDisbursement;
}
