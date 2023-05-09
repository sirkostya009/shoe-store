package ua.sirkostya009.picturemicroservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sirkostya009.picturemicroservice.service.FileService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pictures")
public class PictureController {
    private final FileService service;

    @GetMapping(value = "/{fileName}.png", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] png(@PathVariable String fileName) {
        return service.bytesFor(fileName, ".png");
    }

    @GetMapping(value = "/{fileName}.jpg", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] jpg(@PathVariable String fileName) {
        return service.bytesFor(fileName, ".jpg");
    }

    @GetMapping(value = "/{fileName}.jpeg", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] jpeg(@PathVariable String fileName) {
        return service.bytesFor(fileName, ".jpeg");
    }
}
