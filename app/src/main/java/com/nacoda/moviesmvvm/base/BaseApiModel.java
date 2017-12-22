package com.nacoda.moviesmvvm.base;

import com.nacoda.moviesmvvm.data.model.Movie;

import java.util.List;

/**
 * Created by Mayburger on 12/22/17.
 */

public class BaseApiModel<T> {

    private int page;
    private String total_results;
    private String total_pages;
    private List<Movie> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }



}
