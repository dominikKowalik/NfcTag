package com.kowalik.dominik.nfc.page_content.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * Created by dominik on 28.07.17.
 */

@Data
@Builder
@ToString
@AllArgsConstructor
public class Page {
    @Id
    @NotNull
    private Long id;

    @NotBlank
    private String header;

    @NotBlank
    private String body;
}
