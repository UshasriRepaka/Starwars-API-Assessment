package com.swapi.people;

import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;


public class PeopleData {

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    private List<Results> results;
    private Integer count;
    private String next;
    private String previous;

    @Override
    public String toString() {
        return "PeopleData{" +
                "results=" + results +
                ", count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                '}';
    }
}
