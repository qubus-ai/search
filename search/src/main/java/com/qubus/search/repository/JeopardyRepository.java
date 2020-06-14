package com.qubus.search.repository;

import java.util.List;

public interface JeopardyRepository {

    List<Jeopardy> findAll();

    boolean save(Jeopardy jeopardy);
}
