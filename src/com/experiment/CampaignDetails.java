package com.experiment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class CampaignDetails {
    private String campaignName;
    private String campaignDescription;
    private Boolean isLoaded;
    private String journeyId;
    private String journeyDescription;
}
