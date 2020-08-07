package com.project.marketplace.entity;

public class UploadImageResponse {
    private String imageName;
    private String imageDownloadUri;
    private String imageType;
    private long size;

    public UploadImageResponse(String imageName, String imageDownloadUri, String imageType, long size) {
        this.imageName = imageName;
        this.imageDownloadUri = imageDownloadUri;
        this.imageType = imageType;
        this.size = size;
    }

    // Getters and Setters (Omitted for brevity)
}
