package ua.sirkostya009.shoeservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.sirkostya009.shoeservice.annotation.UserId;
import ua.sirkostya009.shoeservice.annotation.Username;
import ua.sirkostya009.shoeservice.dto.DetailedShoeDto;
import ua.sirkostya009.shoeservice.dto.ReviewDto;
import ua.sirkostya009.shoeservice.dto.ReviewPostDto;
import ua.sirkostya009.shoeservice.dto.ShortShoeDto;
import ua.sirkostya009.shoeservice.service.ShoeService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shoes")
public class ShoeController {
    private final ShoeService service;

    @GetMapping
    public Page<ShortShoeDto> all(@RequestParam(required = false, defaultValue = "0") int page) {
        return service.findAll(page).map(ShortShoeDto::of);
    }

    @GetMapping("/{id}")
    public DetailedShoeDto shoe(@PathVariable UUID id) {
        return DetailedShoeDto.of(service.findById(id));
    }

    @GetMapping("/{id}/reviews")
    public Page<ReviewDto> comments(@PathVariable UUID id,
                                    @RequestParam(required = false, defaultValue = "0") int page) {
        return service.findAllReviews(id, page).map(ReviewDto::of);
    }

    @PostMapping("/{id}/reviews")
    @PreAuthorize("hasAuthority('SCOPE_ADD_COMMENTS')")
    public ReviewDto postComment(@PathVariable UUID id,
                                 @UserId String uid,
                                 @Username String username,
                                 @RequestBody ReviewPostDto dto) {
        return ReviewDto.of(service.addReview(id, uid, username, dto));
    }
}
