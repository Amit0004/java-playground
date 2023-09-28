package com.experiment;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class StreamsExperiment {

    public static void main(String[] args) {
        List<Campaign> campaignList = new ArrayList<Campaign>();
        Campaign campaign1 = Campaign.builder()
                .campaignName("campaign1")
                .campaignDescription("campaignDescription")
                .isLoaded(false)
                .build();
        Campaign campaign2 = Campaign.builder()
                .campaignName("campaign2")
                .campaignDescription("campaignDescription")
                .isLoaded(false)
                .build();
        campaignList.add(campaign1);
        campaignList.add(campaign2);

        List<CampaignDetails> output = campaignList.stream()
                .map(StreamsExperiment::createCampaign)
                .map(c -> StreamsExperiment.convertToCampaignDetails(c, "streamJourneyId"))
                .toList();
        output.forEach(campaign -> System.out.println(campaign.toString()));
    }

    private static Campaign createCampaign(@NonNull final Campaign campaign) {
        return Campaign.builder()
                .campaignName(campaign.getCampaignName())
                .campaignDescription(campaign.getCampaignDescription())
                .isLoaded(true)
                .build();
    }

    private static Campaign assignCampaignDescription(@NonNull final String description, Campaign campaign) {
        campaign.setCampaignDescription(description);
        return campaign;
    }

    private static CampaignDetails convertToCampaignDetails(@NonNull final Campaign campaign, @NonNull final String journeyId) {
        return CampaignDetails.builder()
                .campaignName(campaign.getCampaignName())
                .campaignDescription(campaign.getCampaignDescription())
                .isLoaded(true)
                .journeyId(journeyId)
                .journeyDescription("SampleJourneyDescription")
                .build();
    }


}
