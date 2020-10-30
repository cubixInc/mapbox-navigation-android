package com.mapbox.navigation.ui.feedback;

import com.mapbox.navigation.core.MapboxNavigation;
import com.mapbox.navigation.core.telemetry.events.AppMetadata;
import com.mapbox.navigation.core.telemetry.events.FeedbackEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * Feedback element returned by {@link FeedbackBottomSheet}.
 *
 * Should be passed to {@link MapboxNavigation#postUserFeedback(String, String, String, String, String[], AppMetadata)}
 */
public class FeedbackItem {

  @FeedbackEvent.Type
  private String feedbackType;
  private String feedbackText;
  private String description;
  private int feedbackImage;
  private Set<String> feedbackSubType;
  private String encodedScreenshot;

  public FeedbackItem(String feedbackText,
      int feedbackImage,
      @FeedbackEvent.Type
          String feedbackType,
      String description) {
    this.feedbackText = feedbackText;
    this.feedbackImage = feedbackImage;
    this.feedbackType = feedbackType;
    this.description = description;
    this.feedbackSubType = new HashSet<>();
  }

  String getFeedbackText() {
    return feedbackText;
  }

  int getFeedbackImageId() {
    return feedbackImage;
  }

  @FeedbackEvent.Type
  public String getFeedbackType() {
    return feedbackType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<String> getFeedbackSubType() {
    return this.feedbackSubType;
  }

  public String getEncodedScreenshot() {
    return encodedScreenshot;
  }

  public FeedbackItem setEncodedScreenshot(String encodedScreenshot) {
    this.encodedScreenshot = encodedScreenshot;
    return this;
  }
}
