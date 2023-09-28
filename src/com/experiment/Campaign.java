package com.experiment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class Campaign {
    private String campaignName;
    private String campaignDescription;
    private Boolean isLoaded;
}
