package com.stayzilla.imageflip.bean;

/**
 * Created by Mohammed on 30/07/16.
 *
 * This act as bean class for images displayed in gridview
 */

public class ImageCard {
    private String imageUrl;
    private String imageContent;


    /**
     *
     * @param imageUrl url of image to displayed.
     * @param imageContent content of image.
     */
    public ImageCard(String imageUrl, String imageContent) {
        this.imageUrl = imageUrl;
        this.imageContent = imageContent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImageContent() {
        return imageContent;
    }
}


