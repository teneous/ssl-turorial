/*
 *  Copyright (C), 2008-2021, Syoka All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.syoka.practical.itinerary.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syoka.practical.itinerary.api.ItineraryClient;
import com.syoka.practical.itinerary.api.dto.ItineraryPlan;
import com.syoka.practical.itinerary.application.ItineraryApplicationService;
import com.syoka.practical.itinerary.infrastructure.common.Result;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


/**
 * @author syoka
 * @version : ItineraryFacade.java 2021年05月12日 09时56分
 */
@RestController
@RequiredArgsConstructor
public class ItineraryFacade implements ItineraryClient {

    @NonNull
    private ItineraryApplicationService itineraryApplicationService;

    @Override
    public List<ItineraryPlan> getItinerary() {
        return itineraryApplicationService.findRouting();
    }
    /**
     * 心跳测试
     */
    @PostMapping("/heartbeat")
    public ResponseEntity<Result<String>> heartBeating() {
        return ResponseEntity.ok(Result.success());
    }

}