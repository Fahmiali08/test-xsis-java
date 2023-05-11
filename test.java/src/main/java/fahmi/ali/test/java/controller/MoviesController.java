package fahmi.ali.test.java.controller;

import fahmi.ali.test.java.common.ConstantUtil;
import fahmi.ali.test.java.model.MoviesModel;
import fahmi.ali.test.java.request.MoviesRequest;
import fahmi.ali.test.java.response.BaseResponse;
import fahmi.ali.test.java.service.MoviesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoviesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoviesController.class.getName());

    @Autowired
    MoviesService moviesService;

    /**
     * API for get all movies
     */
    @GetMapping("movies")
    public BaseResponse movies() {
        BaseResponse resp = new BaseResponse();
        try {
            resp = moviesService.getAllMovies();
        }catch (Exception e){
            LOGGER.error("An error occurred while retrieving the data list from the database.", e);
            resp.result= ConstantUtil.FAILED_STATUS;
            resp.message=ConstantUtil.FAILED;
        }
        return resp;
    }


    /**
     * API for add movies
     */
    @PostMapping("movies")
    public BaseResponse addMovies(@RequestBody MoviesModel moviesRequest) {
        BaseResponse resp = new BaseResponse();
        LOGGER.info("movies created date {}", moviesRequest.getCreatedAt());
        try {
            resp = moviesService.addMovie(moviesRequest);
        }catch (Exception e){
            LOGGER.error("An error occurred while insert the data to database.", e);
            resp.result= ConstantUtil.FAILED_STATUS;
            resp.message=ConstantUtil.FAILED;
        }
        return resp;
    }

    @GetMapping("movies/{id}")
    public BaseResponse movies(@PathVariable Long id) {
        BaseResponse resp = new BaseResponse();
        try {
            resp = moviesService.getDetail(id);
        }catch (Exception e){
            LOGGER.error("An error occurred while retrieving the data list from the database.", e);
            resp.result= ConstantUtil.FAILED_STATUS;
            resp.message=ConstantUtil.FAILED;
        }
        return resp;
    }

    @PatchMapping("movies/{id}")
    public BaseResponse updateMovies(@RequestBody MoviesModel moviesRequest, @PathVariable Long id) {
        BaseResponse resp = new BaseResponse();
        LOGGER.info("movies created date {}", moviesRequest.getCreatedAt());
        try {
            resp = moviesService.updateMovie(moviesRequest);
        }catch (Exception e){
            LOGGER.error("An error occurred while insert the data to database.", e);
            resp.result= ConstantUtil.FAILED_STATUS;
            resp.message=ConstantUtil.FAILED;
        }
        return resp;
    }

    @DeleteMapping("movies/{id}")
    public BaseResponse deleteMovies(@PathVariable Long id) {
        BaseResponse resp = new BaseResponse();
        try {
            resp = moviesService.deleteMovie(id);
        }catch (Exception e){
            resp.result= ConstantUtil.FAILED_STATUS;
            resp.message=ConstantUtil.FAILED;
        }
        return resp;
    }
}
