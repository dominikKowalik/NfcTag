package com.kowalik.dominik.nfc.group.domain;

import com.kowalik.dominik.nfc.nfc_tag.domain.NfcTag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by dominik on 27.07.17.
 */
@Data
@Document
@Builder
@ToString
@AllArgsConstructor
public class Branch {
    @Id
    private Long groupNumber;
    @DBRef
    private List<NfcTag> nfcTags;
}
