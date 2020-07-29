package com.agileengine.imagegallery.transport.dto.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageOutcomeDto<T> {

    @NotNull
    private List<? extends T> content;

    @NotNull
    private long totalElements;
}
