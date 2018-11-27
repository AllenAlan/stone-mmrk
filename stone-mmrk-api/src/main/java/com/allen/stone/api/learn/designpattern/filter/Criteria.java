package com.allen.stone.api.learn.designpattern.filter;

import java.util.List;

public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}