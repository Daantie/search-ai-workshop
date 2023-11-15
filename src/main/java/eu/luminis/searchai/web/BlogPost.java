package eu.luminis.searchai.web;

public record BlogPost(Integer post_id, String title, String url, String updated_at, String body, String[] tags, String[] categories) {

}
