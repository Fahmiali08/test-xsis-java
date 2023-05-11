package fahmi.ali.test.java.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fahmi.ali.test.java.common.ConstantUtil;
import fahmi.ali.test.java.model.MoviesModel;
import fahmi.ali.test.java.repository.MoviesRepository;
import fahmi.ali.test.java.request.MoviesRequest;
import fahmi.ali.test.java.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class MoviesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoviesService.class.getName());

    @Autowired
    MoviesRepository moviesRepository;
    public BaseResponse getAllMovies() {
        BaseResponse response = new BaseResponse();
        List<MoviesModel> moviesModels = new ArrayList<>();
        try {
            moviesModels = moviesRepository.findAll();
            response.message= ConstantUtil.SUCCESS;
            response.result= ConstantUtil.SUCCESS_STATUS;
        }catch (Exception e){
            LOGGER.error("An error occurred while retrieving the data list from the database.", e);
            response.message= ConstantUtil.FAILED;
            response.result= ConstantUtil.FAILED_STATUS;
        }
        response.payload=moviesModels;
        return response;
    }

    @Transactional
    public BaseResponse addMovie(MoviesModel moviesRequest) {
        BaseResponse response = new BaseResponse();
        try {
            moviesRepository.save(moviesRequest);
            response.message= ConstantUtil.SUCCESS;
            response.result= ConstantUtil.SUCCESS_STATUS;
        }catch (Exception e){
            LOGGER.error("An error occurred while insert the data database.", e);
            response.message= ConstantUtil.FAILED;
            response.result= ConstantUtil.FAILED_STATUS;
        }
        return response;
    }

    public BaseResponse getDetail(Long id) {
        BaseResponse response = new BaseResponse();
        MoviesModel mm = new MoviesModel();
        MoviesRequest mr = new MoviesRequest();
        try {
            mm = moviesRepository.getReferenceById(id);
            mr = MoviesRequest.convertDataToDto(mm);
            LOGGER.info("ini model {}", mm.getId());

            response.message= ConstantUtil.SUCCESS;
            response.result= ConstantUtil.SUCCESS_STATUS;
        }catch (Exception e){
            response.message= ConstantUtil.FAILED;
            response.result= ConstantUtil.FAILED_STATUS;
        }
        response.payload=mr;
        return response;
    }

    public BaseResponse updateMovie(MoviesModel moviesRequest) {
        BaseResponse response = new BaseResponse();
        try {
            moviesRepository.save(moviesRequest);
            response.message= ConstantUtil.SUCCESS;
            response.result= ConstantUtil.SUCCESS_STATUS;
        }catch (Exception e){
            LOGGER.error("An error occurred while update the data database.", e);
            response.message= ConstantUtil.FAILED;
            response.result= ConstantUtil.FAILED_STATUS;
        }
        return response;
    }

    public BaseResponse deleteMovie(Long id) {
        BaseResponse response = new BaseResponse();
        try {
            moviesRepository.deleteById(id);
            response.message= ConstantUtil.SUCCESS;
            response.result= ConstantUtil.SUCCESS_STATUS;
        }catch (Exception e){
            LOGGER.error("An error occurred while update the data database.", e);
            response.message= ConstantUtil.FAILED;
            response.result= ConstantUtil.FAILED_STATUS;
        }
        return response;
    }
}
