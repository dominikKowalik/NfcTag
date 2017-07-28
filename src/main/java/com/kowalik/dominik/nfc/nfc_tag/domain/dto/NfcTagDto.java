package com.kowalik.dominik.nfc.nfc_tag.domain.dto;

import com.kowalik.dominik.nfc.page_content.domain.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by dominik on 28.07.17.
 */

@Data
@Builder
@ToString
@AllArgsConstructor
public class NfcTagDto {
    private Boolean isAdminTag;
    private Page page;
}
