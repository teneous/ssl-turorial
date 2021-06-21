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
package com.syoka.practical.itinerary.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.syoka.practical.itinerary.api.dto.ItineraryPlan;
import com.syoka.practical.itinerary.domain.itinerary.service.ItineraryDomainService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


/**
 * 货运Application服务
 *
 * @author syoka
 * @version : ItineraryApplicationService.java 2021年05月12日 12时56分
 */
@Service
@RequiredArgsConstructor
public class ItineraryApplicationService {

    @NonNull
    private ItineraryDomainService itineraryDomainService;

    /**
     * 路线查找
     */
    public List<ItineraryPlan> findRouting() {
        return itineraryDomainService.findRouting();
    }
}
