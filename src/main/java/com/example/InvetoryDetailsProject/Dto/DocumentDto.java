package com.example.InvetoryDetailsProject.Dto;


import lombok.Data;

@Data

public class DocumentDto {
    public String docType;
    public String docNumOrYear;

    public String originalOrPhotoCopy;

    public DocumentDto() {
    }

    public DocumentDto(String docType, String docNumOrYear, String originalOrPhotoCopy) {
        this.docType = docType;
        this.docNumOrYear = docNumOrYear;
        this.originalOrPhotoCopy = originalOrPhotoCopy;
    }


}
