package com.blackcode.springbootcurdsimple.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class RequestBook {
    @NotEmpty(message = "name not empty")
    private String bookName;

    @NotEmpty(message = "category not empty")
    private String bookCategory;

    @NotEmpty(message = "Pengarang not empty")
    private String bookPengarang;

    @NotEmpty(message = "Penerbit not empty")
    private String bookPenerbit;

    @NotEmpty(message = "Tahun Penerbit not empty")
    private Date bookTahunPenerbit;


}
