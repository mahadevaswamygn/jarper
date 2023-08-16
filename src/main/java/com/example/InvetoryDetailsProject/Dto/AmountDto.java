package com.example.InvetoryDetailsProject.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
public class AmountDto {
    public String dueDate;
    public String principal;
    public String interest;
    public String emi;
    public String principals;

    public AmountDto(String dueDate, String principal, String interest, String emi, String principals) {
        this.dueDate = dueDate;
        this.principal = principal;
        this.interest = interest;
        this.emi = emi;
        this.principals = principals;
    }
}