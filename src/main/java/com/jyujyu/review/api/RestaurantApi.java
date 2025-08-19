package com.jyujyu.review.api;


import com.jyujyu.review.api.request.CreateAndEditRestaurantRequest;
import com.jyujyu.review.api.request.CreateAndEditRestaurantRequestMenu;
import com.jyujyu.review.api.response.RestaurantDetailView;
import com.jyujyu.review.api.response.RestaurantView;
import com.jyujyu.review.model.RestaurantEntity;
import com.jyujyu.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor // private final 는 RequiredArgs 필수임.
@RestController
public class RestaurantApi {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants(){
        return restaurantService.getAllRestaurants();
//        return List.of(RestaurantView.builder()
//            .id(0L)
//            .name("test name")
//            .address("test Address")
//            .createdAt(ZonedDateTime.now())
//            .updatedAt(ZonedDateTime.now())
//            .build());
    }

    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurants(
            @PathVariable Long restaurantId
    ){
        return restaurantService.getRestaurantDatail(restaurantId);
//        return RestaurantDetailView.builder()
//                .id(0L)
//                .name("test name")
//                .address("test Address")
//                .createdAt(ZonedDateTime.now())
//                .updatedAt(ZonedDateTime.now())
//                .menus(List.of(
//                        RestaurantDetailView.Menu.builder()
//                        .id(0L)
//                        .name("test menu name")
//                        .price(500)
//                        .createdAt(ZonedDateTime.now())
//                        .updatedAt(ZonedDateTime.now())
//                        .build()
//                ))
//                .build();

    }

    @PostMapping("restaurant")
//    public RestaurantEntity createRestaurant(@RequestBody CreateAndEditRestaurantRequest request ){
//            return restaurantService.createRestaurant(request);
    public void createRestaurant(@RequestBody CreateAndEditRestaurantRequest request ){
        //return "This is createRestaurant " + request.getName() + ", " + request.getAddress()
        //        + " menu[0].name " + request.getMenus().get(0).getName()
        //        + ", " + request.getMenus().get(0).getPrice() ;

        restaurantService.createRestaurant(request);
    }
    @PutMapping("/restaurant/{restaurantId}")
//    public String editRestaurant(@PathVariable Long restaurantId,
//                                 @RequestBody CreateAndEditRestaurantRequest request){
//        return "This is editRestaurant " +restaurantId + ", " + request.getName() + ", " + request.getAddress();
    public void editRestaurant(@PathVariable Long restaurantId,
                                 @RequestBody CreateAndEditRestaurantRequest request){
     restaurantService.editRestaurant(restaurantId, request);
    }
    @DeleteMapping("/restaurant/{restaurantId}")
//    public String deleteRestaurant(@PathVariable Long restaurantId){
//        return "This is deleteRestaurant";
    public void deleteRestaurant(@PathVariable Long restaurantId){
        restaurantService.deleteRestaurant(restaurantId);
    }




}

