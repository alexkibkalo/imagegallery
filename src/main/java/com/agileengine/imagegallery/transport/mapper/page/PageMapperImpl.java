package com.agileengine.imagegallery.transport.mapper.page;

import com.agileengine.imagegallery.transport.dto.page.PageOutcomeDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PageMapperImpl<T> implements PageMapper<T> {

    @Override
    public <R> PageOutcomeDto<R> toPage(Page<T> ts, Function<T, R> converter) {
        final Page<R> page = ts.map(converter);

        return new PageOutcomeDto<>(page.getContent(), page.getTotalElements());
    }

    @Override
    public <R> PageOutcomeDto<R> toPage(Page<R> ts) {
        return new PageOutcomeDto<>(ts.getContent(), ts.getTotalElements());
    }
}
