package com.example.InvetoryDetailsProject.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BorrowerDetails {
    public String typeOfBorrower;
    public String borrowerName;
    public String borrowerSignature;

    public BorrowerDetails(String typeOfBorrower, String borrowerName) {
        this.typeOfBorrower = typeOfBorrower;
        this.borrowerName = borrowerName;
    }
}
