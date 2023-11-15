package eu.luminis.searchai.web;

public record BlogPost(Integer postId, String title, String url, String updatedAt, String body, String[] tags, String[] categories) {

}
