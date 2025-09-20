package com.service.user.service.external;

import com.service.user.model.HotelEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Hotel-Service")
public interface HotelServiceFeignClient {

    @GetMapping("/hotels/{hotelId}")
    HotelEntity getHotel(@PathVariable int hotelId);

}
