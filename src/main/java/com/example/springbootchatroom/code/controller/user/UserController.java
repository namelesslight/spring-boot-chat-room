package com.example.springbootchatroom.code.controller.user;

import com.example.springbootchatroom.code.entity.dto.AddActivityDto;
import com.example.springbootchatroom.code.entity.dto.AddFollowDto;
import com.example.springbootchatroom.code.entity.dto.UpdatePasswordDto;
import com.example.springbootchatroom.code.result.Result;
import com.example.springbootchatroom.code.stencil.UserStencil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserStencil userStencil;

    @PutMapping("/updateUserPassword")
    public Result updateUserPassword(@RequestHeader String Token, @RequestBody UpdatePasswordDto updatePasswordDto){
        return userStencil.updateUserPassword(Token,
                updatePasswordDto.getUserId(),
                updatePasswordDto.getOldPassword(),
                updatePasswordDto.getNewPassword(), "/updateUserPassword");
    }

    @PostMapping("/updateHeadImage")
    public Result updateHeadImage(@RequestHeader String Token,
                                  @RequestParam MultipartFile imageFile,
                                  @RequestParam String userId,
                                  @RequestParam String imagePath){

        return userStencil.updateHeadImage(Token,imageFile,userId,imagePath,"/updateHeadImage");
    }

    @PutMapping("/addActivity")
    public Result addActivity(@RequestHeader String Token,
                              @RequestBody AddActivityDto addActivityDto){
        return userStencil.addActivity(Token,addActivityDto.getContent(),
                addActivityDto.getUserId(), "/addActivity");
    }

    @PutMapping("/addActivityImage")
    public Result addActivityImage(@RequestHeader String Token,
                                   @RequestParam MultipartFile imageFile,
                                   @RequestParam String activityId,
                                   @RequestParam String userId,
                                   @RequestParam String imagePath) {
        return userStencil.addActivityImage(Token,imageFile,activityId,userId,imagePath,"/addActivityImage");
    }

    @DeleteMapping("/deleteImage")
    public Result deleteImage(@RequestHeader String Token,
                              @RequestParam String activityId,
                              @RequestParam String userId,
                              @RequestParam String imageId){
        return userStencil.deleteImage(Token,activityId,userId,imageId,"/deleteImage");
    }

    @GetMapping("/listImageByActivity")
    public Result listImageByActivity(@RequestHeader String Token,
                                      @RequestParam String activityId){
        return userStencil.listImageByActivity(Token, activityId,"/listImageByActivity");

    }

    @PostMapping("/logicalDeleteActivity")
    public Result logicalDeleteActivity(@RequestHeader String Token,
                                        @RequestParam String userId,
                                        @RequestParam String activityId){
        return userStencil.logicalDeleteActivity(Token,userId,activityId,"/logicalDeleteActivity");
    }

    @DeleteMapping("/physicalDeleteActivity")
    public Result physicalDeleteActivity(@RequestHeader String Token,
                                         @RequestParam String userId,
                                         @RequestParam String activityId){
        return userStencil.physicalDeleteActivity(Token,userId,activityId,"/physicalDeleteActivity");
    }

    @PostMapping("/recoverActivity")
    public Result recoverActivity(@RequestHeader String Token,
                                  @RequestParam String userId,
                                  @RequestParam String activityId){
        return userStencil.recoverActivity(Token,userId,activityId,"/recoverActivity");
    }

    @GetMapping ("/listDeleteActivityByUser")
    public Result listDeleteActivityByUser(@RequestHeader String Token,
                                                @RequestParam String userId,
                                                @RequestParam Integer currentPage,
                                                @RequestParam Integer size){
        return userStencil.listDeleteActivityByUser(Token,userId,currentPage,size,"/listDeleteActivityByUser");
    }

    @PutMapping("/addFollow")
    public Result addFollow(@RequestHeader String Token,
                            @RequestBody AddFollowDto addFollowDto) {
        return userStencil.addFollow(Token,
                addFollowDto.getUserId(),
                addFollowDto.getFollowerId(),"/addFollow");
    }

    @DeleteMapping("/deleteFollow")
    public Result deleteFollow(@RequestHeader String Token,
                               @RequestParam String userId,
                               @RequestParam String followerId){
        return userStencil.addFollow(Token,userId,followerId,"/deleteFollow");
    }
}
