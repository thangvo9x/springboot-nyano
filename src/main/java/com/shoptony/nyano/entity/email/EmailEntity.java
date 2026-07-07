package com.shoptony.nyano.entity.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailEntity {

    private String emailTo;

    private String emailSubject;
    private String emailContent;

    private String emailAttachment;
}
