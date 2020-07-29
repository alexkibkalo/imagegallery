package com.agileengine.imagegallery.transport.mapper.page;

import com.agileengine.imagegallery.transport.dto.page.PageOutcomeDto;
import org.springframework.data.domain.Page;

import java.util.function.Function;

public interface PageMapper<T> {

    <R> PageOutcomeDto<R> toPage(Page<T> ts, Function<T, R> converter);

    <R> PageOutcomeDto<R> toPage(Page<R> ts);
}
