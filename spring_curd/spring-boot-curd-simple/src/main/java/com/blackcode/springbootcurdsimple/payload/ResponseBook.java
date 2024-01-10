package com.blackcode.springbootcurdsimple.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class ResponseBook {
    private Long id;
    private String bookName;
    private String bookCategory;
    private String bookPengarang;
    private String bookPenerbit;
    private Date bookTahunPenerbit;
}
