package com.agileengine.imagegallery.controller;

import com.agileengine.imagegallery.service.image.ImageService;
import com.agileengine.imagegallery.transport.dto.image.ImageFindDto;
import com.agileengine.imagegallery.transport.dto.image.ImageLimitedOutcomeDto;
import com.agileengine.imagegallery.transport.dto.image.ImageOutcomeDto;
import com.agileengine.imagegallery.transport.dto.page.PageOutcomeDto;
import com.agileengine.imagegallery.transport.mapper.page.PageMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Setter(onMethod_ = @Autowired)
@Api(value = "ImageController", description = "REST API for Images", tags = {"Image"})
@RequestMapping(path = "interview.agileengine.com/images", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ImageController {

    private PageMapper<ImageOutcomeDto> pageMapper;
    private ImageService imageService;

    @ApiOperation(notes = "ADMIN, USER", value = "getAll", nickname = "getImages")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Not valid dto"),
            @ApiResponse(code = 401, message = "Not correct token"),
            @ApiResponse(code = 403, message = "User doesn't have permission"),
            @ApiResponse(code = 404, message = "Not correct data"),
    })
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public PageOutcomeDto<ImageLimitedOutcomeDto> getAll(@PageableDefault Pageable pageable) {
        return pageMapper.toPage(imageService.getAll(pageable));
    }

    @ApiOperation(notes = "ADMIN, USER", value = "getImageById", nickname = "getImageById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Not valid dto"),
            @ApiResponse(code = 401, message = "Not correct token"),
            @ApiResponse(code = 403, message = "User doesn't have permission"),
            @ApiResponse(code = 404, message = "Not correct data"),
    })
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public ImageOutcomeDto getById(@PathVariable Long id) {
        return imageService.getById(id);
    }
}
