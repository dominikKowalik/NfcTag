package com.kowalik.dominik.nfc.nfc_tag.domain;

import com.kowalik.dominik.nfc.page_content.domain.Page;
import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * Created by dominik on 27.07.17.
 */

@Data
@Builder
@ToString
@AllArgsConstructor
public class NfcTag {
    @Id
    private String tagId;
    private Boolean isAdminTag;
    private Page page;
}
