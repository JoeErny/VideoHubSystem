package org.cnam.sample.domain.service.businessservice;


import org.cnam.sample.domain.entity.Video;
import org.cnam.sample.domain.service.unitservice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BrowsingService {

    @Autowired
    CategoryService categoryService;

    public List<Video> findAllVideosByCategoryId(Long categoryId) {
        List<Video> videosFound = new ArrayList<Video>();
        List<VideoModel> videosModelsFound = new ArrayList<VideoModel>();
        videosModelsFound = videoRepository.findAllByCategory(new CategoryModel(categoryId));
        for (VideoModel videoModel : videosModelsFound
             ) {
            videosFound.add(new Video(videoModel.getId(), videoModel.getTitle(), videoModel.getLink(),videoModel.getCategory().getId()));
        }
        return videosFound;
    }

}
