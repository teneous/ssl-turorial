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
package com.syoka.practical.itinerary.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.syoka.practical.itinerary.api.dto.ItineraryPlan;

import feign.RequestLine;


/**
 * @author syoka
 * @version : ItineraryClient.java 2021年05月12日 12时56分
 */
public interface ItineraryClient {

    /**
     * 获取所有运输航线
     *
     * @return 所有运输航线
     */
    @GetMapping("/itinerary/list")
    @RequestLine("GET /itinerary/list")
    List<ItineraryPlan> getItinerary();
}
